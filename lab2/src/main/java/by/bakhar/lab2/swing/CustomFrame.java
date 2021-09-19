package by.bakhar.lab2.swing;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.exception.FrameObserverException;
import by.bakhar.lab2.listener.ExitFileListener;
import by.bakhar.lab2.observer.CustomFrameEvent;
import by.bakhar.lab2.observer.CustomFrameObservable;
import by.bakhar.lab2.observer.CustomFrameObserver;
import by.bakhar.lab2.observer.impl.CustomFrameObserverImpl;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomFrame extends JFrame implements CustomFrameObservable {
    private List<Student> studentList;
    private boolean studentChanged = false;
    private File file = null;
    private TextPanel panel;
    private List<CustomFrameObserver> observers = new ArrayList<>();

    public CustomFrame() {
        super("Session");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new ExitFileListener(this));
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 350));
        addMenuBar();
        addTextPanel();
        setVisible(true);
        observers.add(new CustomFrameObserverImpl());
    }

    private void addMenuBar() {
        JMenuBar jMenuBar = new MenuBar(this);
        setJMenuBar(jMenuBar);
    }

    private void addTextPanel() {
        TextPanel textPanel = new TextPanel(this);
        panel = textPanel;
        add(textPanel);
    }

    public TextPanel getPanel() {
        return panel;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) throws FrameObserverException {
        this.studentList = studentList;
        notifyObservers();
    }

    public boolean getStudentChanged() {
        return studentChanged;
    }

    public void setStudentChanged(boolean studentChanged) {
        this.studentChanged = studentChanged;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void attach(CustomFrameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(CustomFrameObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws FrameObserverException {
        CustomFrameEvent event = new CustomFrameEvent(this);
        for (CustomFrameObserver observer : observers) {
            observer.updateView(event);
        }
    }
}
