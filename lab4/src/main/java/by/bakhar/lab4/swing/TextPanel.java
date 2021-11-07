package by.bakhar.lab4.swing;

import by.bakhar.lab4.listener.ExecuteButtonListener;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea jTextArea;

    public TextPanel(CustomFrame frame) {
        jTextArea = new JTextArea();
        setLayout(new BorderLayout());
        JButton executeButton = new JButton("refactoring");
        executeButton.addActionListener(new ExecuteButtonListener(frame));
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScrollPane, BorderLayout.CENTER);
        add(executeButton, BorderLayout.SOUTH);
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }
}
