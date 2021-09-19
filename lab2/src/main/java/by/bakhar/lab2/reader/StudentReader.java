package by.bakhar.lab2.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
    public List<String> readFromTxt(String txtFilePath) throws IOException {
        List<String> students = new ArrayList<>();
        Files.lines(Paths.get(txtFilePath), StandardCharsets.UTF_8).forEach(students::add);
        return students;
    }
}
