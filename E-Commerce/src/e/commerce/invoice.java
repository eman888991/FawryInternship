/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class invoice {

    double subtotal = 0;
    double shippingFee = 0;
    double Amount = 0;
    List<itemData> itemsShippable;

    private customer cus;
    private cart ownCart;

    public invoice(customer cus, cart ownCart) {
        this.cus = cus;
        this.ownCart = ownCart;

    }

    public void ShipmentNotice() {
        itemsShippable = ownCart.listShippableItems();
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (itemData item : itemsShippable) {
            shippableProduct itemshippable = (shippableProduct) item.getPro();

            double weight = itemshippable.getWeight();
            totalWeight += weight;
            System.out.printf("%10s%5.0fg%n", item.getPro().getName(), weight);
        }

        System.out.printf("Total package weight %.3fkg%n", (totalWeight / 1000.0));
    }

    public void itemsInvoice() {
        System.out.println("** Checkout receipt **");

        for (itemData item : ownCart.getItems()) {
            int quantity = item.getQuantityRequired();
            String productName = item.getPro().getName();
            double totalPriceEachItem = item.totalPrice();
            System.out.printf("%5dx %s %.2f%n", quantity, productName, totalPriceEachItem);
        }

    }

    public double calShippingFee() {
        if (itemsShippable != null) {
            for (itemData item : itemsShippable) {
                shippingFee = item.getQuantityRequired() * 10;
            }
        }
        return shippingFee;
    }

    public double calSubtotal() {
        for (itemData item : ownCart.getItems()) {
            int quantity = item.getQuantityRequired();
            String productName = item.getPro().getName();
            double totalPriceEachItem = item.totalPrice();
            subtotal += totalPriceEachItem;
        }
        return subtotal;
    }

    public void printTotal() {

        ShipmentNotice();
        itemsInvoice();

        System.out.println("----------------------");
        System.out.printf("Subtotal %.2f%n", subtotal);
        System.out.printf("Shipping %.2f%n", shippingFee);
        System.out.printf("Amount %.2f%n", Amount);
    }

    public void checkOut() {
        // first calculate shipping fee
        shippingFee = calShippingFee();
        // second calculate subtotal
        subtotal = calSubtotal();
        // third calculate amount 
        Amount = subtotal + shippingFee;
        if (ownCart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");

        }
        
        if (cus.getBalance() < Amount) {
            throw new IllegalStateException("Insufficient balance as " + "total is: " + Amount + " and the Customer balance is: " + cus.getBalance());
        }else{
            cus.depit(Amount);
        }

        System.out.println("Checkout for Customer: " + cus.getName());
        printTotal();
        System.out.println("Balance of customer after Checkout " + cus.getBalance());
        

    }

}
