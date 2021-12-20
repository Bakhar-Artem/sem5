package by.bakhar.lab1.service;

import by.bakhar.lab1.exception.EncryptException;

public interface EncryptService {
    String encrypt(String text) throws EncryptException;

}
