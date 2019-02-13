package za.co.bbd.lab;

public class Student {
    private String name;
    private Integer studentNumber;
    private String dob;

    public Student(String name, Integer studentNumber, String dob) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
