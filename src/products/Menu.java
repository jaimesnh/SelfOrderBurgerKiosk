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
public class Menu implements Product{
    
    private List<IndividualProduct> products;
    private static int discount = -1;  
    
    
    public void menu() throws IOException {
        if (discount == -1) {
            try (BufferedReader br = new BufferedReader(new FileReader("discount.txt"))) {
                String line = br.readLine();
                discount = Integer.parseInt(line.trim());
            }
        }
    }
    
    @Override
    public int getPrice() {
        int total = 0;

        for (IndividualProduct product : products) {
            total += product.getPrice();
        }

        total -= (total * discount) / 100;
        return total;
    }

    @Override
    public String getName() {

        StringBuilder nameBuilder = new StringBuilder("Menu compuesto por: ");
        for (IndividualProduct product : products) {
            nameBuilder.append(product.getName()).append(", ");
        }

        return nameBuilder.substring(0, nameBuilder.length() - 2);
    }
    
    public Product getProduct(int i) {
        return products.get(i);
    }
    
    public int getNumProducts() {
        return products.size();
    }
    
}
