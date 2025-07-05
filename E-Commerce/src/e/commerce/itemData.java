/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

/**
 *
 * @author HP
 */
public class itemData {

    private product pro;
    private int quantityRequired = 0;

    public itemData(product pro, int quantityRequired) {
        this.pro = pro;

        this.quantityRequired = quantityRequired;
    }

    public int getQuantityRequired() {
        return quantityRequired;
    }

    public void setquantityRequired(int quantityRequired) {

        this.quantityRequired = quantityRequired;
    }

    public product getPro() {
        return pro;
    }

    public double totalPrice() {
        return pro.getPrice() * quantityRequired;
    }

    public expiableProduct getExiableProduct() {
        if (isExiableProduct()) {
            return (expiableProduct) pro;
        }
        return null;
    }

    public shippableProduct getshippableProduct() {
        if (isShippableProduct()) {
            return (shippableProduct) pro;
        }
        return null;
    }

    public boolean isExiableProduct() {
        return pro instanceof expiableProduct;

    }

    public boolean isShippableProduct() {
        return pro instanceof shippableProduct;
    }

}
