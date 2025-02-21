package screens;

import manager.Context;
import manager.SimpleKiosk;
import products.MenuCard;
import products.MenuCardSection;

/**
 *
 * @author jaime
 */

//Pantalla para elegir secciones del menú.
public class SectionScreen extends CarouselScreen {

    private int currentSection = 0;
    private MenuCardSection mcs;

    @Override
    public KioskScreen show(Context c) {

        SimpleKiosk kiosk = c.getKiosk();
        MenuCard mc = (MenuCard) c.getMenuCard();
        int numberOfSections = mc.getNumberOfSections();
        this.mcs = mc.getSection(currentSection);

        kiosk.clearScreen();
        this.configureScreenButtons(kiosk);
        super.adjustCarruselButtons(kiosk, currentSection, numberOfSections-1);

        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A': // Añadir
                return new ProductScreen(currentSection);
            case 'B': // Cancelar menú
                return new OrderScreen();
            case 'C': // Cancelar pedido
                return new WelcomeScreen();
            case 'G': // Anterior 
                if (currentSection > 0) {
                    currentSection--;
                }
                return this;
            case 'H': // Siguiente 
                if (currentSection < numberOfSections) {
                    currentSection++;
                }
                return this;
            default:
                return this;
        }
    } //muestra los botones y controla la interaccion con la pantalla

    @Override
    public void configureScreenButtons(SimpleKiosk kiosk) {

        super.configureScreenButtons(kiosk);
        kiosk.setTitle("Seleccione un tipo de producto");
        kiosk.setDescription(mcs.getSectionName());
        kiosk.setImage(mcs.getImageFileName());
        kiosk.setOption('A', "Seleccionar categoría");
        
    }
}
