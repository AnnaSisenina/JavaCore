package Seminar4.Shop.Service;

import Seminar4.Shop.Service.Customer;
import Seminar4.Shop.Service.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Order {
    private Customer customer;
    private Item item;
    private int quantity;

}
