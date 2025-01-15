package screens;

import manager.Context;
import manager.SimpleKiosk;
import products.MenuCard;
import products.MenuCardSection;

/**
 *
 * @author jaime
 */
public class SectionScreen extends CarouselScreen {

    private int currentSection = 1;
    private MenuCardSection mcs;

    @Override
    public KioskScreen show(Context c) {

        private SimpleKiosk kiosk = c.getKiosk();
        MenuCard mc = (MenuCard) c.getMenuCard();
        int numberOfSections = mc.getNumberOfSections();
        
        this.mcs = mc.getSection(currentSection);

        super.adjustCarruselButtons(kiosk, currentSection, numberOfSections);

        kiosk.clearScreen();
        this.configureScreenButtons();


        char event = kiosk.waitEvent(30);

        switch (event) {
            case 'A': // Añadir
                return new ProductScreen(currentSection);
            case 'B': // Cancelar menú
                return new OrderScreen();
            case 'C': // Cancelar pedido
                return new WellcomeScreen();
            case 'G': // Anterior 
                if (currentSection > 1) {
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
    }

    @Override
    public void configureScreenButtons(SimpleKiosk kiosk) {

        kiosk.setTitle("Seleccione un tipo de producto");
        kiosk.setDescription(mcs.getSectionName());
        kiosk.setImage(mcs.getImageFileName());
        kiosk.setOption('A', "Seleccionar categoría");
        
    }
}
