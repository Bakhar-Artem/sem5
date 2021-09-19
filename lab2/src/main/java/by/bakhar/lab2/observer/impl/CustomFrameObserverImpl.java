package by.bakhar.lab2.observer.impl;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.exception.FrameObserverException;
import by.bakhar.lab2.observer.CustomFrameEvent;
import by.bakhar.lab2.observer.CustomFrameObserver;
import by.bakhar.lab2.swing.CustomFrame;

import javax.swing.*;
import java.util.List;

public class CustomFrameObserverImpl implements CustomFrameObserver {
    @Override
    public void updateView(CustomFrameEvent frameEvent) throws FrameObserverException {
        CustomFrame frame = frameEvent.getSource();
        if (frame.getStudentList().isEmpty() || frame.getStudentList() == null) {
            throw new FrameObserverException("No student");
        }
        JList<Student> jList = frame.getPanel().getStudentInfo();
        List<Student> students = frame.getStudentList();
        StringBuilder stringBuilder = new StringBuilder();
        DefaultListModel<Student> defaultListModel = new DefaultListModel<>();
        for (Student student : students) {
            stringBuilder.append(student).append("\n");
            defaultListModel.addElement(student);
        }
        jList.setModel(defaultListModel);
    }
}
