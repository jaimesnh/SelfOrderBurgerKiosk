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

//Clase Order, representa un pedido 
public class Order {
    
    private int orderNumber;
    private List<Product> productList = new ArrayList<>();
    
    public int getTotalAmount () {
        int price = 0;
        for (Product p : productList) {
             price += p.getPrice();
        }
        return price;
    } //Devuelve el precio total del pedido
    
    public String getOrderText() {
        StringBuilder orderText = new StringBuilder("Productos: " + "\n");
        for (Product p : productList) {
            orderText.append(p.getName()).append("\n");
        }
        
        return orderText.toString();
    } //Crea un string de los productos del pedido
    
    public int getOrderNumber() {
        return this.orderNumber;
    } //Devuelve el numero de pedido
    
    public void addProduct(Product p) {
        productList.add(p);
    } //Añade un producto al pedido
    
    public List<String> getTicket() {
        
        List<String> ticket = new ArrayList<>();
        for (Product p : productList) {
            ticket.add(p.getName());
        }
        ticket.add(Float.toString((float) (this.getTotalAmount()/100.0)) + " €");
        return ticket;
    } //Crea el ticket y añade los productos y el precio
}
