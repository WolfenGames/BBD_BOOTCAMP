package za.co.bbd.exercises1;

class Person {
    String firstName, lastName;
    int age;
    private Address adress;

    public Person(String a, String b, int value) {
        firstName = a;
        lastName = b;
        age = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return adress;
    }

    public void setAddress(Address adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}