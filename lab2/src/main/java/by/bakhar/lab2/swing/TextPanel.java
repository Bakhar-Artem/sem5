package by.bakhar.lab2.swing;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.listener.SortButtonListener;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JList<Student> studentInfo;

    public TextPanel(CustomFrame frame) {
        setLayout(new BorderLayout());
        studentInfo = new JList<>();
        JButton sortButton = new JButton("sort by group");
        sortButton.addActionListener(new SortButtonListener(frame));
        JScrollPane jScrollPane = new JScrollPane(studentInfo);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane, BorderLayout.CENTER);
        add(sortButton, BorderLayout.SOUTH);
    }

    public JList<Student> getStudentInfo() {
        return studentInfo;
    }
}
