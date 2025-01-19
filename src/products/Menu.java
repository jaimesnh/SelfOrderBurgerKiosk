/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author jaime
 */

//Clase Menu que implementa Product, representa un conjunto de productos individuales.
public class Menu implements Product{
    
    private List<IndividualProduct> products = new ArrayList();
    private static int discount = -1;
    
    public Menu() throws IOException {
        if (discount == -1) {
            try (BufferedReader br = new BufferedReader(new FileReader("discount.txt"))) {
                String line = br.readLine();
                discount = Integer.parseInt(line.trim());
            }
        }
    } //Lee del fichero discount.txt el descuento que hay que aplicar al menu
    
    @Override
    public int getPrice() {
        int total = 0;

        for (IndividualProduct product : products) {
            total += product.getPrice();
        }

        total -= (int) (total * (discount / 100.0));
        return total;
    } //Devuelve el precio del menu aplicando el descuento

    @Override
    public String getName() {

        StringBuilder nameBuilder = new StringBuilder("Menu compuesto por: " + "\n");
        for (IndividualProduct product : products) {
            nameBuilder.append(product.getName()).append(", ");
        }

        return nameBuilder.substring(0, nameBuilder.length() - 2);
    } //Devuelve los nombres de los componentes del menu
    
    public Product getProduct(int i) {
        return products.get(i);
    } //Devuelve la posicion del producto en la lista
    
    public int getNumProducts() {
        return products.size();
    } //Devuelve el numero de productos de la lista 
    
    public void addProductToMenu(IndividualProduct p) {
        products.add(p);
    } // Añade los productos al menu
    
}
