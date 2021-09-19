package by.bakhar.lab2.observer;

import by.bakhar.lab2.exception.FrameObserverException;

public interface CustomFrameObserver {
    void updateView(CustomFrameEvent frameEvent) throws FrameObserverException;
}
