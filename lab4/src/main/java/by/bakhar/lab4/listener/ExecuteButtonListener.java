package by.bakhar.lab4.listener;

import by.bakhar.lab4.swing.CustomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteButtonListener implements ActionListener {
    private static final String COMMENT_REGEX = "/\\*(.*\\n*\\r*(\\r\\n)*\\u2028*\\u2029*\\u0085*)*\\*/";
    private final CustomFrame frame;


    public ExecuteButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = frame.getPanel().getjTextArea().getText();
        if (!text.isBlank()) {
            Pattern pattern = Pattern.compile(COMMENT_REGEX);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                text = text.replace(text.substring(matcher.start(), matcher.end()), "");
                matcher = pattern.matcher(text);
            }
            frame.getPanel().getjTextArea().setText(text);
        }
    }
}