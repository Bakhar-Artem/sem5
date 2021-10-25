package by.bakhar.lab3.swing;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class CustomFrameField {


    private final JMenu jMenu = new JMenu();
    private final JMenuItem openFileMenu = new JMenuItem();

    private final JMenu jMenuLocale = new JMenu();
    private final JMenuItem englishLocale = new JMenuItem();
    private final JMenuItem russianLocale = new JMenuItem();


    private final JButton executeButton = new JButton();

    private final JLabel firstParameterLabel = new JLabel();
    private final JTextField firstParameter = new JTextField();


    private final JLabel secondParameterLabel = new JLabel();
    private final JTextField secondParameter = new JTextField();

    private final JLabel thirdParameterLabel = new JLabel();
    private final JTextField thirdParameter = new JTextField();

    private final JLabel result = new JLabel();
    private final JTextField resultText = new JTextField();

    public void setLocale(String bundle_name, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle_name, locale);
        jMenu.setText(resourceBundle.getString(FieldName.FIELD_MENU));
        openFileMenu.setText(resourceBundle.getString(FieldName.MENU_OPEN));
        executeButton.setText(resourceBundle.getString(FieldName.EXECUTE_BUTTON));
        jMenuLocale.setText(resourceBundle.getString(FieldName.LANGUAGE_OPTION));
        englishLocale.setText(resourceBundle.getString(FieldName.ENGLISH_OPTION));
        russianLocale.setText(resourceBundle.getString(FieldName.RUSSIAN_OPTION));
        firstParameterLabel.setText(resourceBundle.getString(FieldName.FIRST_PARAMETER));
        secondParameterLabel.setText(resourceBundle.getString(FieldName.SECOND_PARAMETER));
        thirdParameterLabel.setText(resourceBundle.getString(FieldName.THIRD_PARAMETER));
        result.setText(resourceBundle.getString(FieldName.RESULT_PARAMETER));

    }

    public JMenu getjMenu() {
        return jMenu;
    }

    public JMenuItem getOpenFileMenu() {
        return openFileMenu;
    }

    public JButton getExecuteButton() {
        return executeButton;
    }

    public JMenu getjMenuLocale() {
        return jMenuLocale;
    }

    public JMenuItem getEnglishLocale() {
        return englishLocale;
    }

    public JMenuItem getRussianLocale() {
        return russianLocale;
    }

    public JLabel getFirstParameterLabel() {
        return firstParameterLabel;
    }

    public JTextField getFirstParameter() {
        return firstParameter;
    }

    public JLabel getSecondParameterLabel() {
        return secondParameterLabel;
    }

    public JTextField getSecondParameter() {
        return secondParameter;
    }

    public JLabel getThirdParameterLabel() {
        return thirdParameterLabel;
    }

    public JTextField getThirdParameter() {
        return thirdParameter;
    }

    public JLabel getResult() {
        return result;
    }

    public JTextField getResultText() {
        return resultText;
    }
}
