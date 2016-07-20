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
// INTERFACE ITERATOR                                                            //
// ----------------------------------------------------------------------------- //
/**
 * Define un iterador genérico que permite iterar sobre estructuras iterables
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <E>
 */
public interface Iterator<E> {
    boolean hasNext();
    
    // ------------------------------------------------------------------------- //
    // METHOD NEXT                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Obtiene el siguiente elemento de una estructura iterable. O null si no hay 
     * ningún elemento siguiente;
     * @return 
     */
    E next();
    
    // ------------------------------------------------------------------------- //
    // METHOD REMOVE                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * Elimina el último elemento retornado por este iterador. Solo puede ser
     * llamado una vez por cada llamada a next() ya que solo se guarda una única
     * referencia al elemento anterior.
     */
    void remove();
} // INTERFAZ ITERATOR --------------------------------------------------------- //
