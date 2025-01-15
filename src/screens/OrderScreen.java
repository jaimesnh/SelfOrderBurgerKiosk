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
public class OrderScreen implements KioskScreen {
    
        @Override
        
        public KioskScreen show(Context c) {
            SimpleKiosk kiosk = c.getKiosk();

            c.setOrder(new Order());
            kiosk.clearScreen();
            configureScreenButtons(kiosk);

            char event = kiosk.waitEvent(30);

            switch (event) {
                case 'A':
                    return new ProductScreen(currentSection);
                case 'B':
                    return new SectionScreen();
                case 'C':
                    return new PurcheaseScreen();
                case 'D':
                    return new WellcomeScreen();
                default:
                    return this;
            }
        }
        
        private void configureScreenButtons(SimpleKiosk kiosk) {
            kiosk.setTitle("Elije un prducto nuevo o finaliza pedido");
            kiosk.setOption('A', "Añadir menú a pedido");
            kiosk.setOption('B', "Añadir producto individua a pedido");
            kiosk.setOption('C', "Finalizar y pagar");
            kiosk.setOption('D', "Cancelar pedido");
    }
}
