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

import cr.ed.ulacit.dstructures.Queue;

/**
 * Esta clase es la implementación de una cola con soporte para acceso 
 * concurrente.
 * @author Salgua Salha (ssalhaa954@ulacit.ed.cr)
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class LinkedQueue<E> implements Queue<E>{
    
    // ------------------------------------------------------------------------- //
    // CLASS NODE                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Representa un nodo de la cola. 
     * @param <E> 
     */
    private class Node<E>{
        
        // ===================================================================== //
        // ATRIBUTOS DE LA CLASE                                                 //
        // ===================================================================== //
        
        private E element;
        
        private Node<E> next;

        /**
         * 
         * @param element 
         */
        public Node(E element) {
            this.element = element;
        }
        /**
         * 
         * @return 
         */
        public E getElement() {
            return element;
        }

        /**
         * 
         * @param element 
         */
        public void setElement(E element) {
            this.element = element;
        }

        /**
         * 
         * @return 
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * 
         * @param next 
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }
        
    } // CLASS NODE ENDS ------------------------------------------------------- //
   private Node<E> first;
    
    /**
     * Esto debe colocar un elemento al final de la cola
     * @param element 
     */
    @Override
    public void queue(E element) {
        // TODO SALGUA
                Node<E> newElement = new Node<E>(element);
        newElement.setNext(null);

        if (this.first == null) {
            this.first = newElement;
            newElement.setNext(null);
        } else {

            Node<E> aux = this.first;

            while (aux != null) {
                if (aux.getNext() == null) {

                    aux.setNext(newElement);

                }
                aux = aux.getNext();
            }
        }
    }

    /**
     * Esto debe sacar un elemento al inicio de la cola
     * @return 
     */
    @Override
    public E dequeue() {
        // TODO SALGUA
        E element = null;
        if (this.first != null) {
           
            element = this.first.getElement();
         
            if (this.first.getNext() != null) {
           
                this.first = this.first.getNext();
            } 
            else {
                this.first = null;
            } 
        } 
        return element;
    }
    }


    
    
