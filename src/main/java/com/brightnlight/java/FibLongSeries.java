package com.brightnlight.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by moham on 27/02/2016.
 */
public class FibLongSeries {

    private boolean inputValidated;

    public FibLongSeries() {

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
        FibLongSeries fibSeries = new FibLongSeries();
        int number = fibSeries.acceptInputAndValidate();
        System.out.println("Fibonacci series upto " + number + " numbers using Iterative Method "); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            try {
                System.out.print(fibSeries.fibIterative(i) + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
        System.out.println("Fibonacci series upto " + number + " numbers using Recursive Method"); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            System.out.print(fibSeries.fibRecursive(i) + " ");
        }
        System.out.println("");
        System.out.println("Fibonacci series upto " + number + " numbers using Tail Recursive Fib Method"); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            System.out.print(fibSeries.fibTailRecursive(i, 1, 0) + " ");
        }
        System.out.println("");
        System.out.println("Fibonacci series upto " + number + " numbers using Improved Fib Method"); //printing Fibonacci series upto number
        for (int i = 0; i <= number; i++) {
            System.out.print(fibSeries.improvedFibo(i) + " ");
        }


        //comparison of performance of Fibonacci number with memorization
        number = 10;

        //    long startTime = System.nanoTime();
        //long result = fibSeries.improvedFibo(number);
        //Fibonacci number with memorization
        //    long elapsedTime = System.nanoTime() - startTime;
        //     System.out.println("" + result);
        //   System.out.println("Time taken to calculate Fibonacci number upto 100M with memorization: " + elapsedTime);

        long result = 0;
        long startTime = System.nanoTime();
        try {
            result = fibSeries.fibIterative(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("" + result);
        System.out.println("Time taken to calculate Fibonacci number upto 100M without memorization: " + elapsedTime);


        startTime = System.nanoTime();
        result = fibSeries.fibTailRecursive(number, 0, 1);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("" + result);
        System.out.println("Time taken to calculate Fibonacci using Tail recursion upto 100M without memorization: " + elapsedTime);
    }

    private void validateInput(long number) throws InvalidInputException {
        if (!Long.class.isInstance(number)) {
            throw new InvalidInputException("Invalid: Pass a number");
        }
    }


    /*
        * Java Program to calculate Fibonacci numbers with memorization
        * This is quite fast as compared to previous Fibonacci function
        * especially for calculating factorial of large numbers.
        */
    private Map<Long, Long> cache = new HashMap();

    public Long improvedFibo(long number) {
        Long fibonacci = cache.get(number);
        if (fibonacci != null) {
            return fibonacci; //fibonacci number from cache
        }
        //fibonacci number not in cache, calculating it
        fibonacci = fibTailRecursive(number, 1, 0);

        //putting fibonacci number in cache for future request
        cache.put(number, fibonacci);
        return fibonacci;
    }


    //Using Tail recursion
    // Loop should be outside in the caller method
    public long fibRecursive(long number) {
        //Write the base logic for which no iteration or recursion is required
        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        //Create the result statement in this case the number -1 + number -2
        return fibRecursive(number - 1) + fibRecursive(number - 2); //tail recursion


    }

    //Tail recursion means that the last action performed by the method is directly returning the value from the recursive call, without modifying it.
    public long fibTailRecursive(long n, long acc1, long acc2) {
        return n == 0 ? acc2 : fibTailRecursive(n - 1, acc1 + acc2, acc1);
    }


    public long fibIter(int n) {
        int m = 1;
        long fibPrev = 0;
        long fibCurrent = 1;
        while (n != m) {
            m = m + 1;
            long current = fibCurrent;
            fibCurrent = fibPrev + fibCurrent;
            fibPrev = current;
        }
        return fibCurrent;
    }

    public int fibIterative(long number) throws InvalidInputException {
        validateInput(number);

        //Write the base logic for which no iteration or recursion is required
        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        // Write the initial non base counter state requirements in this case value  for previous and the one before previous
        // Ignore the looping for the base numbers and start loop from the non base counters to the number
        int fibo1 = 1, fibo2 = 1, fibonacci = 1;
        for (int i = 3; i <= number; i++) {

            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;

        }
        return fibonacci; //Fibonacci number


    }
}
