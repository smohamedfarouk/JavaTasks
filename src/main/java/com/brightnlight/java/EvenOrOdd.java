package com.brightnlight.java;

/**
 * Created by moham on 27/02/2016.
 */

import java.util.Scanner;

/**
 * Java program to find if number is even or odd in Java or not. This Java program
 * example demonstrate two ways to check if number is even or odd or not, first example
 * uses modulas or remainder operator denoted by % to see if number is even or not
 * and second operator uses Bitwise AND operator to find if number is even or odd in Java.
 *
 * @author Javin Paul
 */
public class EvenOrOdd {

    public static void main(String args[]) {

        //scanner to get input from user
        Scanner console = new Scanner(System.in);

        System.out.printf("Enter any number : ");

        //return the user input as integer
        int number = console.nextInt();

        //if remainder is zero than even number
        if ((number % 2) == 0) {
            System.out.printf("number %d is even number %n", number); //%d -decimal %n new line

        } else {
            //number is odd in Java
            System.out.printf("number %d is odd number %n", number);
        }

        //Finding Even and Odd number using Bitwise AND operator in Java.

        System.out.printf("Finding number if its even or odd using bitwise AND operator %n");

        //For Even numbers
        //XXX0
        //0001 AND
        //0000
        if ((number & 1) == 0) {
            System.out.printf("number %d is even number %n", number);
        } else {
            System.out.printf("number %d is odd number %n", number);
        }

    }


}



