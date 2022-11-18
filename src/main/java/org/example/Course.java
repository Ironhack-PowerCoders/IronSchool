package org.example;

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

    public Course(String name, double price, String time, int grade) {
        setCourseId();
        setName(name);
        setPrice(price);
        setMoney_earned();
        setTeacher();
        setGrade(grade);
        setTime(time);
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

    public void setCourseId() {
        this.courseId = courseId;
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

    public void setMoney_earned() {
        this.money_earned = 0.0;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher() {
        this.teacher = null;
    }
}
