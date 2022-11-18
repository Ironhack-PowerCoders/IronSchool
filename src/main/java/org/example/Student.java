package org.example;

public class Student {
    /*    Student:
    >String studentId (auto-generated) - PM (->private member)´
    > String name - PM
    > String address - PM
    > String email - PM
    > Course course (nullable) -PM
    constructor (String name, String addres, String email)
    getters + setters
    Atributos opcionales si son necesarios para la estructura del codigo.     */
    private String studentId;
    private String nameSurname;
    private String address;
    private String email;
    private Course course;
    private static int counter = 0;

    public Student(String nameSurname, String address, String email, Course course) {
        setNameSurname(nameSurname);
        setStudentId(nameSurname, course);
        setAddress(address);
        setEmail(email);
        setCourse();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String name, Course course) {
        String[] nameSurnameSplited = nameSurname.split(" ");
            String time;
            String courseTime = course.getTime().toLowerCase();
            if (courseTime.equals("mañana")) {
                time = "1";
            } else if (courseTime.equals("tarde")) {
                time = "2";
            } else time = "3";

            this.studentId = "SJAVA" + nameSurnameSplited[0].split("")[0].toUpperCase() +
                    nameSurnameSplited[1].split("")[0].toUpperCase() + course.getGrade() + "0" + time + 22+ counter;
            counter++;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) throws IllegalArgumentException{
        String[] nameSurnameSplited = nameSurname.split(" ");
        if (nameSurnameSplited.length == 2) this.nameSurname = nameSurname;
        else throw new IllegalArgumentException("Tiene que dar nombre y apellido separados por un expacio señor.");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse() {
        this.course = null;
    }
}