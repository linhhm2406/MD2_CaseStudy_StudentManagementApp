package dataManagement;

import entity.*;
import java.util.ArrayList;

public class StudentManagement {
    public ArrayList<Student> studentList = new ArrayList<>();
    public ArrayList<Student> searchingList = new ArrayList<>();


    public StudentManagement() {
    }

    public Student getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}