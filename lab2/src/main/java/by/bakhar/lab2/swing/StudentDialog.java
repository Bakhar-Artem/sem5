package by.bakhar.lab2.swing;

import by.bakhar.lab2.entity.Student;
import by.bakhar.lab2.exception.FrameObserverException;
import by.bakhar.lab2.exception.StudentDataException;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentDialog extends JDialog {
    private String surname;
    private int group;
    private Map<String, Integer> session = new TreeMap<>();
    private final CustomFrame frame;


    public StudentDialog(CustomFrame frame) throws StudentDataException {
        super(frame);
        this.frame = frame;
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JPanel panel2 = new JPanel(new FlowLayout());
        JTextField name = new JTextField(15);
        JTextArea surnames = new JTextArea("surname");
        panel2.add(surnames);
        panel2.add(name);

        JPanel panel1 = new JPanel(new FlowLayout());
        JTextField indic = new JTextField(15);
        JTextArea indicator = new JTextArea("group");
        panel1.add(indicator);
        panel1.add(indic);


        JPanel panel3 = new JPanel(new FlowLayout());
        JTextField sub = new JTextField(15);
        JTextArea subjects = new JTextArea("subject");
        panel3.add(subjects);
        panel3.add(sub);


        JPanel panel4 = new JPanel(new FlowLayout());
        JTextField mark = new JTextField(15);
        JTextArea marks = new JTextArea("mark");
        panel4.add(marks);
        panel4.add(mark);

        panel.add(panel2);
        panel.add(panel1);
        panel.add(panel3);
        panel.add(panel4);
        add(panel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        JButton addSubject = new JButton("Add subject");
        JButton saveStudent = new JButton("Save student");
        buttonPanel.add(addSubject);
        buttonPanel.add(saveStudent);
        add(buttonPanel, BorderLayout.SOUTH);

        addSubject.addActionListener(e -> {
            try {
                String subject = sub.getText();
                int markStudent = Integer.parseInt(mark.getText());
                if (markStudent > 0 && markStudent <= 10) {
                    session.put(subject, markStudent);
                    JOptionPane.showMessageDialog(null, subject + " " + markStudent + " was add!");
                } else {
                    throw new StudentDataException("wrong data!");
                }
            } catch (StudentDataException exception) {
                exception.printStackTrace();
            }
        });
        saveStudent.addActionListener(e -> {
            try {
                surname = name.getText();
                group = Integer.parseInt(indic.getText());
                if (group <= 0) {
                    throw new StudentDataException("wrong group");
                }
                List<Student> studentList = frame.getStudentList();
                studentList.add(Student.StudentBuilder.build(surname, group, session));
                frame.setStudentList(studentList);
                JOptionPane.showMessageDialog(null, "Student was add!");
            } catch (NumberFormatException | StudentDataException | FrameObserverException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            } finally {
                dispose();
            }
        });
        setVisible(true);
        pack();
    }
}

