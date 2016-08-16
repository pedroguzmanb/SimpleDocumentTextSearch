/**
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

// ============================================================================= //
// IMPORTS                                                                       //
// ============================================================================= //

import cr.ed.ulacit.dstructures.Comparator;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.Trie;

import java.util.Arrays;    // Se utiliza para soporte de expresiones Lambda en 
                            // Java.
// ============================================================================= //
// CLASS EXTENDED ASCII TRIE ---[IMPLEMENTS]---> TRIE                            //
// ============================================================================= //
/**
 * Implmementa un Trie con soporte para el alfabeto ASCII Extendido el cual
 * cuenta con un total de 256 caracteres válidos con los que se pueden conformar
 * las llaves de indexación
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @since 20/07/2016
 * @version 1.0
 * @param <T> Tipo de los elementos que serán almacenados en el Trie
 */
public class ExtendedASCIIConcurrentTrie<T> implements Trie<T> {

    // ========================================================================= //
    // CLASS CONSTANTS                                                           //
    // ========================================================================= //
    
    private static final int CHARSET = 256;        // extended ASCII
    private static final int START_POSITION = 0;   // initial pos
    private static final char C_DEFAULT = '0'; // primer caracter de e-ascii

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
     * <tt>T</TT> y puede contener <tt>CHARSET<tt> hijos. 
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
        
        // Caracter de la posición en el padre.
        private char c;

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

        // --------------------------------------------------------------------- //
        // CONSTRUCTOR METHOD                                                    //
        // --------------------------------------------------------------------- //
        /**
         * Constructor por defecto de un nodo de Trie. Este constructor existe
         * ya que existen nodos de trie que pueden existir sin necesidad de
         * almacenar elementos puesto que pueden formar solo parte del camino de
         * ubicación de una llave de texto dentro del Trie.
         */
        public Node() {
            this.element = null;
        } // CLASS DEFAULT CONSTRUCTOR ----------------------------------------- //

        // ===================================================================== //
        // PUBLIC METHODS                                                        //
        // ===================================================================== //
        /**
         * Este método implementa un método recursivo para agregar elementos
         * dentro del Trie de manera que se genere un nodo si no existe o se
         * utilice uno ya existente como parte del camino de ubicación del
         * elemento dentro del trie. Si un elemento está repetido, el método
         * sobrescribe el elemento con el nuevo elemento ingresado.
         *
         * @param key - Llave de posición dentro del Trie
         *
         * @param d - posición dentro de la llave de indexación
         *
         * @param element - elemento que será insertado en el trie
         *
         * @return - true si el elemento fue insertado, false si no fue
         * insertado
         */
        protected boolean put(String key, int d, final T element) {
            boolean inserted = false;
            // Primero verificamos si d se encuentra en una posición diferente 
            // al final de la llave de indexación.
            if (d == key.length()) {
                // Si llegamos acá, es porque hemos llegado al final de la llave
                // de indexación y por lo tanto debemos almacenar el elmento en 
                // "este" nodo. 
                this.element = element;
                inserted = true;
            } // IF ENDS
            else {
                // En este caso, aun no ha llegado al nodo que se encuentra en 
                // la posición que corresponde por lo que se debe buscar la 
                // posición del siguiente nodo:
                char position = key.charAt(d);

                // Se verifica la posición del elemento para ver si hay un nodo
                // prexistente
                if (this.next[position] == null) {
                    this.next[position] = new Node<T>();
                    ((Node<T>)this.next[position]).setC(position);
                } // IF ENDS

                // Se insertan los elementos de manera recursiva en la posición
                // que corresponde.
                inserted = ((Node<T>) this.next[position]).put(key, (d + 1), element);
            } // ELSE ENDS 
            return inserted;
        } // METHOD PUT ENDS --------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD CONTAINS                                                       //
        // --------------------------------------------------------------------- //
        /**
         * Permite evaluar si existe un elemento asociado a una llave
         * determinada dentro del Trie
         *
         * @param key La llave de indexación que representa la posición que debe
         * tomar un elemento dentro del Trie
         *
         * @param d Posición dentro de la llave de indexación actual, además, es
         * la condicion de parada de la búsqueda recursiva dentro del Trie.
         *
         * @return true si contiene un elemento asociado a la llave o false si
         * no hay elementos asociados.
         */
        protected boolean contains(String key, int d) {
            boolean exists = false;

            // Primero verificamos si ya se llegó a la posición correspondiente 
            // dentro del Trie. De lo contrario se continúa buscando.
            if (d == key.length()) {
                if (this.element != null) {
                    exists = true;
                } // IF ENDS
            } // IF ENDS
            else {
                char position = key.charAt(d);
                if (this.next[position] != null) {
                    exists = ((Node<T>) this.next[position]).contains(key, d + 1);
                } // IF ENDS
                else {
                    exists = false;
                } // ELSE ENDS
            } // ELSE ENDS
            return exists;
        } // METHOD CONTAINS ENDS ---------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD GET                                                            //
        // --------------------------------------------------------------------- //
        /**
         *
         * @param key - La llave de indexación que representa la posición que
         * debe tomar un elemento dentro del Trie
         *
         * @param d - Posición dentro de la llave de indexación actual, además,
         * es la condicion de parada de la búsqueda recursiva dentro del Trie.
         *
         * @return Referencia del elemento o null si el elemento no existe
         * dentro de Trie.
         */
        protected T get(String key, int d) {
            T e = null;
            // Primero verificamos si ya se llegó a la posición correspondiente 
            // dentro del Trie. De lo contrario se continúa buscando.
            if (d == key.length()) {
                if (this.element != null) {
                    e = this.element;
                } // IF ENDS
            } // IF ENDS
            else {
                char position = key.charAt(d);
                if (this.next[position] != null) {
                    e = ((Node<T>) this.next[position]).get(key, d + 1);
                } // IF ENDS
                else {
                    e = null;
                } // ELSE ENDS
            } // ELSE ENDS
            return e;
        } // METHOD ENDS ------------------------------------------------------- //
        
