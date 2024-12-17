package demo;

import java.util.ArrayList;
import javax.naming.CommunicationException;
import sienens.BurgerSelfOrderKiosk;
import urjc.UrjcBankServer;

/**
 *
 * @author jvelez
 */
class BurgerSelfOrderKioskManager {
    BurgerSelfOrderKiosk dispenser = new BurgerSelfOrderKiosk();    
    
    UrjcBankServer bank = new UrjcBankServer();
    
    private void clear() {
        dispenser.setTitle(null);
        dispenser.setImage(null);
        dispenser.setDescription(null);
        
        for (char cont = 'A'; cont <= 'H'; cont++)
            dispenser.setOption(cont, null);
    }
    
    
    void run() {
        
        final int waitTime = 30;
        
        while(true) {
            clear();
            dispenser.setMenuMode();
            dispenser.setTitle("URJC Burger - Bienvenido");
            dispenser.setOption('B', "Nuevo pedido");
            dispenser.setOption('D', "Cambiar idioma");
            dispenser.setImage("Logo.png");
            
            char c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setTitle("¿Qué quieres hacer?");
            dispenser.setOption('A', "Añadir menú al pedido");
            dispenser.setOption('B', "Añadir producto individual a pedido");
            dispenser.setOption('E', "Cancelar");
            dispenser.setImage("Pedido.png");

            c = dispenser.waitEvent(waitTime); 

            clear();
            dispenser.setImage("Hamburguesa.png");
            dispenser.setTitle("Selecciona la hamburguesa del menú");
            dispenser.setOption('H', ">");
            dispenser.setOption('C', "Añadir producto al pedido");
            dispenser.setOption('D', "Cancelar menú del pedido");
            dispenser.setOption('E', "Cancelar pedido");
            dispenser.setDescription("Hamburguesa de ternera\n\n100 gr de carne 100% vacuno\nPrecio: 50€");

            c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setImage("Pollo.png");            
            dispenser.setTitle("Selecciona la hamburguesa del menú");
            dispenser.setOption('A', null);
            dispenser.setOption('G', "<");
            dispenser.setOption('H', ">");
            dispenser.setOption('D', "Añadir producto al pedido");
            dispenser.setOption('E', "Cancelar menú del pedido");
            dispenser.setOption('F', "Cancelar pedido");
            dispenser.setDescription("Hamburguesa de pollo\n\n100 gr de carne 100% pollo\nPrecio: 40€");

            c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setTitle("Elige la bebida del menú");
            dispenser.setOption('H', ">");
            dispenser.setOption('D', "Añadir producto al pedido");
            dispenser.setOption('E', "Cancelar menú del pedido");
            dispenser.setOption('F', "Cancelar pedido");
            dispenser.setImage("Cocacola.png");
            dispenser.setDescription("Cocacola normal\n33cc");

            c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setTitle("Elige la bebida del menú");
            dispenser.setOption('G', "<");
            dispenser.setOption('H', ">");
            dispenser.setOption('B', "Añadir producto al pedido");
            dispenser.setOption('D', "Cancelar menú del pedido");
            dispenser.setOption('E', "Cancelar pedido");
            dispenser.setDescription("Fanta\n33cc");
            dispenser.setImage("Fanta.png");
            c = dispenser.waitEvent(waitTime);


            clear();
            dispenser.setTitle("¿Qué quieres hacer?");
            dispenser.setOption('A', "Añadir menú al pedido");
            dispenser.setOption('B', "Añadir producto individual a pedido");
            dispenser.setOption('C', "Eliminar elemento del pedido");
            dispenser.setOption('D', "Finalizar pedido");
            dispenser.setOption('E', "Cancelar el pedido");
            dispenser.setDescription("Pedido actual:\nMenú x 1");
            dispenser.setImage("Pedido.png");
            
            c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setTitle("Elige una bebida");
            dispenser.setOption('H', ">");
            dispenser.setOption('D', "Añadir producto al pedido");
            dispenser.setOption('E', "Cancelar menú del pedido");
            dispenser.setOption('F', "Cancelar pedido");
            dispenser.setImage("Cocacola.png");
            dispenser.setDescription("Cocacola normal\n33cc");

            c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setTitle("¿Qué quieres hacer?");
            dispenser.setOption('A', "Añadir menú al pedido");
            dispenser.setOption('B', "Añadir producto individual a pedido");
            dispenser.setOption('D', "Eliminar elemento del pedido");
            dispenser.setOption('E', "Finalizar pedido");
            dispenser.setOption('F', "Cancelar el pedido");
            dispenser.setDescription("Pedido actual:\nMenú x 1\nCocacola x 1");
            dispenser.setImage("Pedido.png");
            
            c = dispenser.waitEvent(waitTime);

            clear();
            dispenser.setMessageMode();
            dispenser.setTitle("Introduce tu tarjeta de crédito");
            dispenser.setDescription("Pedido actual:\nMenú x1\nCocacola x1\n\nTotal: 200€\n\nIntroduce la tarjeta de crédito para confirmar el pedido o pulsa los botones inferiores para tomar otra decisión");            
            dispenser.setOption('A', "Modificar pedido");
            dispenser.setOption('B', "Cancelar pedido");
            c = dispenser.waitEvent(waitTime);            

            if (c == '1') {
                dispenser.retainCreditCard(false);

                try {
                    boolean ok = bank.doOperation(dispenser.getCardNumber(),200);
                    if (ok) {
                        dispenser.setMessageMode();
                        dispenser.setTitle("Proceso de pago exitoso");
                        dispenser.setDescription("Ya puedes recoger tu tarjeta\nTu número de pedido es 33\nRecoge el ticket\nTe rogamos que permanezcas atento a las pantallas");
                        dispenser.expelCreditCard(waitTime);
                        
                        ArrayList <String> ticketText = new ArrayList<>();
                        ticketText.add("Artículos comprados");
                        ticketText.add("=====================");
                        ticketText.add("Menú - 200€");
                        ticketText.add("=====================");
                        ticketText.add("Total: 200€");
                        ticketText.add("");
                        ticketText.add("Número de pedido: 33");
                        dispenser.print(ticketText);
                        
                    } else {
                        dispenser.setMessageMode();
                        dispenser.setTitle("Problemas en el proceso de pago");
                        dispenser.setDescription("El banco dice que no tienes dinero. Prueba con otra tarjeta.");            
                        dispenser.expelCreditCard(waitTime);
                    }
                } catch(CommunicationException ex) {
                    dispenser.setMessageMode();
                    dispenser.setTitle("Problemas de comunicación en el proceso de pago");
                    dispenser.setDescription("Reintentando");
                }
            }
        }    
    }
}
