/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.util.*;


/**
 *
 * @author jaime
 */
public class Order {
    
    private int orderNumber;
    private List<Product> productList = new ArrayList<>();
    
    public int getTotalAmount () {
        int price = 0;
        for (Product p : productList) {
             price += p.getPrice();
        }
        return price;
    }
    
    public String getOrderText() {
        StringBuilder orderText = new StringBuilder("Productos: " + "\n");
        for (Product p : productList) {
            orderText.append(p.getName()).append("\n");
        }
        
        return orderText.toString();
    }
    
    public int getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(Context c) {
        this.orderNumber = c.orderNumber;
    }
    
    public void addProduct(Product p) {
        productList.add(p);
    }
}
