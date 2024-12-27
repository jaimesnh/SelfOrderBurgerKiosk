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
            
        if (currentElement != 0) {
            kiosk.setOption('D', "<");
        }
        if (currentElement != numberOfElements) {
            kiosk.setOption('E', ">");
        }
    }
    protected void configureScreenButtons(SimpleKiosk kiosk) {
        
        kiosk.setOption('B', "Cancelar menú del pedido");
        kiosk.setOption('C', "Cancelar pedido");
    }
}
