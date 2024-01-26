package Seminar4.Shop;

import Seminar4.Shop.Service.*;
import Seminar4.Shop.Service.Exceptions.AmountException;
import Seminar4.Shop.Service.Exceptions.CustomerException;
import Seminar4.Shop.Service.Exceptions.ProductException;

import java.time.LocalDate;
import java.util.ArrayList;

import static Seminar4.Shop.Controller.holidayCongratulation;
import static Seminar4.Shop.Controller.placeOrder;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        customers.add(new Customer("Юыху", 20, 123, Gender.MALE));
        customers.add(new Customer("Юыќур", 21, 345, Gender.FEMALE));
        items.add(new Item("item1", 10));
        items.add(new Item("item2", 20));
        items.add(new Item("item3", 30));
        items.add(new Item("item4", 40));
        items.add(new Item("item5", 50));

        Repository shop = new Repository(customers, items, orders);

       /* try {
            shop.addOrder(placeOrder(shop, customers.get(0),items.get(0), 5));
            shop.addOrder(placeOrder(shop, customers.get(1),items.get(1), 5));
            shop.addOrder(placeOrder(shop, customers.get(0),items.get(2), 5));
            shop.addOrder(placeOrder(shop, new Customer("new cust", 50, 456, Gender.FEMALE),items.get(0), 5));
            shop.addOrder(placeOrder(shop, customers.get(0),new Item("new item", 15), 5));
            shop.addOrder(placeOrder(shop, customers.get(0),items.get(2), -5));
        }
        catch (CustomerException | AmountException | ProductException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Orders length: " + shop.getOrders().size());
        }*/

        LocalDate date = LocalDate.of(2023, 1, 31);
        holidayCongratulation(shop, date);

    }

}
