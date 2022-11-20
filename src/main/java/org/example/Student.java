package org.example;

import java.util.HashMap;
import java.util.Map;

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
    private static int counter = 0;

    private Map<String,Course> studentCourseMap;

    public Student(String nameSurname, String address, String email) {
        setNameSurname(nameSurname);
        setStudentId(nameSurname);
        setAddress(address);
        setEmail(email);
        setStudentCourseMap();

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String name) {
        String[] nameSurnameSplited = name.split(" ");

            this.studentId = "SJAVA" + nameSurnameSplited[0].split("")[0].toUpperCase() +
                    nameSurnameSplited[1].split("")[0].toUpperCase() + "0" + 22+ counter;
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


    public Map<String, Course> getStudentCourseMap() {
        return studentCourseMap;
    }

    public void setStudentCourseMap() {
        this.studentCourseMap = new HashMap<>();
    }
}