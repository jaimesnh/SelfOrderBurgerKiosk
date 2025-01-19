/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 */

//Clase MenuCard que gestiona una lista de secciones de un menú.
public class MenuCard {
    
    private List<MenuCardSection> sectionList;
    
    public MenuCard(List<MenuCardSection> sectionList) {
        this.sectionList = sectionList;
    }
    
    public MenuCardSection getSection(int index) {
        if (index >= 0 && index < sectionList.size()) {
            return sectionList.get(index);
        }
        else return null;
    } //Devuelve la seccion en la que estés

    public int getNumberOfSections() {
        return sectionList.size();
    } //Devuelve el numero de secciones que hay

    public static MenuCard loadFromDisk() {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("catalog.xml"))) {

            Object obj = decoder.readObject();

            if (obj instanceof MenuCard) {
                return (MenuCard) obj;
            } else {
                System.out.println("El archivo XML no contiene un objeto MenuCard válido.");
            }

        }   catch (FileNotFoundException ex) {
            Logger.getLogger(MenuCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } // lee del disco el fichero catalog.txt para obtener la carta de productos disponibles
}
