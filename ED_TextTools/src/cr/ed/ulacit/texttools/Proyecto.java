/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

import cr.ed.ulacit.dstructures.Iterator;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.Trie;
import cr.ed.ulacit.dstructures.impl.ExtendedASCIIConcurrentTrie;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String text = TextFileReader.readFile("C:\\Users\\pedro\\Desktop\\texto01.txt");
        String stopwords = TextFileReader.readFile("C:\\Users\\pedro\\Desktop\\StopWords.txt");

        //System.out.println("EL TEXTO");
        //System.out.println(miTexto.toList(text));
        //System.out.println("STOP WORDS");
        TextPurifier purifier = new TextPurifier(stopwords);

        System.out.println("----------------------- TEXTO PURIFICADO ----------------------------");

        List<String> purificadas = purifier.purify(miTexto.toList(text));
        // Ahora las vamos a meter en el Trie.
        Trie<Integer> documento = new ExtendedASCIIConcurrentTrie<Integer>();

        Iterator<String> iter = purificadas.iterator();

        while (iter.hasNext()) {
            documento.put(iter.next(), 0);
        } // WHILE ENDS

        
        // Guardamos el archivo json resultante
        // El archivo generado es un Json que se puede copiar y pegar en un parser
        // como este: (http://json.parser.online.fr/) para poder ver el contenido
        // de manera más fácil y poder ver como se forma el árbol de términos. 
        try (PrintWriter out = new PrintWriter("C:\\Users\\pedro\\Desktop\\docIndex.json")) {
            out.println(documento);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
