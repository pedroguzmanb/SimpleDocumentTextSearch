/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.dstructures;

// ============================================================================= //
// INTERFACE TRIE                                                                //
// ============================================================================= //
/**
 * Las implementaciones de Trie representan una conjunto de pares de llaves y 
 * valores en los cuales la llave son cadenas de caracteres. Los Tries están 
 * optimizados 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <T> Tipo de dato de los valores que se almacenan en el Trie.
 */
public interface Trie <T>{
    
    // ------------------------------------------------------------------------- //
    // METHOD GET                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Si existe un elemento con la llave solicitada, entonces deveuelve una re-
     * ferencia al elemento asociado a la llave
     * @param key llave asociada al elemento
     * @return elemento asociado a la llave o null si el elemento no existe 
     *         dentro del trie
     */
    T get(String key);
    
    // ------------------------------------------------------------------------- //
    // METHOD CONATAINS                                                          //
    // ------------------------------------------------------------------------- //
    /**
     * Permite evaluar si un elemento asociado a la llave recibida como parámetro
     * existe o no dentro de los elementos de trie.
     * @param key
     * @return 
     */
    boolean contains(String key);
    
    // ------------------------------------------------------------------------- //
    // METHOD PUT                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Permite ingresar un elemento dentro del Trie con una llave asociada. 
     * @param key
     * @param element
     * @return 
     */
    Trie<T> put(String key, T element);
    
    // ------------------------------------------------------------------------- //
    // METHOD SIZE                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Devuelve la cantidad de elementos almacenados en el Trie
     * @return la cantidad de elementos en el Trie
     */
    int size();
    
    // ------------------------------------------------------------------------- //
    // METHOD IS EMPTY                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite evaluar si el trie tiene elementos o si se eneucntra vacío
     * @return true si el trie <tt> no </tt> contiene elemetos
     */
    boolean isEmpty();
    
    // ------------------------------------------------------------------------- //
    // METHOD DELETE                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Elimina el elemento asociado a la llave proporcionada si es elemento existe
     * @param key // Llave asociada al elemento que se desea eliminar
     * @return Referencia a la instancia de Trie para permitir encadenamiento de
     *         metodos. 
     */
    Trie<T> delete(String key);
    
    
} // INTERFACE TRIE ENDS ------------------------------------------------------- //
