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
package cr.ed.ulacit.dstructures;

// ----------------------------------------------------------------------------- //
// LIST INTERFACE                                                                //
// ----------------------------------------------------------------------------- //
/**
 * Esta definición de interfaz se utiliza para proveer soporte para mútiples 
 * implementaciones de listas por medio de polimorfismo, pero conservando una
 * interfaz común que permita interactuar con todas las implementaciones de lista
 * de la misma manera. Esta lista es una lista genérica por lo que recibe un 
 * parámetro de tipo para 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <E> Recibe
 */
public interface List<E>{
    
    // ------------------------------------------------------------------------- //
    // METHOD SIZE                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener la cantidad de elementos de la lista  
     * @return 
     */
    int size();
    
    // ------------------------------------------------------------------------- //
    // METHOD ADD                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Agrega un elemento al final de la lista
     * @param element
     * @return 
     */
    boolean add(E element);
    
    // ------------------------------------------------------------------------- //
    // METHOD ADD                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Elimina todos los elementos de la lista
     */
    void clear();
    
    // ------------------------------------------------------------------------- //
    // METHOD ADD                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Verifica si el elemento indicado se encuentra dentro de la lista y retorna
     * true si se encuentra o false si no se encuentra en la lista
     * @param element
     * @return 
     */
    boolean contains(E element);
    
    // ------------------------------------------------------------------------- //
    // METHOD GET                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener un elemento en una posición específica de la lista.
     * @param index
     * @return 
     */
    E get(int index);
    
    // ------------------------------------------------------------------------- //
    // METHOD IS EMPTY                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Devuelve true si la lista se encuentra vacía o false si contiene elementos
     * @return 
     */
    boolean isEmpty();
    
    // ------------------------------------------------------------------------- //
    // METHOD ITERATOR                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener un iterador para la lista
     * @return 
     */
    Iterator<E> iterator();
    
    // ------------------------------------------------------------------------- //
    // METHOD REMOVE                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Permite eliminar un elemento de la lista en una posición dada
     * @param index La posición del elemento que se requiere eliminar
     * @return true si el elemento fue eliminado o false si el elemento no existe
     */
    boolean remove(int index);
    
} // CLASS LIST ENDS ----------------------------------------------------------- //
