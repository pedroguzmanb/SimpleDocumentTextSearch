/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

import cr.ed.ulacit.texttools.util.TextFileReader;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.model.Document;
import cr.ed.ulacit.model.Query;
import cr.ed.ulacit.model.WordFrequency;
import cr.ed.ulacit.model.WordFrequencyComparator;


/**
 *
 * @author ADMIN
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextToListConverter converter = new TextToListConverter();
        String text = TextFileReader.readFile("C:\\Users\\pedro\\Desktop\\texto01.txt");
        String stopwords = TextFileReader.readFile("C:\\Users\\pedro\\Desktop\\StopWords.txt");
        TextPurifier purifier = new TextPurifier(stopwords);
        
        Query q = new Query("cloud computing", purifier);
        Document d = new Document(text, purifier);
        System.out.println("DOCUMENT SCORE: " + q.computeCosineDistance(d, 3));

        System.out.println("----------------------- TEXTO PURIFICADO ----------------------------");
        
        /*List<WordFrequency> doc = purifier
                .extractSemanticVocabulary(converter
                        .toList(text)
                ).list(new WordFrequencyComparator());
        System.out.println(doc);*/
    }
}
