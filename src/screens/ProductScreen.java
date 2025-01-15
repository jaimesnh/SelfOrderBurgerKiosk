/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;

/**
 *
 * @author jaime
 */
public class ProductScreen extends CarouselScreen {

    public ProductScreen(int currentSection) {
        
    }
    
    private int section;
 
        @Override
    public KioskScreen show(Context c) {
        
        SimpleKiosk kiosk = c.getKiosk();
        super.configureScreenButtons(kiosk);


    }
    
        @Override
    public void configureScreenButtons(Simplekiosk kiosk) {
        
        kiosk.clearScreen();
        super.configureScreenButtons(kiosk);
        kiosk.setOption('A', "Añadir al pedido");
        
        
    }

}
