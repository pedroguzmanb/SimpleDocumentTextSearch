/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

// ----------------------------------------------------------------------------- //
import cr.ed.ulacit.dstructures.Iterator;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.impl.ConcurrentLinkedList;
import cr.ed.ulacit.texttools.util.TextComparator;

// CLASS TEXT PURIFIER                                                           //
// ----------------------------------------------------------------------------- //
/**
 * Esta clase representa un purificador de texto. Contiene métodos que permiten
 * eliminar los stopwords de un texto representado como una lista de String.
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @author Salgua Salha (ssalhaa954@ulacit.ed.cr)
 */
public class TextPurifier {

    // ========================================================================= //
    // ATRIBUTOS DE LA CLASE                                                     //
    // ========================================================================= //
    // Almacena un diccionario de stopwords que deben ser removidas del texto 
    // para purificarlo y dejar solo las palabras que aportan contenido relevante
    private final List<String> stopWords;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR METHOD                                                        //
    // ------------------------------------------------------------------------- //
    /**
     * Crea instancias de un purificador de text
     *
     * @param stopWords
     */
    public TextPurifier(final String stopWords) {
        this.stopWords = this.stopWords(stopWords);
    } // CONSTRUCTOR METHOD ENDS ----------------------------------------------- //
    

    // ------------------------------------------------------------------------- //
    // METHOD STOP WORDS                                                         //
    // ------------------------------------------------------------------------- //
    /**
     * REALIZA: 
     * @param stopWords
     * @return 
     */
    private List<String> stopWords(String stopWords) {
        List<String> stopWordList = new ConcurrentLinkedList<String>(new TextComparator());
        String[] stopWordArray = stopWords.toUpperCase().split("[^A-Za-z0-9'\"]");
        for(String word : stopWordArray){
            // Solo agregamos palabras, no cambios de línea o espacios
            if(word != "\n" || word != "" || word != " "){
                stopWordList.add(word);
            } // IF ENDS 
        } // FOR ENDS
        // DEBUG
        //System.out.println(stopWordList);
        return stopWordList;
    } // METHOD STOP WORDS ENDS ------------------------------------------------ //

    // ------------------------------------------------------------------------- //
    // METHOD PURIFY                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Este método recibe una lista de Strings que compone todas las palabras de
     * un texto. El método se encarga de eliminar todos los stopwords que
     * aparecen y devuelve la lista del texto pero sin todos los stopwords que
     * fueron eliminados.
     * 
     * TODO - implementar esto con un lista divididad e hilos para lograr un 
     * mejor rendimiento.
     *
     * @param text
     * @return
     */
    public List<String> purify(List<String> text) {
        // TO DO SALGUA -- escribir acá el código que alimina los stop words
        for(int i = 0; i < this.stopWords.size(); ++i){
            Iterator<String> textIter = text.iterator();
            while(textIter.hasNext()){
                // Se re-implementó la comparación de strings por medio de 
                // HashCodes que son valores numéricos y por lo tanto 
                // más rápido de comparar
                if(textIter.next().hashCode() == this.stopWords.get(i).hashCode()){
                    textIter.remove();
                    System.out.println("Removido: " + this.stopWords.get(i));
                } // if ENDS
            } // WHILE ENDS
        } // FOR ENDS
        System.out.println("----------------------------------------------------");
        System.out.println("TEXTO PURIFICADO: \n" + text);
        return text;
    } // METHOD PURIFY --------------------------------------------------------- //

} // CLASS TEXT PURIFIER ------------------------------------------------------- //
