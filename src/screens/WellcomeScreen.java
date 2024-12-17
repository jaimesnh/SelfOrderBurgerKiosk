/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.*;
/**
 *
 * @author jaime
 */
public class WellcomeScreen implements KioskScreen {
        @Override
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();

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
    }
    
    private void configureScreenButtons(SimpleKiosk kiosk) {
            kiosk.setTitle("URJC Burger - Bienvenido");
            kiosk.setOption('A', "Nuevo pedido");
            kiosk.setOption('B', "Cambiar idioma");
            kiosk.setImage("Logo.png");
    }
}