        // --------------------------------------------------------------------- //
        // METHOD TO STRING                                                      //
        // --------------------------------------------------------------------- //
        /**
         * Sobrescribe la implementación por defecto de toString para generar 
         * una impresión tipo Json que pueda servir para visualizar mejor los 
         * datos dentro del Trie.
         * 
         * @return representación de texto del estado del Trie
         */
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            Object[] printable = Arrays.stream(this.next).filter(x -> x != null).toArray();
            // Por cuestión de rendimiento, se filtran todos los elementos que 
            // no son nulos para reducir iteraciones utilizando un filtro
            // Lambda. 
            sb.append("{");
            sb.append("\""+ this.c +"\":{");
            sb.append("\"element\":\"" + this.element + "\",");
            sb.append("\"childs\":[");
            for(int i = 0; i < printable.length; ++i){
                sb.append(printable[i]);
                if(i != printable.length - 1){
                    sb.append(",");
                } // IF ENDS
            } // FOR ENDS
            sb.append("]");
            sb.append("}");
            sb.append("}");
            return sb.toString();
        } // METHOD TO STRING ENDS --------------------------------------------- //
        
        // --------------------------------------------------------------------- //
        // METHOD LIST                                                           //
        // --------------------------------------------------------------------- //
        /**
         * Este método permite obtener todos los sub-elementos del nodo en una
         * lista. 
         * @param l - referencia a la lista donde serán agregados cada unos de 
         *            los elementos. 
         * @return Lista con los elementos del Trie
         */
        public void list(final List<T> l){
            // Primero se debe verificar si el nodo actual tiene algún elemento, 
            // de ser así, entonces se debe agregar el elementos a la lista
            if(this.element != null){
                l.add(this.element);
            } // IF ENDS 
            // Ahora se deben agregar todos los elementos en los sub-árboles, sin
            // embargo, para optimizar el tiempo de ejecución del Trie, utilizamos
            // una expresión Lamda para filtrar lo elementos del vector de "hijos"
            // para obtener un nuevo vector con únicamente los elementos que son
            // diferentes de nulo. Si el vector de hijos no contiene instancias
            // siguientes, entonces se habrá llegado al final del sub-árbol
            Object[] childs = Arrays.stream(this.next).filter(x -> x != null).toArray();
            // Ahora agregamos los elementos de cada sub-nodo
            for(Object o:childs ){
                // Visitamos los nodos hijos
                ((Node<T>)o).list(l);
            } // FOR ENDS
        } // METHOD LIST ENDS -------------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD GET ELEMENT                                                    //
        // --------------------------------------------------------------------- //
        /**
         * Permite obtener el elemento del nodo
         *
         * @return
         */
        public T getElement() {
            return element;
        } // METHOD GET ELEMENT ENDS ------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD SET ELEMENT                                                    //
        // --------------------------------------------------------------------- //
        /**
         * Permite establecer el elemento del nodo
         *
         * @param element
         */
        public void setElement(T element) {
            this.element = element;
        } // METHOD SET ELEMENT ENDS ------------------------------------------- //

        // --------------------------------------------------------------------- //
        // METHOD GET C                                                          //
        // --------------------------------------------------------------------- //
        public char getC() {
            return c;
        } // METHOD GET C ------------------------------------------------------ //

        // --------------------------------------------------------------------- //
        // METHOD SET C                                                          //
        // --------------------------------------------------------------------- //
        public void setC(char c) {
            this.c = c;
        } // METHOD SET C ------------------------------------------------------ //
        
    } // PRIVATE CLASS NODE ENDS =============================================== //

    // ========================================================================= //
    // CLASS PUBLIC METHODS                                                      //
    // ========================================================================= //
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
        // Hay dos casos, que la raíz esté nula o que contenga un elementos. Si 
        // la raíz es nula, entonces se crea el elemento raíz y se inserta, de 
        // lo contrario se inserta a partir del nodo raíz.
        if (this.root == null) {
            this.root = new Node<T>();
            this.root.setC(C_DEFAULT);
        } // IF ENDS
        if (this.root.put(key, START_POSITION, element)) {
            this.size++;
        } // IF ENDS
        return this;
    } // METHOD PUT ENDS ------------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD GET                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener una referencia al elemento asociado a una llave de texto
     * dentro del Trie. Si no hay elemento asociado entonces devuelve null.
     * 
     * @param key - Llave asociada al elemento
     * 
     * @return Referencia al elemento o null si el elemento no existe en el Trie.
     */
    @Override
    public T get(String key) {
        T e = null;
        if (this.root != null) {
            e = this.root.get(key, START_POSITION);
        } // IF ENDS
        return e;
    } // METHOD GET ENDS ------------------------------------------------------- //

    /**
     * 
     * @param key
     * @return 
     */
    @Override
    public boolean contains(String key) {
        boolean exists = false;
         if (this.root != null) {
            exists = this.root.contains(key, START_POSITION);
        } // IF ENDS
        return exists;
    } // METHOD CONTAINS ENDS -------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD SIZE                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Devuelve la cantidad de elementos que se encuentran dentro del Trie
     *
     * @return - Cantidad de elementos que se encuentran en el Trie;
     */
    @Override
    public int size() {
        return this.size;
    } // METHOD SIZE ENDS ------------------------------------------------------ //

    // ------------------------------------------------------------------------- //
    // METHOD IS EMPTY                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite determinar si el Trie se encuentra vacío o si contiene elementos.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0 && this.root == null);
    } // METHOD IS EMPY ENDS --------------------------------------------------- //

    /**
     * Permite eliminar elementos del Trie en caso de que estos existan dentro
     * del trie;
     *
     * @param key - Llave asociada al elemento que se desea eliminar;
     * @return referencia hacia el mismo Trie para permitit encadenamiento de
     * métodos sobre una misma instancia de Trie.
     */
    @Override
    public Trie<T> delete(String key) {
        this.put(key, null);
        return this;
    } // METHOD DELETE ENDS ---------------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD LIST                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener una lista con todos los elementos del Trie
     * @param c instancia de comparaddor de elementos
     * @return 
     */
    @Override
    public synchronized List<T> list(Comparator<T> c){
        List<T> elements = new ConcurrentLinkedList<T>(c);
        if(this.root != null){
            this.root.list(elements);
        } // IF ENDS
        return elements;
    } // METHOD LIST ENDS ------------------------------------------------------ //
    
    // ------------------------------------------------------------------------- //
    // METHOD TO STRING                                                          //
    // ------------------------------------------------------------------------- //
    /**
     * Genera una representación de estado actual del Trie utilizando cadenas de
     * caracteres
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.root != null){
            sb.append(this.root);
        } // IF ENDS
        return sb.toString();
    } // METHOD TO STRING ENDS ------------------------------------------------- //

} // CLASS EXTENDED ASCII TRIE ENDS -------------------------------------------- //
