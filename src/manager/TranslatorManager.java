package manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jaime
 */
public class TranslatorManager {
    private Translator currentDictionary;
    private Map <String, Translator> dictionaries;
    
    public TranslatorManager() throws IOException {
        File folder = new File ("idioms"); // carprta idiomas            
        File[] idiomDocs = folder.listFiles();
        this.dictionaries = new HashMap<>();
        for (File file : idiomDocs){
            Scanner sc = new Scanner(file.getName()); 
            sc.useDelimiter("\\.");
            String idiom = sc.next();
            dictionaries.put(idiom, new Translator(file.getPath()));
            sc.close();
        }
        this.currentDictionary = dictionaries.get("español");
    }   
    public void setCurrentIdiom (String idiom){
        currentDictionary = dictionaries.get(idiom);
    }               
    public List getIdioms() throws IOException{//tiene que devolver una lista pero en algun momento se tendran que meter los idiomas en dictionaries
        ArrayList<String> idiomList = new ArrayList<>();
        for (String idiom : dictionaries.keySet()){
            idiomList.add(idiom);
        }
        return idiomList;
    }
    public String translate (String idiom){
        return currentDictionary.translate (idiom);
    }
}