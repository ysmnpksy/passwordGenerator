package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int n;
        do{
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 to generate a password, 2 to verify a password and 3 to exit.");
            n = in.nextInt();

            switch(n){
                //Generates a password for the user
                case 1:
                    //User enters details of the password they want to generate
                    System.out.println("You have selected to generate a password.");
                    System.out.println("Please enter the desired length:");
                    int length = in.nextInt();
                    System.out.println("Please enter the desired number of symbols:");
                    int symbols = in.nextInt();
                    System.out.println("Please enter the desired number of digits:");
                    int digits = in.nextInt();

                    //Password id generated and printed
                    String genPass = Password.generator(length, symbols, digits);
                    System.out.println("Your password is: "+genPass);
                    break;

                //Verifies a password
                case 2:
                    //User enters the password they want verified
                    System.out.println("You have selected to verify a password.");
                    System.out.println("Please enter the password you'd like to verify:");
                    String password = in.next();

                    //The score of the password is printed
                    String verPass = Password.validator(password);
                    System.out.println("This password is: "+verPass);
                    break;
            }
        }while(n!=3); //3 is pressed to exit the menu
    }
}
