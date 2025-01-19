/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.List;
import sienens.BurgerSelfOrderKiosk;

/**
 *
 * @author jaime
 */
public class SimpleKiosk {
    //ATRIBUTOS
    private BurgerSelfOrderKiosk kiosk;
    private TranslatorManager tm;
    
    public SimpleKiosk(TranslatorManager translatorManager) {
        this.kiosk = new BurgerSelfOrderKiosk ();
        this.tm = translatorManager;
    }

    public void setOption(char option, String value) {
        kiosk.setOption(option, tm.translate(value));
        //kiosk.setOption(option, value);
    }
    
    public void setTitle(String title) {
        kiosk.setTitle(tm.translate(title));
        //kiosk.setTitle(title);
    }
    
    public void setDescription(String description) {
        kiosk.setDescription(tm.translate(description));
        //kiosk.setDescription(description);
    }
    
    public void setMenuMode() {
        kiosk.setMenuMode();
    }
    
    public char waitEvent(int timeout) { 
        return kiosk.waitEvent(timeout); 
    }
    
    public void print(List<String> text) {
        //No creo que sea necesario
        //List<String> translatedList = new ArrayList<>();
        //for (String word: text) {
        //    translatedList.add(tm.translate(word));
        //}
        kiosk.print(text);
    }
    
    public void retainCreditCard(boolean retain) {
        kiosk.retainCreditCard(retain);
    }
    
    public boolean expelCreditCard(int timeout) {
        return kiosk.expelCreditCard(timeout);
    }
    
    public void clearScreen() {
        for (char letter = 'A'; letter <= 'H'; letter++) {
            this.setOption(letter, null);
        }
        this.setTitle(null);
        this.setImage(null);
        this.setDescription(null);
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
