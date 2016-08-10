/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.dstructures.impl;

// ============================================================================= //
// IMPORTS                                                                       //
// ============================================================================= //
import cr.ed.ulacit.dstructures.Trie;

// ============================================================================= //
// CLASS EXTENDED ASCII TRIE ---[IMPLEMENTS]---> TRIE                            //
// ============================================================================= //
/**
 * Implmementa un Trie con soporte para el alfabeto ASCII Extendido el cual
 * cuenta con un total de 256 caracteres válidos con los que se pueden conformar
 * las llaves de indexación
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <T> Tipo de los elementos que serán almacenados en el Trie
 */
public class ExtendedASCIIConcurrentTrie<T> implements Trie<T> {
    
    // ========================================================================= //
    // CLASS CONSTANTS                                                           //
    // ========================================================================= //
    
    private static final int CHARSET = 256;        // extended ASCII
    
    // ========================================================================= //
    // CLASS ATTRIBUTES                                                          //
    // ========================================================================= //
    
    // Esta es una referencia al nodo raíz del Trie. El nodo raíz contiene un
    // vector que puede almacenar los 256 caracteres válidos de ASCII extendido
    private Node<T> root;
    
    // Almacena la cantidad de elementos que han sido almacenados en el Trie
    private int size;

    // ========================================================================= //
    // PRIVATE CLASS NODE                                                        //
    // ========================================================================= //
    /**
     * Representa un nodo del Trie que puede contener elementos de tipo
     * <tt>T</TT>
     *
     * @param <T> Tipo del elemento que se va a almacenar en el Trie.
     */
    private static class Node<T> {

        // --------------------------------------------------------------------- //
        // ATRIBUTOS DE LA CLASE                                                 //
        // --------------------------------------------------------------------- //
        private T element; // Elemento almacenado en el nodo

        // Vector de referencias a los siguientes nodos
        private final Object[] next = new Object[CHARSET]; 

        // --------------------------------------------------------------------- //
        // CONSTRUCTOR METHOD                                                    //
        // --------------------------------------------------------------------- //
        /**
         * Crea instancias de nodos recibiendo el elemento que se va a guardar
         * como parámetros
         *
         * @param element elemento que será almacenado en el Trie
         */
        public Node(final T element) {
            this.element = element;
        } // CONSTRUCTOR METHOD ENDS ------------------------------------------- //
        
        
        /**
         * 
         */
        public Node(){
        
        } // CLASS DEFAULT CONSTRUCTOR ----------------------------------------- //

        //TODO SETTERS Y GETTER Y METODOS AUXILIARES DEL TRIE
        public T get(String key, int d) {
            
            if (key.length() != d) {

            } // IF ENDS
            return this.element;
        } // METHOD ENDS ------------------------------------------------------- //

    } // PRIVATE CLASS NODE ENDS =============================================== //
    // ------------------------------------------------------------------------- //
    // METHOD PUT                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Este metodo permite insertar elementos nuevos dentro del trie utilizando
     * una cadena de caracteres como llave de ubicación para posicionar el
     * elemento dentro del trie.
     *
     * @param key
     * @param element
     * @return
     */
    @Override
    public Trie<T> put(String key, T element) {
        throw new UnsupportedOperationException("Not supported yet.");
    } // METHOD PUT ENDS ------------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD GET                                                                //
    // ------------------------------------------------------------------------- //
    /**
     *
     * @param key
     * @return
     */
    @Override
    public T get(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Trie<T> delete(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

} // CLASS EXTENDED ASCII TRIE ENDS -------------------------------------------- //
