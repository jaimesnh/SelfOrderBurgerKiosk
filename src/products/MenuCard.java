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
            List<MenuCardSection> sectionList = (List<MenuCardSection>) decoder.readObject();
            return new MenuCard(sectionList);
            
        } catch(FileNotFoundException fileNotFound){
            System.out.println(fileNotFound.getMessage());
        }
        return null;
    }
}
