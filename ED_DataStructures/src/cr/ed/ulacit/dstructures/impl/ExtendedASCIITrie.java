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
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <T> Tipo de los elementos que serán almacenados en el Trie
 */
public class ExtendedASCIITrie<T> implements Trie<T>{
    
    // ========================================================================= //
    // PRIVATE CLASS NODE                                                        //
    // ========================================================================= //
    /**
     * Representa un nodo del Trie que puede contener elementos de tipo <tt>T</TT>
     * @param <T> Tipo del elemento que se va a almacenar en el Trie.
     */
    private static class Node<T>{
        
        // --------------------------------------------------------------------- //
        // ATRIBUTOS DE LA CLASE                                                 //
        // --------------------------------------------------------------------- //
        
        private T element; // Elemento almacenado en el nodo
        
        private Node<T>[] next; // Vector de referencias a los siguientes nodos
        
        // --------------------------------------------------------------------- //
        // CONSTRUCTOR METHOD                                                    //
        // --------------------------------------------------------------------- //
        /**
         * Crea instancias de nodos recibiendo el elemento que se va a guardar
         * como parámetros
         * @param element elemento que será almacenado en el Trie
         */
        public Node(final T element){
            this.element = element;
        } // CONSTRUCTOR METHOD ENDS ------------------------------------------- //
        
        //TODO SETTERS Y GETTER Y METODOS AUXILIARES DEL TRIE
        
        
    } // PRIVATE CLASS NODE ENDS =============================================== //
    
    
    // ========================================================================= //
    // CLASS CONSTANTS                                                           //
    // ========================================================================= //
    
    // Cantidad de caracteres válidos en el alfabeto ASCII extendido. 
    private static final int ASCII_EXTENDED = 256;

    @Override
    public T get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean contains(String key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Trie<T> put(String key, T element) {
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
