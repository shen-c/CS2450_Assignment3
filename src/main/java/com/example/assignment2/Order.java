package com.example.assignment2;

// Order object for Listview
public class Order {
    private String number;
    private String date;
    private String customer;
    private String item;
    private String price;

    public Order(String number, String date, String customer, String item, String price) {
        this.number = number;
        this.date = date;
        this.customer = customer;
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order " + number + ": " + item + " for " + customer + " on " + date + " for $" + price;
    }
}