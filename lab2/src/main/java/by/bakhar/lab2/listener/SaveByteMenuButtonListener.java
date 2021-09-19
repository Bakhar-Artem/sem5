package by.bakhar.lab2.listener;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.swing.CustomFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveByteMenuButtonListener implements ActionListener {
    private static final String NAME_FILTER = "Text file(.txt)";
    private static final String EXTENSION_FILTER = "txt";
    private final CustomFrame frame;

    public SaveByteMenuButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser("src/main/resources");
        jFileChooser.setFileFilter(new FileNameExtensionFilter(NAME_FILTER, EXTENSION_FILTER));
        int result = jFileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(jFileChooser.getSelectedFile().toString() + "." + EXTENSION_FILTER);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                List<Student> studentList = frame.getStudentList();
                for (Student student : studentList) {
                    if (!student.getSurname().equals("Group")) ;
                    objectOutputStream.writeObject(student);
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
