/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

/**
 *
 * @author HP
 */
public class shippableProduct extends product implements shippable{
    private double Weight;
    public shippableProduct(String name, double price, int quantity, double Weight) {
        super(name, price, quantity);
        this.Weight = Weight;
        
    }

    @Override
    public double getWeight() {
        return Weight;
    }
    
    
    
}
