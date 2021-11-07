package by.bakhar.lab4.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomReader {
    public String readFromTxt(String txtFilePath) throws IOException {
        String contents = Files.readString(Path.of(txtFilePath));
        return contents;
    }
}
