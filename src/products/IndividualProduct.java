/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

/**
 *
 * @author jaime
 */
public class IndividualProduct implements Product {

    private String name;
    private String description;
    private String imageFileName;
    private int price; 
    
    public void IndividualProduct(String name, String descr, String imageFileName, int price) {
        this.name = name;
        this.description = descr;
        this.imageFileName = imageFileName;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }      

    public String getImageFileName() {
        return this.imageFileName;
    }



}
