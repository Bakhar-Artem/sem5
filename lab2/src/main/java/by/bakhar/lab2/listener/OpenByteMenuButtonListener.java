package by.bakhar.lab2.listener;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.exception.FrameObserverException;
import by.bakhar.lab2.swing.CustomFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenByteMenuButtonListener implements ActionListener {
    private static final String NAME_FILTER = "Text file(.txt)";
    private static final String EXTENSION_FILTER = "txt";
    private final CustomFrame frame;

    public OpenByteMenuButtonListener(CustomFrame frame) {
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
            List<Student> studentList = new ArrayList<>();
            try (FileInputStream fileInputStream = new FileInputStream(frame.getFile().toString());
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                for (; ; ) {
                    Student student = (Student) objectInputStream.readObject();
                    studentList.add(student);
                }

            } catch (EOFException exception) {
                JOptionPane.showMessageDialog(jFileChooser, "File was read!", "Success", JOptionPane.PLAIN_MESSAGE);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            try {
                frame.setStudentList(studentList);
            } catch (FrameObserverException exception) {
                JOptionPane.showMessageDialog(jFileChooser, "Troubles with data", "Fail", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
