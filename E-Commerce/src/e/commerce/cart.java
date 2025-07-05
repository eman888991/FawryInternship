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
public class cart {

    private List<itemData> items = new ArrayList<>();
    private List<itemData> ShippableItems = new ArrayList<>();

    public List<itemData> listShippableItems() {
        for (itemData item : items) {
            if (item.isShippableProduct()) {
                ShippableItems.add(item);
            }
        }
        return ShippableItems;
    }

    public void addItem(product pro, int quantityRequired) {

        // check is aviable
        if (!pro.isAvialable(quantityRequired)) {
            throw new IllegalArgumentException("Not enough quantity available for " + pro.getName());
        }
        // if product exiable check if it exipired or not 
        itemData theItem = new itemData(pro, quantityRequired);
        if(theItem.isExiableProduct()){
            
            if(theItem.getExiableProduct().isexpired()){
                System.out.println ("*********************************************88in cart add method ");
                throw new IllegalArgumentException(" Expired Product");
            }
        }

        if (items.isEmpty()) {

            if (pro.isAvialable(quantityRequired)) {
                items.add(new itemData(pro, quantityRequired));
                pro.reduceQuantity(quantityRequired);
            }
        } else {
            // add item to cart (list of items)
            for (itemData item : items) {

                // if exist update itemData with quantityRequired but before update quantityRequired check the store (aviable quantity)
                if (item.getPro().equals(pro)) {
                    // System.out.println("item.getQuantityRequired()  " + item.getQuantityRequired());
                    int updateQuantityRequired = item.getQuantityRequired() + quantityRequired;

                    //check the store (aviable quantity)
                    if (pro.isAvialable(quantityRequired)) {
                        item.setquantityRequired(updateQuantityRequired);
                        pro.reduceQuantity(quantityRequired);
                    } else {

                        throw new IllegalArgumentException("Not enough quantity available for " + pro.getName());

                    }

                } else {

                    items.add(new itemData(pro, quantityRequired));
                }
            }
        }
    }

    public List<itemData> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calSubTotal() {
        double sum = 0;
        for (itemData item : items) {
            sum = +item.totalPrice();
        }
        return sum;
    }
}
