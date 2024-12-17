/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

/**
 *
 * @author jaime
 */
public class SimpleKiosk {
    //ATRIBUTOS
    private BurgerSelfOrderKiosk kiosk;
    
    public SimpleKiosk(TranslatorManager translatorManager) {
        this.kiosk = new BurgerSelfOrderKiosk ();
    }

    public void setOption(char option, String value) {
    
    }
    
    public void setTitle(String title) {
    
    }
    
    public void setDescription(String description) {
    
    }
    
    public void setMenuMode() {
    
    }
    
    public char waitEvent(int timeout) { 
        return ' '; 
    }
    
    public void print(String text) {
    
    }
    
    public void retainCard(boolean retain) {
    
    }
    
    public void expelCreditCard(int timeout) {
    
    }
    
    public void clearScreen() {
    
    }
    
    public void setImage(String image) {
    
    }
    
    public long getCardNumber() { 
        return 0L; 
    }
    
    public void setMessageMode() {
    }
    
}
