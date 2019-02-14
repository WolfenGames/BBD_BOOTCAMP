package za.co.bbd.university;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class UniversityController {

    static List<Student> students = Collections.synchronizedList(new LinkedList<>());
    static List<Course> courses = Collections.synchronizedList(new LinkedList<>());


    static {
        students.add(new Student("Julian", "Wolf", 15115209, "1993-01-18"));
        students.add(new Student("Michael", "Morarane", 1, "1994-01-10"));

        courses.add(new Course("JavaBootcamp", 200));
    }

    @RequestMapping(value = "/Student/fetch/StudentNumber/{studentNumber}", method = RequestMethod.GET)
    public List<Student> fetchStudentByStudentNumber(@PathVariable Integer studentNumber) {
        return students.stream()
                .filter(s -> s.getStudentNumber().equals(studentNumber))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/Student/fetch/LastName/{lastName}", method = RequestMethod.GET)
    public List<Student> fetchStudentByLastName(@PathVariable String lastName) {
        return students.stream()
                .filter(s -> s.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/Student/fetch/FirstName/{firstName}", method = RequestMethod.GET)
    public List<Student> fetchStudentByFirstName(@PathVariable String firstName) {
        return students.stream()
                .filter(s -> s.getFirstName().contains(firstName))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/Student/fetch/Name/", method = RequestMethod.GET)
    public List<Student> fetchStudent() {
        return students;
    }

    @RequestMapping(value = "/Student/add/", method = RequestMethod.POST)
    public ResponseEntity<String> addStudent(@RequestBody Student s) {
        if (!students.stream()
                .map(Student::getStudentNumber)
                .filter(n -> n == s.getStudentNumber())
                .findAny()
                .isPresent()) {
            students.add(s);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @RequestMapping(value = "/Student/Delete/{studentNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<String> addStudent(@PathVariable Integer studentNumber) {
        students.remove(
                students.stream()
                        .filter(s -> s.getStudentNumber().equals(studentNumber))
                        .findFirst()
                        .get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleting " + studentNumber.toString());//.build();
    }

    @RequestMapping(value = "/Student/Update/{studentNumber}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody Student s, @PathVariable Integer studentNumber)
    {
        Student oldStudent = students.stream().filter(n -> n.getStudentNumber().equals(studentNumber)).findFirst().get();
        if (oldStudent != null)
        {
            s.setStudentNumber(studentNumber);
            students.remove(oldStudent);
            students.add(s);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        System.out.println("DA FUK!");
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
