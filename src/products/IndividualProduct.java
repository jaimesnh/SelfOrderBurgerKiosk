/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

/**
 *
 * @author jaime
 */

//Clase IndividualProduct,implementa la interfaz product y representa los productos individuales del programa
public class IndividualProduct implements Product {

    private String name;
    private String description;
    private String imageFileName;
    private int price; 
    
    public IndividualProduct(String name, String description, String imageFileName, int price) {
        this.name = name;
        this.description = description;
        this.imageFileName = imageFileName;
        this.price = price;
    } //Constructor de la clase

    @Override
    public int getPrice() {
        return this.price;
    } //Devuelve el precio del producto

    @Override
    public String getName() {
        return this.name;
    } //Devuelve el nombre del producto
    
    public String getDescription() {
        return this.description;
    } //Devuelve la descripcion del producto      

    public String getImageFileName() {
        return this.imageFileName;
    } //Devuelve la imagen del producto



}
