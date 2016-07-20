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
    // METHOD COUNT                                                              //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener la cantidad de elementos de la lista  
     * @return 
     */
    int count();
    
    // ------------------------------------------------------------------------- //
    // METHOD ADD                                                                //
    // ------------------------------------------------------------------------- //
    /**
     * 
     * @param element
     * @return 
     */
    List<E> add(E element);
    
} // CLASS LIST ENDS ----------------------------------------------------------- //
