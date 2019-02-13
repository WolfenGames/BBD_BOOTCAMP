package za.co.bbd.lab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntermediateTests {
    static ArrayList<Course> courses = new ArrayList<Course>();

    static {
        courses.add(new Course("Java Bootcamp", 29));
        courses.add(new Course("C# Bootcamp", 29));
        courses.add(new Course("ASP.NET Bootcamp", 30));
        courses.add(new Course("ASP.NET Bootcamp WEBAPI", 12));
    }

    @Test
    public void whenCountCoursesReturn4() {
        assertEquals(4, courses.size());
    }

}
