/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 */
public class TranslatorManager {
    private Translator currentDictionary;
    private Map <String, Translator> dictionaries;
    
    public TranslatorManager() {
        dictionaries = new HashMap<>();
        
        File folder = new File("/idioms");  
        File[] idiomDocs = folder.listFiles();
        
        for (File file : idiomDocs) {
            try (Scanner sc = new Scanner(file.getName())) {
                sc.useDelimiter("\\.");
                String idiom = sc.next();
                dictionaries.put(idiom, new Translator(file.getName()));
            } catch (IOException ex) {
                Logger.getLogger(TranslatorManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (dictionaries.containsKey("español")) {
            this.currentDictionary = dictionaries.get("español");
        } else {
            System.out.println("No se encontró el diccionario en español.");
        }
    }
    
    
    public void setCurrentIdiom (String idiom){
        currentDictionary = dictionaries.get(idiom);
    }
    
    
    public List getIdioms(){
        ArrayList<String> idiomList = new ArrayList<>();
        for (Map.Entry<String, Translator> entry : dictionaries.entrySet()) {
            idiomList.add(entry.getKey());
        }
        return idiomList;
    }
    
    public String translate (String idiom){
        return currentDictionary.translate (idiom);
    }
}