/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;
import products.IndividualProduct;
import products.MenuCard;
import products.MenuCardSection;
import products.Order;

/**
 *
 * @author jaime
 */
public class ProductScreen extends CarouselScreen {
    
    
    private int section;
    private int currentProduct = 0;
    
    public ProductScreen(int currentSection) {
        this.section = section;        
    }
    
    
        @Override
    public KioskScreen show(Context c) {
        SimpleKiosk kiosk = c.getKiosk();
        MenuCard menuCard = c.getMenuCard();
        MenuCardSection mcs = menuCard.getSection(section);
        IndividualProduct p = mcs.getProduct(currentProduct);
        int numProducts = mcs.getNumberOfProducts();
        
               
        kiosk.clearScreen();
        configureScreenButtons(kiosk, mcs, p);
        super.adjustCarruselButtons(kiosk, currentProduct, numProducts);
        
        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A': // Añadir
                Order o = c.getOrder();
                o.addProduct(p);
                return new OrderScreen();
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
        
    }
    
    public void configureScreenButtons(SimpleKiosk kiosk, MenuCardSection mcs, IndividualProduct p) {
        super.configureScreenButtons(kiosk);
         kiosk.setTitle("Seleccione un " + mcs.getSectionName());
         kiosk.setImage(p.getImageFileName());
         kiosk.setDescription(p.getName() + p.getDescription() + p.getPrice());
         kiosk.setOption('A', "Seleccionar producto");        
    }

}
