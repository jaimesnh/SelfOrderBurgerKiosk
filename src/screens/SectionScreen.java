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
public class SectionScreen extends CarouselScreen {
    
    @Override
    public KioskScreen show(Context c) {
        SimpleKiosk kiosk = c.getKiosk();
        
        kiosk.clearScreen();
        configureScreenButtons(kiosk);
        
        
        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A': //AÑADIR
                return new OrderScreen();
            case 'B': //CANCELAR MENU
                return new IdiomScreen();
            case 'C': //CANCELAR PEDIDO
                return new WellcomeScreen();
            case 'D': //ANTERIOR
                
                return this;
            case 'E': //SIGUIENTE
                return this;
            default:
                return this;
        }
        
    }
    
    
    @Override
    public void configureScreenButtons(SimpleKiosk kiosk) {
        kiosk.setTitle("Elije un tipo de producto");
        kiosk.setOption('A', "Seleccionar categoria");
    }
}
