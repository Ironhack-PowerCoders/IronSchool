package org.example;

import java.util.HashMap;
import java.util.Map;

public class Course {
    /*   >String courseId (auto-generated) - Private member)
    > String name - private member
    > double price - private member
    > double money_earned -private member
    > Teacher teacher (nullable) - private member
    constructor (String name, double price)
    getters + setters
    Atributos opcionales si son necesarios para la estructura del codigo.   */

    private String courseId;
    private String name;
    private double price;
    private double money_earned = 0.00;
    private Teacher teacher = null;
    private String time;
    private int grade;

    private Map<String,Student> courseStudentMap;

    public Course(String name, double price, String time, int grade) {
        setCourseId(name,time,grade);
        setName(name);
        setPrice(price);
        setTeacher();
        setGrade(grade);
        setTime(time);
        setCourseStudentMap();

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String name, String time, int grade) {
        String courseTime = time.toLowerCase();
        if(courseTime.equals("mañana")){
            time = "1";
        } else if (courseTime.equals("tarde")) {
            time = "2";
        }else time = "3";

        //PRIMERO VA DOS PRIMERAS LETRAS DEL CURSO, EL GRADO, UN SEPARADOR 0, EL HORARIO (1,2,3) Y EL AÑO
        this.courseId = name.split("")[0].toUpperCase() +name.split("")[1].toUpperCase() + grade + "0"+ time  + 22;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double coursePrice) {
        this.money_earned += coursePrice;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher() {
        this.teacher = null;
    }

    public Map<String, Student> getCourseStudentMap() {
        return courseStudentMap;
    }

    public void setCourseStudentMap() {
        this.courseStudentMap = new HashMap<>();
    }
}
