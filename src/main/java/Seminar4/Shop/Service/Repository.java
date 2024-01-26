package Seminar4.Shop.Service;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Customer> customers;
    private ArrayList<Item> items;
    private ArrayList<Order> orders;


    public Repository(ArrayList<Customer> customers, ArrayList<Item> items, ArrayList<Order> orders) {
        this.customers = customers;
        this.items = items;
        this.orders = orders;
    }


    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addOrder (Order order){
        orders.add(order);
    }


}
