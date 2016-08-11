/*
 * Copyright (C) 2016 Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
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
import java.util.NoSuchElementException;

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
        
        // ===================================================================== //
        // CLASS ATTRIBUTES                                                      //
        // ===================================================================== //
        
        /**
         * Nodo al que el iterador apunta actualmente
         */
        private Node<E> current;
        
        private boolean allowRemove;
        
        private final ConcurrentLinkedList<E> list;
        
        // --------------------------------------------------------------------- //
        // CLASS CONSTRUCTOR                                                     //
        // --------------------------------------------------------------------- //
        /**
         * Permite crear instancias de un lista doblemente enlazada con acceso 
         * concurrente de hilos de ejecución. 
         * @param current Referencia al nodo al que se encuentra apuntando
         *                el iterador.
         * @param list  Referencia a la lista de elementos que el iterador está
         *              iterando actualmente.
         */
        public ConcurrentListIterator(final Node<E> current, 
                final ConcurrentLinkedList<E> list){
            this.current = current;
            this.allowRemove = true;
            this.list = list;
        } // CLASS CONSTRUCTOR ENDS -------------------------------------------- //
        
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
            //System.out.println(this.current.getNext().getElement());
            return this.current.getNext() != null;
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
            E element;
            if(this.current.getNext() != null){
                // Nos movemos al elemento siguiente
                this.current = this.current.getNext();
                element = this.current.getElement();
                this.allowRemove = true;
            } // IF ENDS
            else{
                element = null;
            } // ELSE ENDS
            return element;
        } // METHOD NEXT ENDS -------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD REMOVE                                                         //
        // --------------------------------------------------------------------- //
        /**
         * Elimina el último elemento devuelvo por el iterador. Este método se 
         * llama únicamente una vez por cada .next() que se haga. De lo 
         * contrario arroja una excepción. 
         */
        @Override
        public void remove() {
            if(this.allowRemove){
                
                // Se debe eliminar el último elemento que ha retornado el iterador
                // por medio del método .next(). Por lo tanto siempte debe eliminar
                // el elemento en la posición "current"
                
                // Primero se verifica si el elemento que se requiere eliminar
                // es el primer elemento de la lista
                if(this.current.previous == null){
                    Node<E> tmp = new Node<E>(null);
                    tmp.setNext(this.current.next);
                    this.list.setFirst(this.current.next);
                    this.current.next.setPrevious(null);
                    this.current = tmp;
                } // IF ENDS
                else{
                    // SI NO ES EL ÚLTIMO ENTONCES OTRAS REGLAS APLICAN
                    Node<E> aux = this.current;
                    this.current = aux.previous;
                    // Le decimos al siguiente del que queremos borrar que
                    // su nuevo siguiente anterior es el anterior del elemento
                    // que se quiere borrar si existe un siguiente.
                    if(aux.next != null){
                        aux.next.previous = this.current;
                        this.current.next = aux.next;
                    }else{
                        // En este caso el elemento que vamos a borrar es el 
                        // último elemento de la lista.
                        this.current.next = null;
                    } // ELSE 
                    aux = null; // Eliminamos el elemento.
                } // ELS ENDS
            }// IF ENDS
            else{
                throw new NoSuchElementException("Eliminación no autorizada. Solo se puede elimnar una vez por cada next()");
            } // ELSE ENDS
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
    
    /**
     * Almacena la cantidad de elementos que se encuentran en la lista
     */
    private int count;
    
    /**
     * Almacena una instancia de un comparador que permite realizar comparaciones
     * entre objetos.
     */
    private Comparator<E> comp;
    
    // ========================================================================= //
    // CONSTRUCTOR DE LA CLASE                                                   //
    // ========================================================================= //
    /**
     * Crea instancias de una lista doblemente enlazada con soporte para acceso
     * concurrente
     * @param comparator Requiere una instancia de comparador que permite evaluar
     *                   si dos objetos son el mismo, uno es mayor que otro o uno
     *                   es menor el que el otro.
     */
    public ConcurrentLinkedList(final Comparator<E> comparator){
        // Se asigna el comparador de la lista
        this.comp = comparator;
    } // CONSTRUCTOR METHOD ENDS =============================================== //
    
    
    // ========================================================================= //
    // MÉTODOS PÚBLICOS DE LA CLASE                                              //
    // ========================================================================= //
    
    /**
     * Solo debe ser utilizado por el iterador. No utilizar en otra situación
     */
    protected void decrese(){
        this.count = this.count -1;
    } // METHOD DECREASE ------------------------------------------------------- //
    
    /**
     * Solo debe ser utilizado desde el iterador. 
     * @param node 
     */
    protected void setFirst(final Object node){
        this.first = (Node<E>)node;
    } // SET FIRST ENDS -------------------------------------------------------- //
    
    /**
     * Solo debe ser utilizado por el iterador por lo que se encuentra solo 
     * accesible dentro del mismo paquete.
     * @param node 
     */
    protected void setLast(final Object node){
        this.last = (Node<E>)node;
    } // METHOD SET LAST ENDS -------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD SIZE                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener la cantidad de elementos que se eneucuentran almacenados 
     * en la lista.
     * @return El tamaño de la lista 
     */
    @Override
    public synchronized int size() {
        return this.count;
    } // METHOD SIZE ENDS ------------------------------------------------------ //

    // ------------------------------------------------------------------------- //
    // METHOD ADD                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Permite agregar elementos al final de la lista
     * @param element el elemento que se requeire insertar en la lista.
     * @return true si el elemento fue agregado a la lista correctamente o false
     *         si el elemento no fue agregado. 
     */
    @Override
    public synchronized boolean add(E element) {
        boolean added = false;
        // Primero debemos crear un nuevo nodo con el elemento que vamos a 
        // insertar y colocar el elemento.
        Node<E> node = new Node<>(element);
        // Tenemos varios casos, el primero es que la lista esté vacía y 
        // por lo tanto tenemos que agregar un primero elemento
        if(this.first == null){
            this.first = node;
            this.last = node;
            // Actualizamos las referencias
            node.setPrevious(null);
            node.setNext(null);
            added = true;
        } // IF ENDS
        else{
            // En el caso de que la lista ya tenga elementos entonces solo se 
            // debe insertar al final de la lista. 
            this.last.setNext(node);
            node.setPrevious(this.last);
            node.setNext(null);
            this.last = node;
            added = true;
        } // ELSE ENDS
        // Aumentamos la cantidad de elementos de la lista en 1. 
        this.count++;
        // Notifica a los demás hilos que el lock ha sido liberado
        notify();
        return added;
    } // METHOD ADD ENDS ------------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD CLEAR                                                              //
    // ------------------------------------------------------------------------- //
    /**
     * Elimina todos los elementos de la lista y 
     */
    @Override
    public void clear() {
        this.last = null;
        this.first = null;
        this.count = 0;
        System.gc();
    } // METHOD CLEAR ENDS ----------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD CONTAINS                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite determinar si un elemento particular existe dentro de la lista
     * @param element
     * @return true si el elemento se encuentra dentro de la lista. False si el 
     *          elemento no se encuentra dentro de la lista.
     */
    @Override
    public boolean contains(E element) {
        boolean exists = false;
        // Verificamos primero si la lista tiene elementos
        if(this.first != null){
            // Si la lista tiene elementos entonces utilizamos un iterador para
            // verificar si el elementos existe. 
            Iterator<E> iter = this.iterator();
            while(iter.hasNext() && !exists){
                // Verificamos si el elemento siguiente al iterador 
                if(this.comp.compare(iter.next(), element) == 0){
                    exists = true;
                } // IF ENDS
            } // WHILE ENDS
        } // IF ENDS
        return exists;
    } // METHOD CONTAINS ENDs -------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD GET                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener un elemento en una posición dada de la lista
     * @param index
     * @return el elemento o null si el elemento o la posición no es válida
     */
    @Override
    public E get(int index) {
        E element = null;
        /**
         * Primero verificamos si la lista tiene elementos, de lo contrario no es
         * necesario iterar por la misma para deterinar si el elemento que se 
         * requiere eliminar existe o no.
         */
        if(index < this.count && this.first != null){
           
            if(index == 0){
               element = this.first.getElement();
            } // IF ENDS
            else{
                // CASO B - Se desea eliminar el último elemento.
                if((this.count-1) == index){
                   element = this.last.getElement();
                } // IF ENDS
                else{
                    Node<E> aux = this.first;
                    // Movemos aux hasta la posición antes de la que 
                    // queremos eliminar
                    for(int i = 0; i < index - 1;++i ){
                        aux = aux.getNext();
                    } // FOR ENDS
                    element = aux.getElement();
                } // ELSE ENDS
            } // ELSE ENDS
           System.gc();
        } // IF ENDS
        return element;
    } // METHOD GET ENDS ------------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD IS EMPTY                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite determinar si una lista se encuentra vacía o no
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return (this.first == null && this.count == 0);
    } // METHOD IS EMPTY ENDS -------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD ITERATOR                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener un iterador de la lista que se encuentra en una posición
     * antes del primero elemento de la lista
     * @return 
     */
    @Override
    public Iterator<E> iterator() {
        // Creamos un nodo comodín cuyo propósito es ser una posición virtual 
        // anterior el primero elemento de la lista con el objetivo de que el 
        // siguiente de este elemento sea el primero elemento de la lista.
        Node<E> beforeElement = new Node<>(null);
        beforeElement.setNext(this.first);
        return new ConcurrentListIterator<E>(beforeElement, this);
    } // METHOD ITERATOR ENDS -------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD REMOVE                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Si la posición indicada es válida, este método elimina el elemento que 
     * se encuentra en la posición dada. Importante recordar que la primera 
     * posición es 0 por lo que la lista tiene <tt>.size() -1 </tt> posiciones 
     * válidas.
     * @param index
     * @return true si la posición es válida y el elemento fue eliminado o false
     *         si la posición no es válida o el elemento no fue eliminado. 
     */
    @Override
    public boolean remove(int index) {
        boolean removed = false;
        /**
         * Primero verificamos si la lista tiene elementos, de lo contrario no es
         * necesario iterar por la misma para deterinar si el elemento que se 
         * requiere eliminar existe o no.
         */
        if(index < this.count && this.first != null){
            
            /**
             * Para eliminar elementos se tienen 3 casos:
             * a- Que el elemento que requerimos eliminar sea el primer elemento
             *    de la lista.
             * b- Que el elemento que requerimos eliminar sea el último elemento
             *    de la lista.
             * c- Que el elemento que requerimos eliminar si encuentre en medio 
             *    de la lista
             */
           
            // CASO A
            if(index == 0){
                if(this.first.getNext() != null){
                    this.first = this.first.getNext();
                    this.first.setPrevious(null);
                } // IF ENDS
                else{
                    this.first = null;
                    this.last = null;
                } // ELSE ENDS
                removed = true;
                this.count = (this.count - 1);
            } // IF ENDS
            else{
                // CASO B - Se desea eliminar el último elemento.
                if((this.count-1) == index){
                    this.last = this.last.getPrevious();
                    this.last.setNext(null);
                    removed = true;
                    this.count = (this.count - 1);
                    System.gc();
                } // IF ENDS
                else{
                    Node<E> aux = this.first;
                    // Movemos aux hasta la posición antes de la que 
                    // queremos eliminar
                    for(int i = 0; i < index - 2;++i ){
                        aux = aux.getNext();
                    } // FOR ENDS
                    aux.getNext().getNext().setPrevious(aux);
                    aux.setNext(aux.getNext().getNext());
                    removed = true;
                    this.count = (this.count - 1);
                    System.gc();
                } // ELSE ENDS
            } // ELSE ENDS
           System.gc();
        } // IF ENDS
        return removed;
    } // METHOD REMOVE ENDS ---------------------------------------------------- //
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator<E> i = this.iterator();
        sb.append("{");
        while(i.hasNext()){
            sb.append(i.next().toString());
            sb.append("\n");
        } // WHILE
        sb.append("}");
        return sb.toString();
    } // METHOD TO STRING ENDS-------------------------------------------------- //
    
} // CLASS LIST ENDS ----------------------------------------------------------- //
