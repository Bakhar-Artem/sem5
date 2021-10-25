package by.bakhar.lab3.swing;

import by.bakhar.lab3.listener.*;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;


public class CustomFrame extends JFrame {
    private CustomFrameField frameField;
    private JList<String> methodJList;
    private JPanel paramsPanel;

    public CustomFrame() {
        super("Session");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new ExitFileListener(this));
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(new Dimension(500, 350));
        frameField = new CustomFrameField();
        frameField.setLocale("locale", new Locale("ru"));
        JMenuBar bar = new JMenuBar();
        addMenuBar(bar);
        addLanguageMenuBar(bar);
        setJMenuBar(bar);
        addExecutePanel();
        setVisible(true);
    }

    private void addMenuBar(JMenuBar bar) {
        JMenu jMenu = frameField.getjMenu();
        JMenuItem option = frameField.getOpenFileMenu();
        option.addActionListener(new OpenFileMenuButtonListener(this));
        jMenu.add(option);
        bar.add(jMenu);

    }

    private void addLanguageMenuBar(JMenuBar bar) {
        JMenu jMenu = frameField.getjMenuLocale();
        JMenuItem english = frameField.getEnglishLocale();
        english.addActionListener(new EnglishLocaleListener(this));
        jMenu.add(english);
        JMenuItem russian = frameField.getRussianLocale();
        russian.addActionListener(new RussianLocaleListener(this));
        jMenu.add(russian);
        bar.add(jMenu);
    }

    private void addExecutePanel() {
        JPanel executePanel = new JPanel();
        executePanel.setLayout(new BorderLayout());
        methodJList = new JList<>();
        methodJList.addListSelectionListener(new SelectionListListener(this));
        executePanel.add(methodJList, BorderLayout.WEST);
        JButton executeButton = frameField.getExecuteButton();
        executeButton.addActionListener(new ExecuteButtonListener(this));
        executePanel.add(executeButton, BorderLayout.SOUTH);
        paramsPanel = new JPanel();

        JPanel firstPanel = new JPanel();
        JLabel firstParameterLabel = frameField.getFirstParameterLabel();
        JTextField firstParameter = frameField.getFirstParameter();
        firstPanel.add(firstParameterLabel);
        firstPanel.add(firstParameter);
        firstPanel.setVisible(false);

        JPanel secondPanel = new JPanel();
        JLabel secondParameterLabel = frameField.getSecondParameterLabel();
        JTextField secondParameter = frameField.getSecondParameter();
        secondPanel.add(secondParameterLabel);
        secondPanel.add(secondParameter);
        secondPanel.setVisible(false);

        JPanel thirdPanel = new JPanel();
        JLabel thirdParameterLabel = frameField.getThirdParameterLabel();
        JTextField thirdParameter = frameField.getThirdParameter();
        thirdPanel.add(thirdParameterLabel);
        thirdPanel.add(thirdParameter);
        thirdPanel.setVisible(false);


        JPanel resultPanel = new JPanel();
        JLabel resultParameterLabel = frameField.getResult();
        JTextField resultParameter = frameField.getResultText();
        resultParameter.setEnabled(false);
        resultPanel.add(resultParameterLabel);
        resultPanel.add(resultParameter);
        resultPanel.setVisible(false);
        paramsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        paramsPanel.add(firstPanel);
        paramsPanel.add(secondPanel);
        paramsPanel.add(thirdPanel);
        paramsPanel.add(resultPanel);

        executePanel.add(paramsPanel, BorderLayout.EAST);
        add(executePanel);
    }

    public CustomFrameField getFrameField() {
        return frameField;
    }

    public JList<String> getMethodJList() {
        return methodJList;
    }

    public JPanel getParamsPanel() {
        return paramsPanel;
    }
}
