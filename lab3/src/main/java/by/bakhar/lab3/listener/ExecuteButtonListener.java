package by.bakhar.lab3.listener;

import by.bakhar.lab3.swing.CustomFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ExecuteButtonListener implements ActionListener {
    private static final String PARAMS = "params";
    private static final String CLASS_NAME = "class";
    private static final String PROP_PATH = "src/main/resources/function/calc.properties";
    private static final Properties properties;
    private final CustomFrame frame;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(PROP_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ExecuteButtonListener(CustomFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String func = frame.getMethodJList().getSelectedValue();
        if (func != null) {
            String func_params = func + "_" + PARAMS;
            String func_class = func + "_" + CLASS_NAME;
            try {
                Method method = Class.forName(properties.getProperty(func_class)).getMethod(properties.getProperty(func));
                Object result =  method.invoke(null);
                frame.getFrameField().getResultText().setText(result.toString());
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

        }

    }
}
