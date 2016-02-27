package com.brightnlight.java;

import java.util.Comparator;

/**
 * Created by moham on 27/02/2016.
 */
/*
 * Order class is a domain object which implements
 * Comparable interface to provide sorting on natural order.
 * Order also provides copule of custom Comparators to
 * sort object based uopn amount and customer
 */
class Order implements Comparable<Order> {

    private int orderId;
    private int amount;
    private String customer;

    /*
     * Comparator implementation to Sort Order object based on Amount
     */
    public static class OrderByAmount implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.amount > o2.amount ? 1 : (o1.amount < o2.amount ? -1 : 0);
        }
    }

    /*
     * Anohter implementation or Comparator interface to sort list of Order object
     * based upon customer name.
     */
    public static class OrderByCustomer implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.customer.compareTo(o2.customer);
        }
    }

    public Order(int orderId, int amount, String customer) {
        this.orderId = orderId;
        this.amount = amount;
        this.customer = customer;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /*
     * Sorting on orderId is natural sorting for Order.
     */
    @Override
    public int compareTo(Order o) {
        return this.orderId > o.orderId ? 1 : (this.orderId < o.orderId ? -1 : 0);
    }

    /*
     * implementing toString method to print orderId of Order
     */
    @Override
    public String toString() {
        return String.valueOf(orderId);
    }
}

