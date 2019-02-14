package za.co.bbd.university;

import java.util.List;

public class Course {
    private List<Student> enrolledStudents;
    private String courseName;
    private final int totalCourseCount;


    public Course(String courseName, int totalCourseCount) {
        this.courseName = courseName;
        this.totalCourseCount = totalCourseCount;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourseCount() {
        return totalCourseCount;
    }
}
