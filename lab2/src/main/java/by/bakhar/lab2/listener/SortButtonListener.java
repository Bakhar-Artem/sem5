package by.bakhar.lab2.listener;

import by.bakhar.lab2.exception.FrameObserverException;
import by.bakhar.lab2.service.SortService;
import by.bakhar.lab2.swing.CustomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortButtonListener implements ActionListener {
    private final CustomFrame frame;

    public SortButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SortService sortService = new SortService();
        try {
            frame.setStudentList(sortService.sortByGroup(frame.getStudentList()));
        } catch (FrameObserverException exception) {
            exception.printStackTrace();
        }
    }
}
