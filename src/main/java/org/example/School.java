package org.example;

import java.util.HashMap;
import java.util.Map;

public class School {

    private String schoolName;
    private Map<String,Student> studentMap;
    private Map<String,Teacher> teacherMap;
    private Map<String,Course> courseMap;

    public School(String schoolName) {
        setSchoolName(schoolName);
        setCourseMap();
        setStudentMap();
        setTeacherMap();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap() {
        this.studentMap = new HashMap<>();
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap() {
        this.teacherMap = new HashMap<>();
    }

    public Map<String, Course> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap() {
        this.courseMap = new HashMap<>();
    }

    public void addStudent(Student student){
        this.studentMap.put(student.getStudentId(),student);
    }

    public void addCourse(Course course) {
        this.courseMap.put(course.getCourseId(),course);
    }

    public void addTeacher(Teacher teacher) {
        this.teacherMap.put(teacher.getTeacherId(),teacher);
    }
}
