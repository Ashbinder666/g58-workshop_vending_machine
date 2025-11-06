package se.lexicon;

import se.lexicon.model.*;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Product soda = new Soda(23, "Coca Cola");
        Product chips = new Chips(30, "Potato");
        Product chocolate = new Chocolate(15, "Mars");

        Product[] products = new Product[]{soda, chips, chocolate};

        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);

        //Print all products
        System.out.println(Arrays.toString(vendingMachine.getProducts()));

        // Print one product description
        System.out.println(vendingMachine.getDescription(0));

        //Add currency
        vendingMachine.addCurrency(Currency.ONE);
        vendingMachine.addCurrency(Currency.TEN);

        //get balance
        System.out.println(vendingMachine.getBalance());

        //Request something too expensive
        try {
            Product requested = vendingMachine.request(1);
            System.out.println("You bought: " + requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println("Too expensive!");
        }

        //Request something NOT too expensive
        try {
            Product requested = vendingMachine.request(2);
            System.out.println("You bought: " + requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println("Too expensive!");
        }

        //Get balance
        System.out.println(vendingMachine.getBalance());

        //End session
        vendingMachine.endSession();
    }
}
