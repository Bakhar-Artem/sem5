package by.bsu.bakhar.service;


import by.bsu.bakhar.exception.EncryptException;

public interface EncryptService {
    String encrypt(String text) throws EncryptException;

}
