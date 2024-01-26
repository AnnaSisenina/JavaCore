package Seminar4.Shop;

import Seminar4.Shop.Service.*;
import Seminar4.Shop.Service.Exceptions.AmountException;
import Seminar4.Shop.Service.Exceptions.CustomerException;
import Seminar4.Shop.Service.Exceptions.ProductException;

import java.time.LocalDate;
import java.time.Month;


public class Controller {
    public static Order placeOrder(Repository repository, Customer customer, Item item, int quantity) throws Exception {
        if (!repository.getCustomers().contains(customer))
            throw new CustomerException("Customer not found");
        if(!repository.getItems().contains(item))
            throw new ProductException("Item not found");
        if(quantity < 0)
            throw new AmountException("Incorrect amount " + quantity);
        return new Order(customer, item, quantity);
    }

    public static Holiday dataChecker(LocalDate date){
        if (date.getDayOfMonth() == 31 && date.getMonth() == Month.DECEMBER)
            return Holiday.NEW_YEAR;
        else if (date.getDayOfMonth() == 8 && date.getMonth() == Month.MARCH)
            return Holiday.WOMENS_DAY;
        else if (date.getDayOfMonth() == 23 && date.getMonth() == Month.FEBRUARY)
            return Holiday.DEFENDERS_DAY;
        else
            return Holiday.NO_HOLIDAY;
    }

    public static void holidayCongratulation (Repository repository, LocalDate date){
        Holiday holiday = dataChecker(date);
        switch (holiday){
            case NEW_YEAR:
                for (Customer customer : repository.getCustomers()) {
                    System.out.println(customer.getName() + " � ����� �����!");
                }
                break;
            case WOMENS_DAY:
                for (Customer customer : repository.getCustomers()) {
                    if (customer.getGender() == Gender.FEMALE)
                        System.out.println(customer.getName() + " � 8 �����!");
                }
                break;
            case DEFENDERS_DAY:
                for (Customer customer : repository.getCustomers()) {
                    if (customer.getGender() == Gender.MALE)
                        System.out.println(customer.getName() + " � 23 �������!");
                }
                break;
            case NO_HOLIDAY:
                for (Customer customer : repository.getCustomers()) {
                    System.out.println(customer.getName() + " �������� ���");
                }
                break;
            default:
                break;
        }
    }


}
