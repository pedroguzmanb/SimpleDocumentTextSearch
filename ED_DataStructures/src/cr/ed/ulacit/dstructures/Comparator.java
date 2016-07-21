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
// INTERFACE COMPARATOR                                                          //
// ----------------------------------------------------------------------------- //
/**
 * Define una interfaz genérica de comparación entre objetos. Las clases que 
 * implementan esta interfaz pueden ser comparadas entre sí para determinar una
 * noción de órden dentro de las estructuras de datos. 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 * @param <T> Tipo de dato que implementa el comparador o T si es genérico
 */
public interface Comparator<T> {
    // ------------------------------------------------------------------------- //
    // METHOD COMPARE                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Permite comparar dos instnacias de tipo T (dinámico). Si el resultado es 0, 
     * entonces ambas instancias son iguales. Si el resultado es mayor que cero
     * entonces <tt>a es mayor que b</tt> de lo contrario <tt>b es mayor que a</tt>
     * @param a primer elemento que será comparado
     * @param b segundo elemento que será comparado
     * @return 
     */
    int compare(T a, T b);
} // INTERFACE COMPARATOR ENDS ------------------------------------------------- //
