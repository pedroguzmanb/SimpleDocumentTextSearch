/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

/**
 *
 * @author ADMIN
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextToListConverter miTexto = new TextToListConverter();
        String text = TextFileReader.readFile("C:\\Users\\NOUR\\Desktop\\ULACITO\\texto.txt");
        String stopwords = TextFileReader.readFile("C:\\Users\\NOUR\\Desktop\\ULACITO\\StopWords.txt");
        
        //System.out.println("EL TEXTO");
        //System.out.println(miTexto.toList(text));
        
        //System.out.println("STOP WORDS");
        TextPurifier purifier = new TextPurifier(stopwords);

        System.out.println("----------------------- TEXTO PURIFICADO ----------------------------");
        purifier.purify(miTexto.toList(text));
       

    }

}
