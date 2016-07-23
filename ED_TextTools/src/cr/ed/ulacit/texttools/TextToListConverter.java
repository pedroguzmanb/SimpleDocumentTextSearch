/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

// Importamos la lista doblemente enlazada que implementamos en el paquete de 
// estructuras
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.impl.ConcurrentLinkedList;
import cr.ed.ulacit.texttools.util.TextComparator;


// ============================================================================= //
// TEXT TO LIST CONVERTER                                                        //
// ============================================================================= //
/**
 * Esta clase representa un convertor de texto a lista. Lo provee son métodos que 
 * permiten convertir un String a una lista de palabras por medio de un proceso 
 * de eliminación de puntuación y caracteres especiales. La idea es que sólo 
 * quede una lista en la cual cada elemento es una palabra del texto. 
 * @author Salgua Salha (ssalhaa954@ulacit.ed.cr)
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class TextToListConverter {
    
    // ------------------------------------------------------------------------- //
    // METHOD TO LIST                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Este método recibe un string que contiene todo un texto con puntuación y 
     * lo transforma en una lista de palabras sin puntuación. Cada elemento de la
     * lista es una palabra del texto. La conversión utiliza expresiones regulares
     * para eliminar la puntuación.
     * @param text
     * @return 
     */
    public List<String> toList(String text){
        
        // Primero ocupamos declara una lista vacía donde vamos a agregar las 
        // palabras una vez que hemos eliminado la puntuación y utilizado el 
        // método split() de la clase String para dividir el texto en un vector
        // o arreglo de palabras.
        List<String> words = new ConcurrentLinkedList<String>(new TextComparator());
        
        // RECOMENDACIONES: Antes de insertar los elementos en la lista, se debe
        //                  convertir todo el text a mayúscula para que no exista
        //                  diferencia entre un texto en minúscula y otro en 
        //                  mayúscula. Lo que nos interesa es el significado de
        //                  las palabras. 
        
        
        // (TO DO SALGUA) -- Aquí se debe implementar la lógica de éste método
        
        
        // Al final, en la lista words deben estar todas las palabras que 
        // componen el texto sin puntuación.
        return words;
    } // METHOD TO LIST ENDS --------------------------------------------------- //
    
} // METHOD TEXT TO LIST CONVERTER --------------------------------------------- //
