package by.bakhar.lab2.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 0;
    private String surname;
    private Integer group;
    private Map<String, Integer> sessionResults = null;
    private Double averageMark = 0.;

    private Student(String surname, int group, Map<String, Integer> sessionResults) {
        this.surname = surname;
        this.group = group;
        this.sessionResults = sessionResults;
        if (sessionResults != null) {
            double average = sessionResults.values().stream().mapToDouble(mark -> mark).sum();
            averageMark = average / sessionResults.size();
        }
    }

    public static class StudentBuilder {
        public static Student build(String surname, int group, Map<String, Integer> sessionResults) {
            Student student = new Student(surname, group, sessionResults);
            return student;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Map<String, Integer> getSessionResults() {
        return sessionResults;
    }

    public void setSessionResults(Map<String, Integer> sessionResults) {
        this.sessionResults = sessionResults;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Student ").append(surname).append(", ");
        stringBuilder.append("group ").append(group).append(", ");
        if (sessionResults != null) {
            stringBuilder.append("session ").append(sessionResults);
        }
        stringBuilder.append("average ").append(averageMark).append(";");
        return stringBuilder.toString();
    }
}
