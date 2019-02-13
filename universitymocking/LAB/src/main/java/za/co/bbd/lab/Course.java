package za.co.bbd.lab;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Course {
    private String name;
    private ArrayList<Student> students;
    private Integer capacity;
    private static Integer numberOfCourses = 0;

    public Course(String name, int cap){
        this.name = name;
        this.capacity = cap;
        numberOfCourses++;
        students = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean enrollStudent(Student student){
        //TODO: CHECK IF STUDENT ALREADY ENROLLED
        return (this.students.add(student));
    }

    public boolean unenrollStudent(Student student) {
        return (this.students.remove(student));
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}