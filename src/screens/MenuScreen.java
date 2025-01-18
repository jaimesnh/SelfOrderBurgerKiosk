/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.Context;
import manager.SimpleKiosk;
import products.IndividualProduct;
import products.Menu;
import products.MenuCard;
import products.MenuCardSection;
import products.Order;
/**
 *
 * @author ivann
 */
public class MenuScreen extends CarouselScreen {
    
    private int currentSection = 0;
    private int currentProduct = 0;
    
    
        @Override
    public KioskScreen show(Context c) {
        try {
            SimpleKiosk kiosk = c.getKiosk();
            MenuCard mc = c.getMenuCard();
            MenuCardSection mcs = mc.getSection(currentSection);
            IndividualProduct p = mcs.getProduct(currentProduct);
            Menu m = new Menu();
            System.out.println(m.discount);
            int numProducts = mcs.getNumberOfProducts();
            
            
            kiosk.clearScreen();
            configureScreenButtons(kiosk, mcs, p);
            super.adjustCarruselButtons(kiosk, currentProduct, numProducts-1);
            
            char event = kiosk.waitEvent(30);
            
            switch (event) {
                case 'A': // Añadir
                    if (currentSection < mc.getNumberOfSections()-1) {
                        m.addProductToMenu(p);
                        currentSection ++;
                        return this;
                    } else {
                        m.addProductToMenu(p);
                        Order o = c.getOrder();
                        o.addProduct(m);
                        return new OrderScreen();
                    }
                case 'B': // Cancelar menú
                    return new OrderScreen();
                case 'C': // Cancelar pedido
                    return new WelcomeScreen();
                case 'G': // Anterior
                    if (currentProduct > 1) {
                        currentProduct--;
                    }
                    return this;
                case 'H': // Siguiente
                    if (currentProduct < numProducts) {
                        currentProduct++;
                    }
                    return this;
                default:
                    return this;
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    public void configureScreenButtons(SimpleKiosk kiosk, MenuCardSection mcs, IndividualProduct p) {
        super.configureScreenButtons(kiosk);
        kiosk.setTitle("Seleccione un " + mcs.getSectionName());
        kiosk.setImage(p.getImageFileName());
        kiosk.setDescription(
            p.getName() + "\n" +
            p.getDescription() + "\n" +
            (p.getPrice() / 100) + "€"
        );
        kiosk.setOption('A', "Seleccionar producto");        
    }

}
    

