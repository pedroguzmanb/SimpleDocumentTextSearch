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
    public TextPurifier(final List<String> stopWords) {
        this.stopWords = stopWords;
    } // CONSTRUCTOR METHOD ENDS ----------------------------------------------- //

    TextPurifier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<String> stopWord(String stopWords) {
        List<String> stopWordList = new ConcurrentLinkedList<String>(new TextComparator());
        String[] stopWordArray = stopWords.split("A-Za-z0-9");
        return stopWordList;
    }

    // ------------------------------------------------------------------------- //
    // METHOD PURIFY                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Este método recibe una lista de Strings que compone todas las palabras de
     * un texto. El método se encarga de eliminar todos los stopwords que
     * aparecen y devuelve la lista del texto pero sin todos los stopwords que
     * fueron eliminados.
     *
     * @param text
     * @return
     */
    public List<String> purify(List<String> text) {
        // TO DO SALGUA -- escribir acá el código que alimina los stop words
        Iterator<String> iterText = text.iterator();
        Iterator<String> iterStopWords=stopWords.iterator();
        
        while(iterStopWords.next()!= null){
        while(iterText.next()!=null){
        if(iterStopWords.next()==iterText.next()){
        iterText.next();
        iterText.remove();
        }
        }iterStopWords.next();
        
        }

        // RECOMENDACIÓN: utilizar el iterador para eliminar los stopwords
        return text;
    } // METHOD PURIFY --------------------------------------------------------- //

} // CLASS TEXT PURIFIER ------------------------------------------------------- //
