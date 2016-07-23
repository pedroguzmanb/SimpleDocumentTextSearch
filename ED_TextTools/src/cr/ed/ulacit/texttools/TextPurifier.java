/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

// ----------------------------------------------------------------------------- //

import cr.ed.ulacit.dstructures.List;

// CLASS TEXT PURIFIER                                                           //
// ----------------------------------------------------------------------------- //
/**
 * Esta clase representa un purificador de texto. Contiene métodos que permiten
 * eliminar los stopwords de un texto representado como una lista de String.
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
     * @param stopWords 
     */
    public TextPurifier(final List<String> stopWords){
        this.stopWords = stopWords;
    } // CONSTRUCTOR METHOD ENDS ----------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD PURIFY                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Este método recibe una lista de Strings que compone todas las palabras de
     * un texto. El método se encarga de eliminar todos los stopwords que aparecen
     * y devuelve la lista del texto pero sin todos los stopwords que fueron 
     * eliminados.
     * @param text
     * @return 
     */
    public List<String> purify(List<String> text){
        // TO DO SALGUA -- escribir acá el código que alimina los stop words
        
        // RECOMENDACIÓN: utilizar el iterador para eliminar los stopwords
        return text;
    } // METHOD PURIFY --------------------------------------------------------- //
    
} // CLASS TEXT PURIFIER ------------------------------------------------------- //
