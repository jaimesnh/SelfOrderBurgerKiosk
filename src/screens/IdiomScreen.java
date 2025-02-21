/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.Context;
import manager.SimpleKiosk;
import manager.TranslatorManager;

/**
 *
 * @author jaime
 */

//Clase IdiomScreen, pantalla para cambiar de idioma el programa
public class IdiomScreen extends CarouselScreen {
    
    int currentIdiom = 0;

    @Override
    public KioskScreen show(Context c) {
        try {
            SimpleKiosk kiosk = c.getKiosk();
            TranslatorManager tm = c.getTranslator();
            List idiomList = tm.getIdioms();
            int numIdioms = idiomList.size();
            String idiom = (String) idiomList.get(currentIdiom);
            
            super.configureScreenButtons(kiosk);
            kiosk.setTitle("Seleccione un idioma");
            kiosk.setDescription(idiom);
            kiosk.setOption('A', "Seleccionar idioma");
            super.adjustCarruselButtons(kiosk,currentIdiom, numIdioms-1);
            
            char event = kiosk.waitEvent(30);
            
            switch (event) {
                case 'A': // Añadir
                    tm.setCurrentIdiom(idiom);
                    return new OrderScreen();
                case 'B': // Cancelar seleccion
                    return new OrderScreen();
                case 'C': // Cancelar pedido
                    return new WelcomeScreen();
                case 'G': // Anterior
                    if (currentIdiom > 0) {
                        currentIdiom--;
                    }
                    return this;
                case 'H': // Siguiente
                    if (currentIdiom < numIdioms) {
                        currentIdiom++;
                    }
                    return this;
                default:
                    return this;
            }
        } catch (IOException ex) {
            Logger.getLogger(IdiomScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    } //Muestra la pantalla de selección de idioma en el kiosco
    
}
