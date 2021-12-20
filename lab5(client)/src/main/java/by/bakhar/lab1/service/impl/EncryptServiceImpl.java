package by.bakhar.lab1.service.impl;

import by.bakhar.lab1.exception.EncryptException;
import by.bakhar.lab1.service.EncryptService;


public class EncryptServiceImpl implements EncryptService {
    private final static int KEY = 42;

    @Override
    public String encrypt(String text) throws EncryptException {
        if (text == null || text.isBlank()) {
            throw new EncryptException("bad text");
        }

        char[] symbols = text.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] ^= KEY;
        }
        return String.copyValueOf(symbols);
    }

}
