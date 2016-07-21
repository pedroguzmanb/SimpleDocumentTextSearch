/*
 * Copyright (C) 2016 Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cr.ed.ulacit.dstructures.impl;

import cr.ed.ulacit.dstructures.Comparator;
import cr.ed.ulacit.dstructures.Iterator;
import cr.ed.ulacit.dstructures.List;

// ----------------------------------------------------------------------------- //
// CLASS CONCURRENT LINKED LIST                                                  //
// ----------------------------------------------------------------------------- //
/**
 * Esta clase representa una lista doblemente enlazada con soporte para acceso 
 * concurrente por medio de métodos sincronizados.
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <E>
 */
public class ConcurrentLinkedList<E> implements List<E>{
    
    // ========================================================================= //
    // CLASES INTERNAS                                                           //
    // ========================================================================= //
    
    // ------------------------------------------------------------------------- //
    // CLASS CONCURRENT LIST ITERATOR                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Implementación de un iterador de Lista doblemente enlazada con soporte 
     * para concurrencia
     * @param <E> 
     */
    public class ConcurrentListIterator<E> implements Iterator<E>{
        
        // --------------------------------------------------------------------- //
        // METHOD HAS NEXT                                                       //
        // --------------------------------------------------------------------- //
        /**
         * Permite obtener un valor boolean indicando si existe un elemento 
         * siguiente a la posición actual del iterador.
         * @return 
         */
        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); 
        } // METHOD HAS NEXT --------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD NEXT                                                           //
        // --------------------------------------------------------------------- //
        /**
         * Mueve el iterador a la posición siguiente y devuelve una referencia 
         * al elemento que se encuentra en esa posición de la lista o null si 
         * no existe un elemento siguiente en la lista
         * @return 
         */
        @Override
        public E next() {
            throw new UnsupportedOperationException("Not supported yet."); 
        } // METHOD NEXT ENDS -------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD REMOVE                                                         //
        // --------------------------------------------------------------------- //
        /**
         * Elimina el último elemento devuelvo por el iterador. Este método se 
         * llama 
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); 
        } // METHOD REMOVE ENDS ------------------------------------------------ //
    
    } // CLASS CONCURRENT LIST ITERATOR ENDS ----------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // CLASS NODE                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Representa un nodo de una lista doblemente enlazada con soporte para 
     * concurrencia o ThreadSafe.
     * @param <E> 
     */
    private class Node<E> {
    
        // --------------------------------------------------------------------- //
        // ATRIBUTOS DE LA CLASE                                                 //
        // --------------------------------------------------------------------- //
        
        /**
         * Elemento que se encuentra almacenado dentro del nodo
         */
        private E element;
        
        /**
         * Referencia al elemento siguiente de la lista o null si este es el 
         * último elemento de la lista
         */
        private Node<E> next;
        
        /**
         * Referencia al elemento anterior de la lista
         */
        private Node<E> previous;

        // --------------------------------------------------------------------- //
        // CONSTRUCTOR POR DEFECTO DE LA CLASE                                   //
        // --------------------------------------------------------------------- //
        /**
         * Crea instancias de un nodo de lista con un elemento adentro
         * @param element 
         */
        public Node(E element) {
            this.element = element;
        } // CONSTRUCTOR ENDS -------------------------------------------------- //
        
        // ===================================================================== //
        // SETTERS Y GETTERS DE LA CLASE                                         //
        // ===================================================================== //

        // --------------------------------------------------------------------- //
        // GET                                                                   //
        // --------------------------------------------------------------------- //
        /**
         * Obtiene el elemento almacenado dentro del nodo
         * @return 
         */
        public synchronized E getElement() {
            return element;
        } // METHOD GET ELEMENT ENDS ------------------------------------------- //

        // --------------------------------------------------------------------- //
        // SET                                                                   //
        // --------------------------------------------------------------------- //
        /**
         * Permite colocar un elemento dentro del nodo
         * @param element 
         */
        public synchronized void setElement(E element) {
            this.element = element;
        } // METHOD SET ELEMENT ENDS ------------------------------------------- //

        // --------------------------------------------------------------------- //
        // GET                                                                   //
        // --------------------------------------------------------------------- //
        /**
         * Obtiene una referencia al elemento siguiente en la lista
         * @return 
         */
        public synchronized Node<E> getNext() {
            return next;
        } // METHOD GET NEXT --------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // SET                                                                   //
        // --------------------------------------------------------------------- //
        /**
         * Obtiene una referencia al elemento siguiente del nodo
         * @param next 
         */
        public synchronized void setNext(Node<E> next) {
            this.next = next;
        } // METHOD SET NEXT ENDS ---------------------------------------------- //

        // --------------------------------------------------------------------- //
        // GET                                                                   //
        // --------------------------------------------------------------------- //
        /**
         * Pemite obtener una referencia del nodo anterior
         * @return 
         */
        public synchronized Node<E> getPrevious() {
            return previous;
        } // METHOD GET PREVIOUS ----------------------------------------------- //

        // --------------------------------------------------------------------- //
        // SET                                                                   //
        // --------------------------------------------------------------------- //
        /**
         * Permite establecer una referencia del nodo anterior
         * @param previous 
         */
        public synchronized void setPrevious(Node<E> previous) {
            this.previous = previous;
        } // METHOD SET PREVIOUS ----------------------------------------------- //
        
        
    } // CLASS NODE ENDS ------------------------------------------------------- //
    
    // ========================================================================= //
    // ATRIBUTOS DE LA CLASE                                                     //
    // ========================================================================= //
    
    /**
     * Referencia al primer elemento de la lista o null si la lista se encuentra
     * vacía
     */
    private Node<E> first;
    
    /**
     * Referencia al último elemento de la lista o null si la lisa se encuentra 
     * vacía
     */
    private Node<E> last;
    
    private int count;
    
    private Comparator<E> comp;
    
    
    // ========================================================================= //
    // MÉTODOS PÚBLICOS DE LA CLASE                                              //
    // ========================================================================= //

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean add(E element) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
} // CLASS LIST ENDS ----------------------------------------------------------- //
