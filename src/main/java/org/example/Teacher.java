package org.example;

import java.util.HashMap;
import java.util.Map;

public class Teacher {
    /*
    >String teacherId (auto-generated)-Private member
    >String name -Private member
    >double salary - private member
    constructor: (String name, double salary)
    getter + setters
    Atributos opcionales si son necesarios para la estructura del codigo.     */
    private String teacherId;
    private String name;
    private double salary;
    private static int counter = 0;

    private Map<String,Course> teacherCourseMap;


    public Teacher(String name, double salary, Course course) {
        setName(name);
        setSalary(salary);
        setTeacherId(course, name);
        setTeacherCourseMap();
    }

    public String getTeacherId() {
        return teacherId;
    }

    /*
    "TJAVA20122"
    Primera letra es para profesor o alumno
    - Java es porque el course es de Java // añadimos las iniciales de nombre y apellido.
    - el 2 es para marcar el curso  // el 0 para separar
    - el 1 es por la mañana (tiempo)
    - filaniza con el año
     */
    public void setTeacherId(Course course, String name) {
        String time;
        String courseTime = course.getTime().toLowerCase();
        if(courseTime.equals("mañana")){
            time = "1";
        } else if (courseTime.equals("tarde")) {
            time = "2";
        }else time = "3";

        this.teacherId = "TJAVA" + name.split(" ")[0].split("")[0].toUpperCase() +
                name.split(" ")[1].split("")[0].toUpperCase() + course.getGrade() + "0" + time + 22 + counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        String[] nameSplited = name.split(" ");
        if ( nameSplited.length == 2) this.name = name;
        else throw new IllegalArgumentException("Tiene que dar nombre y apellido separados por un expacio señor.");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Map<String, Course> getTeacherCourseMap() {
        return teacherCourseMap;
    }

    public void setTeacherCourseMap() {
        this.teacherCourseMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", Course Assign to the Teacher=" + teacherCourseMap +
                '}';
    }
}
