package by.bakhar.lab2.service;

import by.bakhar.lab2.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class SortService {
    public List<Student> sortByGroup(List<Student> studentList) {
        Set<Integer> groupSet = new HashSet<>();
        studentList.forEach(student -> groupSet.add(student.getGroup()));
        Map<Double, Integer> groupRate = new TreeMap<>((o1, o2) -> -Double.compare(o1, o2));
        Map<Integer, Double> groupRate2 = new TreeMap<>();
        List<List<Student>> groupsOfStudents = new ArrayList<>();
        groupSet.forEach(group -> groupsOfStudents.add((studentList.stream().filter(student -> student.getGroup().equals(group) && !student.getSurname().equals("Group")).collect(Collectors.toList()))));
        for (List<Student> list : groupsOfStudents) {
            double average = 0;
            int group = 0;
            for (Student student : list) {
                average += student.getAverageMark();
                group = student.getGroup();
            }
            average /= list.size();
            groupRate.put(average, group);
            groupRate2.put(group, average);
        }
        List<Student> result = new ArrayList<>();
        groupRate.values()
                .forEach(group -> {
                    result.addAll(studentList.stream().filter(student -> student.getGroup().equals(group) && !student.getSurname().equals("Group"))
                            .sorted((o1, o2) -> -Double.compare(o1.getAverageMark(), o2.getAverageMark()))
                            .collect(Collectors.toList()));
                    Student groupStat = Student.StudentBuilder.build("Group", group, null);
                    groupStat.setAverageMark(groupRate2.get(group));
                    result.add(groupStat);
                });
        return result;
    }

}
