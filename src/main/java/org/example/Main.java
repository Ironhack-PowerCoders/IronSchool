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


        String schoolName = null;
        boolean schoolNameIsCorrect = false;


        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our new APP to manage your school system \n ");


        System.out.println(  "Please insert the name of your institution:");


        schoolName = input.nextLine();

        System.out.println("is " + schoolName + " correct? Type true or false to confirm");
        //System.out.println("first try");
        //schoolNameIsCorrect = input.nextLine();

        while (schoolNameIsCorrect == false){
            String response = input.nextLine();
            if(response.equals("YES")){
                schoolNameIsCorrect = true;
            }else{

            }

            System.out.println("The name was wrong, please insert the new name for your institution");
            schoolName = input.nextLine();
            System.out.println("is " + schoolName + " correct? Type true or false to confirm");
           // schoolNameIsCorrect = input.nextLine();
        }
        System.out.println("Welcome to " + schoolName + "\n \n How many teachers are in this institution?");





    }
}