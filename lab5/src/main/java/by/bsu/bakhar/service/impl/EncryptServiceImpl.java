package by.bsu.bakhar.service.impl;


import by.bsu.bakhar.exception.EncryptException;
import by.bsu.bakhar.service.EncryptService;

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
