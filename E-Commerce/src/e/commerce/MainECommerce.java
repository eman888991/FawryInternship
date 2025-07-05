package e.commerce;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HP
 */
public class MainECommerce {

    public static void main(String[] args) {
        // Test shippableProduct
        product tv = new shippableProduct("TV", 1000, 4, 15.0);
        customer cus1 = new customer("customer 1", 10000000);
        // Create cart and add items
        cart cartCus1 = new cart();
        // cartCus1.addItem(tv, 2);
        cartCus1.addItem(tv, 3);
        invoice theInvoice = new invoice(cus1, cartCus1);
        theInvoice.checkOut();
        
        // customer 2 will buy 1 tv 
        customer cus2 = new customer("customer 2", 10000000);
        // Create cart and add items
        cart cartCus2 = new cart();
        // cartCus1.addItem(tv, 2);
        cartCus2.addItem(tv, 1);
        invoice theInvoice2 = new invoice(cus2, cartCus2);
        theInvoice2.checkOut();
        
        // now there 4 tv soled so if customer 3 want to buy tv reise error Not enough quantity available for TV
        /*
         customer cus3 = new customer("customer 3", 2000);
        // Create cart and add items
        cart cartCus3 = new cart();
        // cartCus1.addItem(tv, 2);
        cartCus3.addItem(tv, 1);
        invoice theInvoice3 = new invoice(cus3, cartCus3);
        theInvoice3.checkOut();
        
        */
        // test Insufficient balance 
        /*
         product digitalCard = new product("Digital Card",100, 4);
         customer cus4 = new customer("customer 4", 2);
        // Create cart and add items
        cart cartCus4 = new cart();
        // cartCus1.addItem(tv, 2);
        cartCus4.addItem(digitalCard, 1);
        invoice theInvoice4 = new invoice(cus4, cartCus4);
        theInvoice4.checkOut();
        */
        
        
        
        // test expired product
        /*
        Date today = new Date();
        
       
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        
    
        calendar.add(Calendar.MONTH, 1);
        
     
        Date oneMonthLater = calendar.getTime();
        

       
       System.out.println("calendar.getTime() "+oneMonthLater);
        product cheese = new expiableProduct("Cheese", 100, 5, oneMonthLater);
        //((expiableProduct) cheese).setExpiarDate(calendar.getTime());
      
        customer cus5 = new customer("customer 5", 40000);
        // Create cart and add items
        cart cartCus5 = new cart();
        // cartCus1.addItem(tv, 2);
        cartCus5.addItem(cheese, 1);
        invoice theInvoice5 = new invoice(cus5, cartCus5);
        theInvoice5.checkOut();
        
        */
        
        

    }

}
