package by.bakhar.lab2.observer;

import by.bakhar.lab2.exception.FrameObserverException;

public interface CustomFrameObservable<T extends CustomFrameObserver> {
    void attach(T observer);

    void detach(T observer);

    void notifyObservers() throws FrameObserverException;
}
