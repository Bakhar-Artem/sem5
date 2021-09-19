package by.bakhar.lab2.parser;

import by.bakhar.lab2.exception.StudentDataException;

import java.util.Map;
import java.util.TreeMap;

public class StudentParser {
    private static final String DELIMITER = "\s";

    public Object[] parseFromTxt(String student) throws StudentDataException {
        String[] data = student.split(DELIMITER);
        Object[] studentData = new Object[3];
        try {
            studentData[ParserConstants.SURNAME_POS] = data[ParserConstants.SURNAME_POS];
            int group = Integer.parseInt(data[ParserConstants.GROUP_POS]);
            if (group <= 0) {
                throw new StudentDataException("bad group");
            }
            studentData[ParserConstants.GROUP_POS] = group;
            Map<String, Integer> session = new TreeMap<>();
            for (int i = ParserConstants.SESSION_POS; i < data.length; i = i + 2) {
                String subject = data[i];
                int mark = Integer.parseInt(data[i + 1]);
                if (mark <= 0 || mark > 10) {
                    throw new StudentDataException("bad mark " + mark);
                }
                session.put(subject, mark);
            }
            studentData[ParserConstants.SESSION_POS] = session;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            throw new StudentDataException("invalid data", exception);
        }
        return studentData;
    }
}
