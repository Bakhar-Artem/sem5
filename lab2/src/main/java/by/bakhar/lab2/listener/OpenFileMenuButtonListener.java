package by.bakhar.lab2.listener;


import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.exception.FrameObserverException;
import by.bakhar.lab2.exception.StudentDataException;
import by.bakhar.lab2.parser.ParserConstants;
import by.bakhar.lab2.parser.StudentParser;
import by.bakhar.lab2.reader.StudentReader;
import by.bakhar.lab2.swing.CustomFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OpenFileMenuButtonListener implements ActionListener {
    private static final String NAME_FILTER = "Text file(.txt)";
    private static final String EXTENSION_FILTER = "txt";
    private final CustomFrame frame;

    public OpenFileMenuButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser("src/main/resources");
        jFileChooser.setFileFilter(new FileNameExtensionFilter(NAME_FILTER, EXTENSION_FILTER));
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String message = "File " + jFileChooser.getSelectedFile() + " was chosen";
            frame.setFile(jFileChooser.getSelectedFile());
            JOptionPane.showMessageDialog(jFileChooser, message, "Success", JOptionPane.PLAIN_MESSAGE);
            StudentReader studentReader = new StudentReader();
            StudentParser studentParser = new StudentParser();
            List<Student> students = new ArrayList<>();
            try {
                List<String> strings = studentReader.readFromTxt(jFileChooser.getSelectedFile().toString());
                for (String studentLine : strings) {
                    Object[] data = studentParser.parseFromTxt(studentLine);
                    String surname = (String) data[ParserConstants.SURNAME_POS];
                    Integer group = (Integer) data[ParserConstants.GROUP_POS];
                    Map<String, Integer> session = (TreeMap<String, Integer>) data[ParserConstants.SESSION_POS];
                    Student student = Student.StudentBuilder.build(surname, group, session);
                    students.add(student);
                }
                frame.setStudentList(students);
            } catch (IOException ioException) {
                String errorMessage = "Reading is impossible";
                JOptionPane.showMessageDialog(null, errorMessage, "Fail", JOptionPane.PLAIN_MESSAGE);
            } catch (StudentDataException | FrameObserverException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Fail", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}
