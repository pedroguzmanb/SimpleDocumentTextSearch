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

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public interface Queue<E> {
    
    /**
     * Coloca un elemento al final de la cola
     * @param element 
     */
    void queue(E element);
    
    /**
     * Saca el elemento que se encuentra en la primera posición de la cola
     * @return 
     */
    E dequeue();
    
    
} // INTERFACE QUEUE ENDS ------------------------------------------------------ //
