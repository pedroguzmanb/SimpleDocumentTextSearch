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
 *
 * @author Salgua Salha (ssalhaa954@ulacit.ed.cr)
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class ConcurrentLinkedQueue<T> implements Queue<T> {

    // ------------------------------------------------------------------------- //
    // DECLARACIÓN DE CONSTANTES                                                 //
    // ------------------------------------------------------------------------- //
    // Especifica la capacidad máxima de la cola
    public static final int MAX_CAPACITY = Integer.MAX_VALUE;

    // ------------------------------------------------------------------------- //
    // DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE                                  //
    // ------------------------------------------------------------------------- //
    // Referencia al primer elemento de la cola
    private Node<T> first;

    // Cantidad actual de elementos en la cola.
    private int size;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR DE LA CLASE                                                   //
    // ------------------------------------------------------------------------- //
    /**
     * Crea instancias de SuperCola
     */
    public ConcurrentLinkedQueue() {
        this.size = 0;
        this.first = null; // La cola se crea siempre vacía inicialmente.
    } // CONSTRUCTOR DE LA CLASE SUPER COLA ENDS ------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD SEARCH                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener un element en la posicion especificada como parámetro. Si
     * la posición existe, entonces devuelve una referencia a la instancia, si
     * no existe, devuelve null.
     *
     * @param posicion
     * @return
     */
    public T get(int posicion) {
        T element = null;
        // NOTA: Hay 10 posiciones pero van desde 0 a 9
        if (posicion <= this.size - 1) {
            Node<T> aux = this.first;
            for (int i = 0; i < posicion; ++i) {
                aux = aux.getNext();
            } // FOR ENDS
            element = aux.getElement();
        } // IF ENDS 
        return element;
    } // SEARCH ENDS ----------------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD DELETE                                                             //
    // ------------------------------------------------------------------------- //
    /**
     *
     * @param posicion
     * @return
     */
    public void delete(int posicion) {
        // NOTA: Hay 10 posiciones pero van desde 0 a 9
        if (posicion <= this.size - 1) {
            // SI la posición es la primera posición entonces solo llamamos
            // a dequeue
            if (posicion == 0) {
                this.dequeue();
            } // IF ENDS
            else {
                // SI no es la primera posición, entonces nos movemos a la
                // posición anterior
                Node<T> aux = this.first;
                // Nos movemos a la posición anterior de la que queremos borrar
                for (int i = 0; i < posicion - 1; ++i) {
                    aux = aux.getNext();
                } // FOR ENDS
                aux.setNext(aux.getNext().getNext());
                this.size = (this.size - 1);
            } // ELSE ENDS
        } // IF ENDS 
    } // METHOD DELETE ENDS ---------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD DEQUEUE                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Saca el elemento más viejo de la cola o null si la cola está vacía
     *
     * @return
     */
    @Override
    public synchronized T dequeue() {
        T element = null;
        if (this.first != null) {
            // Obtenemos el primero elemento de la cola
            element = this.first.getElement();
            // Verificamos si hay un elemento siguiente en la cola. Sino entonces
            // la cola queda vací y first = null;
            if (this.first.getNext() != null) {
                // El nuevo primero es el siguiente
                this.first = this.first.getNext();
            } // IF ENDS
            else {
                this.first = null;
            } // ELSE ENDS
            this.size = (this.size - 1); // Especificamos que quitamos
            // un elemento de la cola
        } // IF ENDS
        notify();
        return element;
    } // METHOD DEQUEUE ENDS --------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD QUEUE                                                              //
    // ------------------------------------------------------------------------- //
    /**
     * Agrega elementos al final de la cola si la cola tiene menos de 10
     * elementos, si ya tiene 10 elementos, entonces saca el más viejo para
     * hacer espacio al elemento más nuevo.
     *
     * @param element
     * @return
     */
    @Override
    public synchronized void queue(T element) {
        Node<T> node = new Node<T>(element);
        node.setNext(null);
        // Si la cola ya tiene  10, entonces hay que sacar el elemento más viejo
        // para hacer espacio para el nuevo elemento
        if (this.size == MAX_CAPACITY) {
            // Sacamos el elemento más viejo.
            this.dequeue();
        } // IF ENDS

        // Hay dos casos para insertar elementos en la cola. Que la cola esté 
        // vacía o que la cola tenga elementos. Si está vacía entonces se inserta
        // en la primera prosición. 
        if (this.first == null) {
            this.first = node;
            node.setNext(null);
        } // IF ENDS
        else {
            // Si la cola no está vacía, entonces hay que buscar la última posición
            // para insertar el nuevo nodo
            Node<T> aux = this.first;

            // Nos movemos hasta encontrar la última posición en la cola
            while (aux != null) {
                if (aux.getNext() == null) {
                    // Insertamos en la última posición
                    aux.setNext(node);
                    break;
                } // IF ENDS
                aux = aux.getNext();
            } // WHILE ENDS
        } // ELSE ENDS
        this.size++;
        notify();
    } // METHOD QUEUE ENDS ----------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD TO STRING                                                          //
    // ------------------------------------------------------------------------- //
    /**
     * Imprime una representación de todos los elementos de la cola
     *
     * @return
     */
    @Override
    public synchronized String toString() {
        String s = "[\n";
        if (this.first != null) {
            Node<T> aux = this.first;
            while (aux != null) {
                s += aux.getElement();
                aux = aux.getNext();
            } // WHILE ENDS
        } // IF ENDS
        s += "]";
        notify();
        return s;
    } // METHOD TO STRING ENDS ------------------------------------------------- //
    
    public int size(){
        return this.size;
    }

    // ------------------------------------------------------------------------- //
    // CLASS NODE                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Representa una clase nodo de una estructura de cola que puede almacenar
     * elementos de tipo T
     *
     * @param <T>
     */
    private class Node<T> {

        // --------------------------------------------------------------------- //
        // ATRIBUTOS DE LA CLASE                                                 //
        // --------------------------------------------------------------------- //
        // Almacena el elemento contenido
        private T element;

        // Referencia al siguiente nodo o null si éste nodo es el último
        private Node<T> next;

        // --------------------------------------------------------------------- //
        // CONSTRUCTOR DE LA CLASE                                               //
        // --------------------------------------------------------------------- //
        /**
         * Crea instancias de nodo de la clase
         *
         * @param element
         */
        public Node(final T element) {
            this.element = element;
        } // CONSTRUCTOR ENDS -------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // SETTERS Y GETTERS                                                     //
        // --------------------------------------------------------------------- //
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    } // CLASS NODE ENDS ------------------------------------------------------- //
   
}
