package by.bakhar.lab4.listener;

import by.bakhar.lab4.swing.CustomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteButtonListener implements ActionListener {
    private static final String COMMENT_REGEX = "(?s)/\\*.*?\\*/";
    private static final String TEXT_REGEX = "(?s)\".*?\"";
    private static final String REVERSE_TEXT_REGEX = "_m\\d+M_";
    private final CustomFrame frame;


    public ExecuteButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = frame.getPanel().getjTextArea().getText();
        if (!text.isBlank()) {
            Queue<String> textInText = new LinkedList<>();
            Pattern pattern = Pattern.compile(TEXT_REGEX);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                textInText.add(text.substring(matcher.start(), matcher.end()));
                text = text.replace(text.substring(matcher.start(), matcher.end()), "_m" + textInText.size() + "M_");
                matcher = pattern.matcher(text);
            }
            pattern = Pattern.compile(COMMENT_REGEX);
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                text = text.replace(text.substring(matcher.start(), matcher.end()), "");
                matcher = pattern.matcher(text);
            }
            pattern=Pattern.compile(REVERSE_TEXT_REGEX);
            matcher=pattern.matcher(text);
            while (matcher.find()){
                text=text.replace(text.substring(matcher.start(),matcher.end()), Objects.requireNonNull(textInText.poll()));
                matcher=pattern.matcher(text);
            }
            frame.getPanel().getjTextArea().setText(text);
        }
    }
}