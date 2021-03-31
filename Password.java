package com.company;
import java.util.Random;

public class Password {

    public static final String LowerLetters = "abcdefghijklmnopqrstuvwxyz";
    public static final String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letters = LowerLetters+upperLetters;
    public static final String symbol = "!£$%^&*()_-+={}[]@#~<>?/|`";
    public static final String digit = "1234567890";

    public static String generator(int length, int symbols, int digits){
        Random random = new Random();

        //Password array is created
        char [] password = new char[length];

        //Correct number of digits, symbols and letters are added to the array
        for(int i=0; i<digits; i++){
            password[i]=digit.charAt(random.nextInt(digit.length()));
        }
        for (int i=digits; i<symbols+digits; i++){
            password[i]=symbol.charAt(random.nextInt(symbol.length()));
        }
        for (int i=digits+symbols; i<length; i++){
            password[i]=letters.charAt(random.nextInt(letters.length()));
        }

        //The array is shuffled
        for (int i=0; i<length; i++){
            int randomIndex = random.nextInt(length);
            char temp = password[randomIndex];
            password[randomIndex]=password[i];
            password[i]=temp;
        }

        //The array is returned as a string
        return new String(password);
    }

    public static String validator(String password){
        //Counters used to count all the elements of the password
        int lengthCounter=password.length();
        int symbolCounter=0;
        int digitCounter=0;
        int letterCounter=0;
        boolean upperCase=false;
        boolean lowerCase=false;

        //For loop which iterates over all the characters of the password
        for (int i=0; i<lengthCounter; i++){
            char j = password.charAt(i);

            //Series of if statements checks the type of the character and increases the relevant counter
            if(digit.indexOf(j)!=-1){
                digitCounter+=1;
            }
            else if (symbol.indexOf(j)!=-1){
                symbolCounter+=1;
            }
            else if (upperLetters.indexOf(j)!=-1){
                upperCase=true;
                letterCounter+=1;
            }
            else{
                lowerCase=true;
                letterCounter+=1;
            }
        }

        //Series of if statements checks the score of the password and returns it
        if (lengthCounter>=16 && symbolCounter>4 && digitCounter>4 && upperCase && lowerCase){
            return "Excellent";
        }
        else if (lengthCounter>12 && symbolCounter>3 && digitCounter>2 && upperCase && lowerCase){
            return "Good";
        }
        else if (lengthCounter>8 && symbolCounter>1 && digitCounter>2 && (!upperCase || !lowerCase)){
            return "OK";
        }
        else{
            return "Poor";
        }

    }
}
