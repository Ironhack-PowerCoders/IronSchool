package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
        int numberCourses;
        int numTeacher;
        int counter = 0;

        System.out.println("Welcome to our new APP to manage your school system \n ");
        //System.out.println("first try");
        //schoolNameIsCorrect = input.nextLine();
        while (schoolNameIsCorrect == false){
            String response = input.nextLine();
            if(response.equalsIgnoreCase("true")){
                schoolNameIsCorrect = true;
            }else{
                System.out.println(  "Please insert the name of your institution:");
                school.setSchoolName(input.nextLine());
                System.out.println("is " + school.getSchoolName() + " correct? Type true or false to confirm");
            }
        }

        System.out.println("Welcome to " + school.getSchoolName() + "\n \n How many courses has this institution?");
        numberCourses = Integer.parseInt(input.nextLine());
        while(counter != numberCourses){
            System.out.println(" ");
            String name = input.nextLine();
            System.out.println(" ");
            Double price = Double.valueOf(input.nextLine());
            System.out.println(" 1.morning \n 2.afternoon \n 3. night");
            int time = Integer.parseInt(input.nextLine());
            System.out.println(" ");
            int year = Integer.parseInt(input.nextLine());
            school.addCourse(new Course("name", 2000.00, "mañana", 1));
            counter++;
        }
        counter = 0;


        /*
        System.out.println("Welcome to " + school.getSchoolName() + "\n \n How many teachers are in this institution?");
        numTeacher = Integer.parseInt(input.nextLine());
        while (counter != numTeacher){

            school.addTeacher(new Teacher("name", 2000.00, ));
        }*/
    }
}