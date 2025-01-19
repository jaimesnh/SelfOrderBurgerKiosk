/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jaime
 */

//Encargada de un idioma, el constructor lee un fichero txt y carga cada palabra con su traduccion en un mapa
class Translator {
    private Map<String, String> words;
    
    //Funcion para traducir las frases, separa la frase en palabras y traduce palabra a palabra crenado la frase traducida
    public String translate(String toTranslate) {
        if (toTranslate == null || toTranslate.isEmpty()) {
            return null; //Si los botones estan vacios
        }

        String[] wordsArray = toTranslate.split("\\s+");
        StringBuilder translatedPhrase = new StringBuilder();

        for (String word : wordsArray) {
            String translatedWord = words.get(word);

            if (translatedWord == null) {
                translatedWord = word;
            }

            translatedPhrase.append(translatedWord).append(" ");
        }

        return translatedPhrase.toString().trim();
    }

    
    public Translator(String fileName) throws FileNotFoundException, IOException {
        words = new HashMap<>();
        try (Reader id = new FileReader(fileName);            
        BufferedReader buf = new BufferedReader(id)){
            String s;
            while ((s = buf.readLine()) != null) {
                try (Scanner sc = new Scanner(s)) {
                    sc.useDelimiter(" = ");
                    if (sc.hasNext()) {
                        String key = sc.next().trim();
                        if (sc.hasNext()) {
                            String value = sc.next().trim();
                            words.put(key, value);
                        }
                    }
                }
            }
        }
    }
}