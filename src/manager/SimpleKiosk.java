/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import sienens.BurgerSelfOrderKiosk;

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
        kiosk.setOption(option,value);
    }
    
    public void setTitle(String title) {
        kiosk.setTitle(title);
    }
    
    public void setDescription(String description) {
        kiosk.setDescription(description);
    }
    
    public void setMenuMode() {
        kiosk.setMenuMode();
    }
    
    public char waitEvent(int timeout) { 
        return ' '; 
    }
    
    public void print(String text) {
        kiosk.print(text);
    }
    
    public void retainCreditCard(boolean retain) {
        kiosk.retainCreditCard(retain);
    }
    
    public void expelCreditCard(int timeout) {
        kiosk.expelCreditCard(timeout);
    }
    
    public void clearScreen() {
        kiosk.clearScreen();
    }
    
    public void setImage(String imageFileName) {
        kiosk.setImage(imageFileName);
    }
    
    public long getCardNumber() { 
        return kiosk.getCardNumber(); 
    }
    
    public void setMessageMode() {
        kiosk.setMessageMode();
    }
    
}
