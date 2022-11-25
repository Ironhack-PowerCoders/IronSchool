package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    //preparación de color para la terminal
    public static final String ANSI_RESET = "\u001B[0m"; public static final String ANSI_YELLOW = "\u001B[33m"; public static final String ANSI_PURPLE = "\u001B[35m"; public static final String ANSI_CYAN = "\u001B[36m";

// Menu de la terminal
    public static void main(String[] args) throws IOException {


        School school = new School(null);
        boolean schoolNameIsCorrect = false;
        Scanner input = new Scanner(System.in);
        int num;
        int counter = 0;



        System.out.println(ANSI_CYAN +"== Welcome to our new APP to manage your school system. ==\n "+ ANSI_RESET);
        //System.out.println("first try");
        //schoolNameIsCorrect = input.nextLine();
        System.out.println(ANSI_CYAN+ "== Please insert the name of your institution: =="+ ANSI_RESET);
        school.setSchoolName(input.nextLine());
        System.out.println(ANSI_CYAN+ "== is " + school.getSchoolName() + " correct? Type true or false to confirm. =="+ ANSI_RESET);
        while (schoolNameIsCorrect == false) {
            String response = input.nextLine();
            if (response.equalsIgnoreCase("true")) {
                schoolNameIsCorrect = true;
            } else {
                System.out.println(ANSI_CYAN+ "== Please insert the name of your institution: =="+ ANSI_RESET);
                school.setSchoolName(input.nextLine());
                System.out.println(ANSI_CYAN+"== is " + school.getSchoolName() + " correct? Type true or false to confirm. =="+ ANSI_RESET);
            }
        }


//==Creación de Curso==


        System.out.println(ANSI_CYAN+"== Welcome to " + school.getSchoolName() + "=="+ " \n== How many courses has this institution? =="+ ANSI_RESET);
        num = Integer.parseInt(input.nextLine());
        while (counter != num) {
            System.out.println(ANSI_CYAN+"== Name the course. =="+ ANSI_RESET);
            String name = input.nextLine();
            System.out.println(ANSI_CYAN+"== Price the knowledge. =="+ ANSI_RESET);
            Double price = Double.valueOf(input.nextLine());
            System.out.println(ANSI_CYAN+"== Choose the schedule:  == \n 1.morning. \n 2.afternoon. \n 3.night. "+ ANSI_RESET);
            int time = Integer.parseInt(input.nextLine());
            String horario;
            if (time == 1) horario = "morning";
            else if (time == 2) horario = "afternoon";
            else if (time == 3) horario = "night";
            else throw new IOException();
            System.out.println(ANSI_CYAN+"== Enter the grade of the course. =="+ ANSI_RESET);
            int year = Integer.parseInt(input.nextLine());
            school.addCourse(new Course(name, price, horario, year));
            counter++;
        }
        counter = 0;

// ==Creación de Profesores==

        System.out.println(ANSI_CYAN+"== Welcome to " + school.getSchoolName() +  " == \n== How many teachers are in this institution? =="+ ANSI_RESET);
        num = Integer.parseInt(input.nextLine());
        while (counter != num) {
            String name = null;
            while (name == null){
                System.out.println(ANSI_CYAN+"== Name the teacher, please Name and Surname. =="+ ANSI_RESET);
                name = input.nextLine();
                try{
                    if(name.split( " ").length != 2) throw new IllegalArgumentException("Please press the space bar after the name.");
                }catch (IllegalArgumentException e){
                    name = null;
                    System.err.println(e.getMessage());
                }
            }

            System.out.println(ANSI_CYAN+"== How much the teacher will earn. =="+ ANSI_RESET);
            Double price = Double.valueOf(input.nextLine());
            Course course = null;
            while (course ==null){
            System.out.println(ANSI_CYAN+"== Enter the ID =="+ ANSI_RESET);
            school.getCourseMap().forEach((key, value) -> {
                System.out.println(ANSI_CYAN+"== "+key + ": Name " + value.getName() + " ||| time: " + value.getTime()+"." + " ||| grade: "+ value.getGrade()+"."+ ANSI_RESET);
            });
             String courseId = input.nextLine();
             course = Commands.lookupCourses(school,courseId);
           if (course == null ){ System.err.println("The Course ID selected doesn't exist.");}

            }
            school.addTeacher(new Teacher(name, price, course));
            counter++;
        }
        counter = 0;

        //==Creación de alumnos==

        System.out.println(ANSI_CYAN+"== Welcome to " + school.getSchoolName() + "\nHow many inmates are in this institution? =="+ ANSI_RESET);
        num= Integer.parseInt(input.nextLine());
        while (counter != num) {
            String name = null;
            while (name == null){
                System.out.println(ANSI_CYAN+"== Insert your Name and Surname. =="+ ANSI_RESET);
                name = input.nextLine();
                try{
                    if(name.split( " ").length != 2) throw new IllegalArgumentException("Please press the space bar after the name.");
                }catch (IllegalArgumentException e){
                    name = null;
                    System.err.println(e.getMessage());
                }
            }
            System.out.println(ANSI_CYAN+"== Please, give us the address to send you all the merch. =="+ ANSI_RESET);
            String address = input.nextLine();
            System.out.println(ANSI_CYAN+"== Enter the e-mail. =="+ ANSI_RESET);
            String email = input.nextLine();
            school.addStudent(new Student(name, address,email));
            counter++;
        }
        counter = 0;

//==Pagina 1 de comandos==
        boolean exit = false;
        System.out.println(ANSI_YELLOW+"== ||COMMANDS AVAILABLES|| ==\n" +ANSI_RESET+
                ANSI_CYAN+"== ENROLL: This command will help enroll the student specified in the corresponding course. While also updating the money_earned of that course based on its price. == \n" +ANSI_RESET+
                        ANSI_PURPLE+"== ASSIGN: This command will help assign the teacher specified to the corresponding course. == \n" +ANSI_RESET+
                        ANSI_CYAN+"== SHOW COURSES: This command will display a list of all courses. == \n" +ANSI_RESET+
                        ANSI_PURPLE+"== LOOKUP COURSE: This command will display the full details of the specified course. == \n"+ANSI_RESET +
                        ANSI_CYAN+"== SHOW STUDENTS: This command will display a list of all students. == \n"+ANSI_RESET +
                        ANSI_PURPLE+"== NEXT PAGE: Show the next commands. ==\n"+ANSI_RESET +
                        ANSI_CYAN+"== EXIT: LEAVE THE APP. == "+ANSI_RESET);
        do{


            String inputCommands= input.nextLine();

            switch (inputCommands.toUpperCase()){
                case "ENROLL":
                    Commands.enroll(school, insertStudentId(school), insertCourseId(school) );
                    break;

                    /// En este caso sirve para "reasignar" el profesor al curso, no modificará la IP generada para el profesor.
                case "ASSIGN":
                    Commands.assign(school, insertTeacherId(school), insertCourseId(school));
                    break;

                case "SHOW COURSES":
                    Commands.showCourses(school);
                    break;

                case "LOOKUP COURSE":
                    Commands.lookupCourses(school, insertCourseId(school));
                    break;

                case "SHOW STUDENTS":
                    Commands.showStudents(school);
                    break;

                case "LOOKUP STUDENTS":
                    Commands.lookupStudents(school, insertStudentId(school));
                    break;

                case "SHOW TEACHERS":
                    Commands.showTeachers(school);
                    break;

                case "LOOKUP TEACHER":
                    Commands.lookupTeachers(school, insertTeacherId(school));
                    break;

                case "SHOW PROFIT":
                    Commands.showProfit(school);
                    break;
                case "NEXT PAGE":
                    System.out.println(ANSI_CYAN+"== LOOKUP STUDENT: This command will display the full details of the specified student. == \n"+ ANSI_RESET +
                            ANSI_PURPLE+"== SHOW TEACHERS: This command will display a list of all teachers. == \n"+ ANSI_RESET +
                            ANSI_CYAN+"== LOOKUP TEACHER: This command will display the full details of the specified teacher. == \n"+ ANSI_RESET +
                            ANSI_PURPLE+"== SHOW PROFIT: This command will calculate (The total money earned from all courses) - (The sum of all the teachers’ salaries) and return the result. == \n"+ ANSI_RESET +
                            ANSI_CYAN+"== PREVIOUS PAGE: Show the previous page of commands. ==\n"+ ANSI_RESET +
                            ANSI_PURPLE+"== EXIT: LEAVE THE APP. == "+ ANSI_RESET);
                    break;
                case "PREVIOUS PAGE":
                    System.out.println(ANSI_CYAN+"== ENROLL: This command will help enroll the student specified in the corresponding course. While also updating the money_earned of that course based on its price. == \n" +ANSI_RESET+
                            ANSI_PURPLE+"== ASSIGN: This command will help assign the teacher specified to the corresponding course. == \n" +ANSI_RESET+
                            ANSI_CYAN+"== SHOW COURSES: This command will display a list of all courses. == \n" +ANSI_RESET+
                            ANSI_PURPLE+"== LOOKUP COURSE: This command will display the full details of the specified course. == \n"+ANSI_RESET +
                            ANSI_CYAN+"== SHOW STUDENTS: This command will display a list of all students. == \n"+ANSI_RESET +
                            ANSI_PURPLE+"== NEXT PAGE: Show the next commands. ==\n"+ANSI_RESET +
                            ANSI_CYAN+"== EXIT: LEAVE THE APP. == "+ANSI_RESET);
                    break;

                case "EXIT":
                    System.out.println(ANSI_CYAN+"== Thank you for using our system, see you Space Cowboy. =="+ ANSI_RESET);
                    exit = true;
                    break;
            }
        }
        while(!exit);
    }

    public static String insertTeacherId(School school){
        String teacherId;
        Scanner input = new Scanner(System.in);
        System.out.println(ANSI_CYAN+"== Insert the teacher ID. =="+ANSI_RESET);
        school.getTeacherMap().forEach((key,value)->
                System.out.println(key+": " + value.getName()) );
        teacherId = input.nextLine();
        return teacherId;
    }

    public static String insertCourseId(School school){
        String courseId;
        Scanner input = new Scanner(System.in);
        System.out.println(ANSI_CYAN+"== Insert the course ID. =="+ANSI_RESET);
        school.getCourseMap().forEach((key,value)->
                System.out.println(key+": " + value.getName()+ " " + value.getTime()+ " " + value.getGrade()) );
        courseId = input.nextLine();
        return courseId;
    }

    public static String insertStudentId(School school){
        String studentId;
        Scanner input = new Scanner(System.in);
        System.out.println(ANSI_CYAN+"== Insert the student ID. =="+ANSI_RESET);
        school.getStudentMap().forEach((key,value)->
                System.out.println(key+": " + value.getNameSurname()) );
        studentId = input.nextLine();
        return studentId;
    }
}