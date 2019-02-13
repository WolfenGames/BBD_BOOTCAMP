package za.co.bbd.lab;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
public class BasicHumanTest {
    Student Julian = new Student("Julian", 1944, "18-01-1993");

    @Test
    public void whenCreateStudentGetNameDisplayJulian(){
        assertTrue(Julian.getName().equals("Julian"));
    }

    @Test
    public void whenCreateStudentIDDisplay1944(){
        assertEquals((Integer)1944, Julian.getStudentNumber());
    }

    @Test
    public void whenCreateStudentDOBDisplayDOBas18011993(){
        assertTrue(Julian.getDob().equals("18-01-1993"));
    }

    @Test
    public void whenCourseCreatedAddStudentJulianAndSeeIfExists(){
        Course c = new Course("Java Bootcmap", 28);
        assertTrue(c.enrollStudent(Julian));
    }

    @Test
    public void whenAddNewCourseJavaBootcampValidateName(){
        Course c = new Course("Java Bootcamp", 1);
        assertTrue(c.getName().equals("Java Bootcamp"));
    }

}
