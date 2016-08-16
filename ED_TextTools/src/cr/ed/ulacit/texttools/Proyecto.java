/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

import cr.ed.ulacit.texttools.util.TextFileReader;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.model.WordFrequency;


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

        System.out.println("----------------------- TEXTO PURIFICADO ----------------------------");
        
        List<WordFrequency> doc = purifier
                .extractSemanticVocabulary(converter
                        .toList(text)
                );
        System.out.println(doc);
        

        /*List<String> purificadas = purifier.purify(miTexto.toList(text));
        // Ahora las vamos a meter en el Trie.
        Trie<WordFrequency> documento = new ExtendedASCIIConcurrentTrie<WordFrequency>();

        Iterator<String> iter = purificadas.iterator();

        while (iter.hasNext()) {
            String tmp = iter.next();
            
            // Si la palabra ya existía en el Trie entonces solo aumentamos 
            // la frecuencia
            if(documento.contains(tmp)){
                documento.get(tmp).inc();
            } // IF ENDS
            else{
                documento.put(tmp, new WordFrequency(tmp));
            } // ELSE ENDS
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
        Comparator<WordFrequency> c = new WordFrequencyComparator();
        List<WordFrequency> vocabulario = documento.list(c);
        
        System.out.println(" --------------------------------------------------------------------");
        System.out.println(" VOCABULARIO PURIFICADO ");
        System.out.println(" --------------------------------------------------------------------");
        System.out.println(vocabulario);
        */


    }

}
