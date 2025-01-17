/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.SimpleKiosk;

/**
 *
 * @author jaime
 */
public abstract class CarouselScreen implements KioskScreen {
    
    protected void adjustCarruselButtons(SimpleKiosk kiosk, int currentElement, int numberOfElements) {
            
        if (currentElement != 1) {
            kiosk.setOption('G', "<-");
        }
        if (currentElement != numberOfElements) {
            kiosk.setOption('H', "->");
        }
    }
    protected void configureScreenButtons(SimpleKiosk kiosk) {
        
        kiosk.setOption('B', "Volver atras");
        kiosk.setOption('C', "Cancelar pedido");
    }
}

