package com.brightnlight.java;

/**
 * Created by moham on 27/02/2016.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Java program to test Object sorting in Java. This Java program
 * test Comparable and Comparator implementation provided by Order
 * class by sorting list of Order object in ascending and descending order.
 * Both in natural order using Comparable and custom Order using Comparator in Java
 *
 * @author http://java67.blogspot.com
 */
public class ObjectSortingExample {

    public static void main(String args[]) {

        //Creating Order object to demonstrate Sorting of Object in Java
        Order ord1 = new Order(101, 2000, "Sony");
        Order ord2 = new Order(102, 4000, "Hitachi");
        Order ord3 = new Order(103, 6000, "Philips");

        //putting Objects into Collection to sort
        List<Order> orders = new ArrayList<Order>();
        orders.add(ord3);
        orders.add(ord1);
        orders.add(ord2);

        //printing unsorted collection
        System.out.println("Unsorted Collection : " + orders);

        //Sorting Order Object on natural order - ascending
        Collections.sort(orders);

        //printing sorted collection
        System.out.println("List of Order object sorted in natural order : " + orders);

        // Sorting object in descending order in Java
        Collections.sort(orders, Collections.reverseOrder());
        System.out.println("List of object sorted in descending order : " + orders);

        //Sorting object using Comparator in Java
        Collections.sort(orders, new Order.OrderByAmount());
        System.out.println("List of Order object sorted using Comparator - amount : " + orders);

        // Comparator sorting Example - Sorting based on customer
        Collections.sort(orders, new Order.OrderByCustomer());
        System.out.println("Collection of Orders sorted using Comparator - by customer : " + orders);
    }
}

