package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

       /*
       ##Funcionamiento App
        1 ask user "name" for the "School" [String schoolName]
        2 ask user number of "Teachers" to create [array teachers]
        3 user enters details of each Teacher (Scanner)
        4 user insert number of "courses" [array courses]
        5 user enter details of each Course (Scanner)
        6 user enters number of "students" to create [array students]
        7 user enter details of each student (scanner)
        8 User has to chose between ACTIONS:
        */

        School school = new School(null);
        boolean schoolNameIsCorrect = false;
        Scanner input = new Scanner(System.in);
        int num;
        int counter = 0;

        System.out.println("Welcome to our new APP to manage your school system \n ");
        //System.out.println("first try");
        //schoolNameIsCorrect = input.nextLine();
        System.out.println("Please insert the name of your institution:");
        school.setSchoolName(input.nextLine());
        System.out.println("is " + school.getSchoolName() + " correct? Type true or false to confirm");
        while (schoolNameIsCorrect == false) {
            String response = input.nextLine();
            if (response.equalsIgnoreCase("true")) {
                schoolNameIsCorrect = true;
            } else {
                System.out.println("Please insert the name of your institution:");
                school.setSchoolName(input.nextLine());
                System.out.println("is " + school.getSchoolName() + " correct? Type true or false to confirm");
            }
        }

        System.out.println("Welcome to " + school.getSchoolName() + "\n \n How many courses has this institution?");
        num = Integer.parseInt(input.nextLine());
        while (counter != num) {
            System.out.println("Name the course");
            String name = input.nextLine();
            System.out.println("Price the knowledge ");
            Double price = Double.valueOf(input.nextLine());
            System.out.println("Choose the schedule: \n 1.morning \n 2.afternoon \n 3.night");
            int time = Integer.parseInt(input.nextLine());
            String horario;
            if (time == 1) horario = "morning";
            else if (time == 2) horario = "afternoon";
            else if (time == 3) horario = "night";
            else throw new IOException();
            System.out.println("enter the grade of the course");
            int year = Integer.parseInt(input.nextLine());
            school.addCourse(new Course(name, price, horario, year));
            counter++;
        }
        counter = 0;


        System.out.println("Welcome to " + school.getSchoolName() + "\nHow many teachers are in this institution?");
        num = Integer.parseInt(input.nextLine());
        while (counter != num) {
            System.out.println("Name the torturer, please Name and Surname.");
            String name = input.nextLine();
            System.out.println("How much the teacher will earn.");
            Double price = Double.valueOf(input.nextLine());
            System.out.println("Enter the ID");
            school.getCourseMap().forEach((key, value) -> {
                System.out.println(key + ": Name " + value.getName() + ", time " + value.getTime() + " and grade "+ value.getGrade()+".");
            });
            String course = input.nextLine();
            school.addTeacher(new Teacher(name, price, school.getCourseMap().get(course)));
            counter++;
        }
        counter = 0;

        System.out.println("Welcome to " + school.getSchoolName() + "\nHow many inmates are in this institution?");
        num= Integer.parseInt(input.nextLine());
        while (counter != num) {
            System.out.println("Insert your Name and Surname.");
            String name = input.nextLine();
            System.out.println("Please, give us the address to send you all the merch.");
            String address = input.nextLine();
            System.out.println("Enter the e-mail");
            String email = input.nextLine();
            school.addStudent(new Student(name, address,email));
            counter++;
        }
        counter = 0;

        boolean exit = false;

        do{
            System.out.println("What do you wanna do? \n" +
                    "ENROLL [STUDENT_ID] [COURSE_ID]: This command will help enroll the student specified in the corresponding course. While also updating the money_earned of that course based on its price\n" +
                    "ASSIGN [TEACHER_ID] [COURSE_ID]: This command will help assign the teacher specified to the corresponding course\n" +
                    "SHOW COURSES: This command will display a list of all courses\n" +
                    "LOOKUP COURSE [COURSE_ID]: This command will display the full details of the specified course\n" +
                    "SHOW STUDENTS: This command will display a list of all students\n" +
                    "LOOKUP STUDENT [STUDENT_ID]: This command will display the full details of the specified student\n" +
                    "SHOW TEACHERS: This command will display a list of all teachers\n" +
                    "LOOKUP TEACHER [TEACHER_ID]: This command will display the full details of the specified teacher\n" +
                    "SHOW PROFIT: This command will calculate (The total money earned from all courses) - (The sum of all the teachers’ salaries) and return the result\n" +
            "EXIT: LEAVE THE APP");

            String inputCommands= input.nextLine();

            switch (inputCommands.toUpperCase()){
                case "ENROLL":
                    String studentId;
                    String courseId;

                    System.out.println("Insert the student ID");
                   school.getStudentMap().forEach((key,value)->
                           System.out.println(key+": " + value.getNameSurname()) );
                     studentId = input.nextLine();
                    System.out.println("Insert the course ID");
                    school.getCourseMap().forEach((key,value)->
                            System.out.println(key+": " + value.getName()+ " " + value.getTime()+ " " + value.getGrade()) );
                    courseId = input.nextLine();


                    Commands.enroll(school, studentId, courseId );
                    break;

                    /// revisar si nos interesa este comando ya que ya asignamos el profesor al curso des del inicio
                case "ASSIGN":
                    String teacherId;

                    System.out.println("Insert the teacher ID");
                    school.getTeacherMap().forEach((key,value)->
                            System.out.println(key+": " + value.getName()) );
                    teacherId = input.nextLine();
                    System.out.println("Insert the course ID");
                    school.getCourseMap().forEach((key,value)->
                            System.out.println(key+": " + value.getName()+ " " + value.getTime()+ " " + value.getGrade()) );
                    courseId = input.nextLine();


                    Commands.assign(school, teacherId, courseId );
                    break;

                case "SHOW COURSES":
                    Commands.showCourses(school);
                    break;

                case "LOOKUP COURSE":
                    System.out.println("Insert the course ID");
                    school.getCourseMap().forEach((key,value)->
                            System.out.println(key+": " + value.getName()+ " " + value.getTime()+ " " + value.getGrade()) );
                    courseId = input.nextLine();

                    Commands.lookupCourses(school,courseId);
                    break;

                case "SHOW STUDENTS":
                    Commands.showStudents(school);
                    break;

                case "LOOKUP STUDENTS":
                    System.out.println("Insert the student ID");
                    school.getStudentMap().forEach((key,value)->
                            System.out.println(key+": " + value.getNameSurname()) );
                    studentId = input.nextLine();

                    Commands.lookupStudents(school, studentId);
                    break;

                case "SHOW TEACHERS":
                    Commands.showTeachers(school);
                    break;

                case "LOOKUP TEACHER":
                    System.out.println("Insert the teacher ID");
                    school.getTeacherMap().forEach((key,value)->
                            System.out.println(key+": " + value.getName()) );
                    teacherId = input.nextLine();

                    Commands.lookupTeachers(school, teacherId);
                    break;

                case "SHOW PROFIT":
                    Commands.showProfit(school);
                    break;

                case "EXIT":
                    exit=true;
                    break;

            }
        }
        while(!exit);


    }
}