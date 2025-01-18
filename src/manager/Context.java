/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.io.IOException;
import products.MenuCard;
import products.Order;

/**
 *
 * @author jaime
 */
public class Context {
    private TranslatorManager translatorManager;
    private SimpleKiosk kiosk;
    private Order order = new Order();                    
    private MenuCard menuCard;
    private int orderNumber;
    private int kioskNumber = 1;
    private int numberofKiosks = 1;

    public Context() throws IOException {
        this.translatorManager = new TranslatorManager();
        this.menuCard = MenuCard.loadFromDisk();
        this.kiosk =  new SimpleKiosk(translatorManager);
    }
 
    
    public TranslatorManager getTranslator() { 
        return translatorManager; 
    }
    
    public SimpleKiosk getKiosk() { 
        return kiosk; 
    }
    public Order getOrder() { 
        return order; 
    }
    
    public MenuCard getMenuCard() { 
        return menuCard; 
    }
    
    public void setOrder(Order order) { 
        this.order =order;
    } 
    
    public void initialize() {   
        this.order = new Order();
    }
    
    public int getKioskNumber() {
        return this.kioskNumber;
    }
}
