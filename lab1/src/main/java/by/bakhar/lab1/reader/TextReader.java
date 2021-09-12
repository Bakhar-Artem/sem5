package by.bakhar.lab1.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReader {
    public String readTextFromTxt(String filepath) throws IOException {
        String text = Files.readString(Path.of(filepath));
        return text;
    }
}
