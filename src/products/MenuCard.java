/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author jaime
 */

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
    }

    public int getNumberOfSections() {
        return sectionList.size();
    }

    public static MenuCard loadFromDisk() {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("catalog.xml"))) {
            // Leer el objeto desde el archivo XML
            Object obj = decoder.readObject();

            // Verificar si el objeto deserializado es una instancia de MenuCard
            if (obj instanceof MenuCard) {
                return (MenuCard) obj;
            } else {
                System.out.println("El archivo XML no contiene un objeto MenuCard válido.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Error al convertir el objeto: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
        return null; // Retorna null si algo falla
    }
}
