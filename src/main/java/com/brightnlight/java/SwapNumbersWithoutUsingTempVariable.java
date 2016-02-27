package com.brightnlight.java;

/**
 * Created by moham on 27/02/2016.
 */
public class SwapNumbersWithoutUsingTempVariable {
    /*
    A       B       A^B (A XOR B)
    0       0       0 (zero because operands are same)
    0       1       1
    1       0       1 (one because operands are different)
    1       1       0


Read more: http://javarevisited.blogspot.com/2013/02/swap-two-numbers-without-third-temp-variable-java-program-example-tutorial.html#ixzz41KuNTXPc
     */
    public static void main(String[] args) {
        int a = -10;
        int b = 20;

        System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

        //swapping value of two numbers without using temp variable
        a = a + b; //now a is 30 and b is 20
        b = a - b; //now a is 30 but b is 10 (original value of a)
        a = a - b; //now a is 20 and b is 10, numbers are swapped

        System.out.println("value of a and b after swapping, a: " + a + " b: " + b);

         a = 2; //0010 in binary
         b = 4; //0100 in binary

        System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

//swapping value of two numbers without using temp variable and XOR bitwise operator
        a = a ^ b; //now a is 6 and b is 4
        b = a ^ b; //now a is 6 but b is 2 (original value of a)
        a = a ^ b; //now a is 4 and b is 2, numbers are swapped

        System.out.println("value of a and b after swapping using XOR bitwise operation, a: " + a + " b: " + b);


    }
}

