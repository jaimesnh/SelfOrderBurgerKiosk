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
