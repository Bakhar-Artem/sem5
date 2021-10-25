package by.bakhar.lab3.listener;

import by.bakhar.lab3.swing.CustomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class EnglishLocaleListener implements ActionListener {
    private static final String BUNDLE_NAME = "locale";
    private static final String LOCALE = "en";
    private CustomFrame frame;


    public EnglishLocaleListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getFrameField().setLocale(BUNDLE_NAME, new Locale(LOCALE));
    }
}
