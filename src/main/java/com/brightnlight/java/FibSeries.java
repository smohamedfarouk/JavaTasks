package com.brightnlight.java;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by moham on 27/02/2016.
 */
public class FibSeries {

    private boolean inputValidated;

    public FibSeries() {

    }

    public int acceptInputAndValidate() throws IllegalArgumentException {
        System.out.println("Enter number upto which Fibonacci series to print: ");
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter a positive number!");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            number = sc.nextInt();
        } while (number <= 0);
        System.out.println("Thank you! Got " + number);
        return number;
    }


    //Generate Fib Series for a given Number
    //fn = fn-1 + fn-2
    //Calculate Fibonacci number

    public static void main(String args[]) {
        FibSeries fibSeries = new FibSeries();
        int number = fibSeries.acceptInputAndValidate();
        System.out.println("Fibonacci series upto " + number + " numbers using Iterative Method "); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            try {
                System.out.print(fibSeries.fibIterative(BigInteger.valueOf(i)) + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
        System.out.println("Fibonacci series upto " + number + " numbers using Recursive Method"); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            System.out.print(fibSeries.fibRecursive(BigInteger.valueOf(i)) + " ");
        }
        System.out.println("");
        System.out.println("Fibonacci series upto " + number + " numbers using Tail Recursive Fib Method"); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            System.out.print(fibSeries.fibTailRecursive(BigInteger.valueOf(i), BigInteger.valueOf(1), BigInteger.valueOf(0)) + " ");
        }
        System.out.println("");
        System.out.println("Fibonacci series upto " + number + " numbers using Improved Fib Method"); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            System.out.print(fibSeries.improvedFibo(BigInteger.valueOf(i)) + " ");
        }


        //comparison of performance of Fibonacci number with memorization
        number = 10;

        //    long startTime = System.nanoTime();
        //long result = fibSeries.improvedFibo(number);
        //Fibonacci number with memorization
        //    long elapsedTime = System.nanoTime() - startTime;
        //     System.out.println("" + result);
        //   System.out.println("Time taken to calculate Fibonacci number upto 100M with memorization: " + elapsedTime);

        BigInteger result = BigInteger.valueOf(0);
        long startTime = System.nanoTime();
        try {
            result = fibSeries.fibIterative(BigInteger.valueOf(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("" + result);
        System.out.println("Time taken to calculate Fibonacci number upto 100M without memorization: " + elapsedTime);


        startTime = System.nanoTime();
        result = fibSeries.fibTailRecursive(BigInteger.valueOf(number), BigInteger.valueOf(0), BigInteger.valueOf(1));
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("" + result);
        System.out.println("Time taken to calculate Fibonacci using Tail recursion upto 100M without memorization: " + elapsedTime);
    }

    private void validateInput(BigInteger number) throws InvalidInputException {
        if (!BigInteger.class.isInstance(number)) {
            throw new InvalidInputException("Invalid: Pass a number");
        }
    }


    /*
        * Java Program to calculate Fibonacci numbers with memorization
        * This is quite fast as compared to previous Fibonacci function
        * especially for calculating factorial of large numbers.
        */
    private Map<BigInteger, BigInteger> cache = new HashMap();

    public BigInteger improvedFibo(BigInteger number) {
        BigInteger fibonacci = cache.get(number);
        if (fibonacci != null) {
            return fibonacci; //fibonacci number from cache
        }
        //fibonacci number not in cache, calculating it
        fibonacci = fibTailRecursive(number, BigInteger.valueOf(1), BigInteger.valueOf(0));

        //putting fibonacci number in cache for future request
        cache.put(number, fibonacci);
        return fibonacci;
    }

    /*
         //Write the base logic for which no iteration or recursion is required
        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        //Create the result statement in this case the number -1 + number -2
        return fibRecursive(number - 1) + fibRecursive(number - 2); //tail recursion
     */
//https://dzone.com/articles/do-it-java-8-recursive-and
    //Using Tail recursion
    // Loop should be outside in the caller method
    public BigInteger fibRecursive(BigInteger number) {
        //Write the base logic for which no iteration or recursion is required
        if (number.equals(0)) {
            return BigInteger.valueOf(0);
        }
        if (number.equals(1) || number.equals(2)) {
            return BigInteger.valueOf(1);
        }
        //Create the result statement in this case the number -1 + number -2
        return fibRecursive(number.subtract(BigInteger.valueOf(1))).add(fibRecursive(number.subtract(BigInteger.valueOf(2)))); //tail recursion
    }

    //Tail recursion means that the last action performed by the method is directly returning the value from the recursive call, without modifying it.
    public BigInteger fibTailRecursive(BigInteger n, BigInteger acc1, BigInteger acc2) {
        return n.equals(0) ? acc2 : fibTailRecursive(n.subtract(BigInteger.valueOf(1)), acc1.add(acc2), acc1);
    }


    public BigInteger fibIter(BigInteger n) {
        BigInteger m = BigInteger.valueOf(1);
        BigInteger fibPrev = BigInteger.valueOf(0);
        BigInteger fibCurrent = BigInteger.valueOf(1);

        while (n != m) {
            m = m.add(BigInteger.valueOf(1));
            BigInteger current = fibCurrent;
            fibCurrent = fibPrev.add(fibCurrent);
            fibPrev = current;
        }
        return fibCurrent;
    }

    public BigInteger fibIterative(BigInteger number) throws InvalidInputException {
        validateInput(number);

        //Write the base logic for which no iteration or recursion is required
        if (number.equals(0)) {
            return BigInteger.valueOf(0);
        }
        if (number.equals(1) || number.equals(2)) {
            return BigInteger.valueOf(1);
        }
        // Write the initial non base counter state requirements in this case value  for previous and the one before previous
        // Ignore the looping for the base numbers and start loop from the non base counters to the number
        BigInteger fibo1 = BigInteger.valueOf(1);
        BigInteger fibo2 = BigInteger.valueOf(1);
        BigInteger fibonacci = BigInteger.valueOf(1);
        for (int i = 3; i <= number.intValue(); i++) {

            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1.add(fibo2);
            fibo1 = fibo2;
            fibo2 = fibonacci;

        }
        return fibonacci; //Fibonacci number


    }
}
