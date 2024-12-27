/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
/**
 *
 * @author jaime
 */
public class Context {
    //ATRIBUTOS
    private SimpleKiosk kiosk;
    private TranslatorManager translator;   
    private Order order;                    
    private MenuCard menuCard;
    private int orderNumber;
    private int kioskNumber;
    private int numberofKiosks;
    
    public TranslatorManager getTranslator() { 
        return translator; 
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
        this.order = order;
        
    }
    
    public void initialize() {   
        this.translator = new TranslatorManager();
        this.kiosk = new SimpleKiosk (this.translator);
        this.menuCard = new MenuCard();
        this.orderNumber = 1;
    }
    
    public void incrementOrderNumber() {
            this.orderNumber ++;
    }
}
