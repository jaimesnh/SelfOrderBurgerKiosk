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
public class MenuCardSection {
    
    private String sectionName;
    private String imageFileName;
    private List<IndividualProduct> productList;; 
    
    public MenuCardSection(String sectionName, String imageFileName, List<IndividualProduct> productList) {
        this.sectionName = sectionName;
        this.imageFileName = imageFileName;
        this.productList = productList;
    }
    
    public IndividualProduct getProduct(int index) {
        if (index >= 0 && index < productList.size()){
            return productList.get(index);
           }
        else return null;
    }
    
     public String getSectionName() {
        return sectionName;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public int getNumberOfProducts() {
        return productList.size();
    }
    
}
