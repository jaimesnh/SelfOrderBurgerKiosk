/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;

/**
 *
 * @author ivann
 */
public class PurcheaseScreen implements KioskScreen{

    public KioskScreen show(Context c) {
        SimpleKiosk kiosk = c.getKiosk();

       
        configureScreenButtons(kiosk);
        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A':
                return new OrderScreen();
            case 'B':
                return new WellcomeScreen();
            default:
                return (KioskScreen) this;
            case '1': 
                kiosk.retainCard(false);
                int cardNumber = (int) kiosk.getCardNumber();
                
                if kiosk.comunicationAvailable() {
                    if kiosk.doOperation(cardNumber, order.getTotalAmount) {
                        c.incrementOrderNumber();
                        this.writerOrderToFile(kiosk);
                        kiosk.expelCreditCard(30);

                        return new WellcomeScreen();
                    }
                    else {
                        return (KioskScreen) this;
                    }
                }
                else {
                    return (KioskScreen) this;
                }
        }
    }
    
        private void configureScreenButtons(SimpleKiosk kiosk) {
            kiosk.setTitle("Introduce la tarjeta de crédito");
            kiosk.setDescription(order.getOrderText + "\n" + "Total: " + order.getTotalAmount/100 + "\n" + "Introduce la tarjeta de crédito para confirmar el pedido o pulsa alguno de los botones inferiores");
            kiosk.setOption('A', "Modificar pedido");
            kiosk.setOption('B', "Cancelar pedido");
        }
        
        private void writerOrderToFile(SimpleKiosk kiosk) {
            kiosk.print(order.getOrderText);
        }
        
}
