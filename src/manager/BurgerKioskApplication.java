/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.io.IOException;

/**
 *
 * @author jaime
 */

public class BurgerKioskApplication {
    
    //Se encarga de crear un objeto KioskManager y llamar al metodo start del mismo
    public static void main(String[] args) throws IOException {
        KioskManager km = new KioskManager();
        km.start();
    }
}