package by.bakhar.lab2.listener;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.swing.CustomFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExitFileListener implements WindowListener {
    private final CustomFrame frame;

    public ExitFileListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (frame.getStudentChanged()) {
            int n = JOptionPane.showConfirmDialog(null, "Save before exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                List<Student> studentList = frame.getStudentList();
                try (FileWriter fileWriter = new FileWriter(frame.getFile())) {
                    for (Student student : studentList) {
                        fileWriter.write(student.toString());
                    }

                    frame.setStudentChanged(false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
