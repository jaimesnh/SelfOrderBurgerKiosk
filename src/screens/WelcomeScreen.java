/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;
import products.Order;


/**
 *
 * @author jaime
 */

//Pantalla de inicio
public class WelcomeScreen implements KioskScreen {

        
        @Override
    public KioskScreen show(Context c) {
        SimpleKiosk kiosk = c.getKiosk();
        
        c.setOrder(new Order());
        kiosk.clearScreen();
        configureScreenButtons(kiosk);

        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A':
                return new OrderScreen();
            case 'B':
                return new IdiomScreen();
            default:
                return this;
        }
    } //Te da la opcion de cambiar de idioma o comenzar un pedido
    
    private void configureScreenButtons(SimpleKiosk kiosk) {
        kiosk.setMenuMode();
        kiosk.setTitle("URJC Burger - Bienvenido");
        kiosk.setOption('A', "Nuevo pedido");
        kiosk.setOption('B', "Cambiar idioma");
        kiosk.setImage("PRODUCTOS/" + "Logo.png");
    }
}
