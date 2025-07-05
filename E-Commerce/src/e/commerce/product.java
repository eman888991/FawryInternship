/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class product {
    private String name ;
    private double price;
    private static Map<String, Integer> quantityMap = new HashMap<>(); 

     public product(String name, double price, int  aviableQuantity){
         this.name = name;
         this.price = price;
         quantityMap.putIfAbsent(name, aviableQuantity);
     }
    public boolean isAvialable(int quantityRequeird ){

        return quantityRequeird <= getQuantity();
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantityMap.getOrDefault(name, 0);
    }
        public void reduceQuantity(int amount) {
        int current = getQuantity();
        if (amount > current) {
            throw new IllegalArgumentException("Cannot reduce quantity by more than available");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot reduce by negative amount");
        }
        quantityMap.put(name, current - amount);
    }
        // method to increase quantity 
       public void increaseQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot increase by negative amount");
        }
        quantityMap.put(name, getQuantity() + amount);
    }
}


