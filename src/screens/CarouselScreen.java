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

//Clase abstracta que ajusta y configura los botones compartidos de las pantallas carrusel
public abstract class CarouselScreen implements KioskScreen {
    
    protected void adjustCarruselButtons(SimpleKiosk kiosk, int currentElement, int numberOfElements) {
            
        if (currentElement != 0) {
            kiosk.setOption('G', "<-");
        }
        if (currentElement != numberOfElements) {
            kiosk.setOption('H', "->");
        }
    }// Muestra y deja de mostrar los botones de alante y atras dependiendo de en que elemento estes
    protected void configureScreenButtons(SimpleKiosk kiosk) {
        
        kiosk.setOption('B', "Volver atras");
        kiosk.setOption('C', "Cancelar pedido");
    }// Configura los botones compratidos de volver y cancelar
}

