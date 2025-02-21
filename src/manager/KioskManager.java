/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.io.IOException;
import screens.KioskScreen;
import screens.WelcomeScreen;

/**
 *
 * @author jaime
 */
public class KioskManager {
    
    //Este metodo es el encargado de dejar un bucle infinito de sucesiones de pantallas, llamado al principio del programa.
    public void start() throws IOException{
        
        Context c = new Context();
        KioskScreen nextScreen = new WelcomeScreen();
        while (true) {
            nextScreen = nextScreen.show(c);
        }
    }
}
