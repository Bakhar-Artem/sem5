package by.bakhar.lab2.listener;

import by.bakhar.lab2.exception.StudentDataException;
import by.bakhar.lab2.swing.CustomFrame;
import by.bakhar.lab2.swing.StudentDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentButtonListener implements ActionListener {
    private final CustomFrame frame;

    public AddStudentButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            StudentDialog studentDialog=new StudentDialog(frame);
        } catch (StudentDataException exception) {
            exception.printStackTrace();
        }
    }
}
