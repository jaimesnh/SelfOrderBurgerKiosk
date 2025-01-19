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

//Clase OrderScreen, pantalla con las opciones para realizar un pedido
public class OrderScreen implements KioskScreen {
    
        @Override      
        public KioskScreen show(Context c) {
            SimpleKiosk kiosk = c.getKiosk();

            kiosk.clearScreen();
            configureScreenButtons(kiosk);

            char event = kiosk.waitEvent(30);

            switch (event) {
                case 'A':
                    return new MenuScreen();
                case 'B':
                    return new SectionScreen();
                case 'C':
                    return new PurcheaseScreen();
                case 'D':
                    return new WelcomeScreen();
                default:
                    return this;
            }
        } //Muestra la pantalla con las opciones para realizar el pedido
        
        private void configureScreenButtons(SimpleKiosk kiosk) {
            kiosk.setTitle("Elije un producto nuevo o finaliza pedido");
            kiosk.setImage("PRODUCTOS/pedido.png" );
            kiosk.setOption('A', "Añadir menú a pedido");
            kiosk.setOption('B', "Añadir producto individual al pedido");
            kiosk.setOption('C', "Finalizar y pagar");
            kiosk.setOption('D', "Cancelar pedido");
    }
}
