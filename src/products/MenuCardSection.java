/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.util.*;

/**
 *
 * @author jaime
 */

//Clase MenuCardSection que representa una sección de la carta del menú.
public class MenuCardSection {
    
    private String sectionName;
    private String imageFileName;
    private List<IndividualProduct> productList; 
    
    public MenuCardSection(String sectionName, String imageFileName, List<IndividualProduct> productList) {
        this.sectionName = sectionName;
        this.imageFileName = imageFileName;
        this.productList = productList;
    } //Constructor de la clase
    
    public IndividualProduct getProduct(int index) {
        if (index >= 0 && index < productList.size()){
            return productList.get(index);
           }
        else return null;
    }//Devuelve un producto
    
     public String getSectionName() {
        return sectionName;
    } //Devuelve el nombre de la seccion

    public String getImageFileName() {
        return imageFileName;
    } //Devuelve la imagen de la seccion

    public int getNumberOfProducts() {
        return productList.size();
    } //Devuelve el numero total de productos de la seccion
    
}
