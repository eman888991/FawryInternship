/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerce;

import java.util.Date;

/**
 *
 * @author HP
 */
public class expiableProduct extends product implements expiable {

    public void setExpiarDate(Date expiarDate) {
        this.expiarDate = expiarDate;
    }
    private Date expiarDate ;
    public expiableProduct(String name, double price, int quantity, Date expiarDate) {
        super(name, price, quantity);
        this.expiarDate = expiarDate;
    }

    @Override
    public boolean isexpired() {
        Date today = new Date();
        return today.before(expiarDate);
    }

    @Override
    public Date getExpiredDate() {
        return  expiarDate;
    }
    
}
