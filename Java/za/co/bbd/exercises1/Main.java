package za.co.bbd.exercises1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person pers = new Person("Jim", "Knopf", 31);
        pers.setAge(32);
        System.out.println(pers);
        Address address = new Address();
        address.setCity("Heidelberg");
        address.setCountry("Germany");
        address.setNumber("104");
        address.setPostalCode("69214");
        address.setStreet("Musterstr.");
        pers.setAddress(address);
        address = null;
        pers.getAddress().setNumber("105");
        System.out.println(pers.getAddress());
        // Convert from int to String
        String s1 = String.valueOf(10); // "10"
        System.out.println(s1);
        // Convert from double to String
        String s2 = String.valueOf(Math.PI); // "3.141592653589793"
        System.out.println(s2);
        // Convert from boolean to String
        String s3 = String.valueOf(1 < 2); // "true"
        System.out.println(s3);
        // Convert from date to String
        String s4 = String.valueOf(new Date()); // "Tue Jun 03 14:40:38 CEST 2003"
        System.out.println(s4);
    }
}