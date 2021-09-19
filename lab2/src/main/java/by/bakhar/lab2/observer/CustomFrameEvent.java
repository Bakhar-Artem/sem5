package by.bakhar.lab2.observer;

import by.bakhar.lab2.swing.CustomFrame;

import java.util.EventObject;

public class CustomFrameEvent extends EventObject {
    public CustomFrameEvent(Object source) {
        super(source);
    }

    @Override
    public CustomFrame getSource() {
        return (CustomFrame) super.getSource();
    }
}
