// ----------------------------------------------------------------------------- //
// CLASS                                                                         //
// ----------------------------------------------------------------------------- //
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
package cr.ed.ulacit.model;

// ----------------------------------------------------------------------------- //
// METHOD WORD FREQUENCY                                                         //
// ----------------------------------------------------------------------------- //
/**
 * Esta clase representa una palabra asociada a su frecuencia dentro del texto. 
 * Esto es importante ya que con base en la frecuencia de una palabra dentro del
 * texto, se puede calcular 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class WordFrequency {
    
    // ------------------------------------------------------------------------- //
    // CLASS ATTRIBUTES                                                          //
    // ------------------------------------------------------------------------- //
    
    private final String word;
    private int frequency;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR METHOD                                                        //
    // ------------------------------------------------------------------------- //
    /**
     * Permite crear instancias de Word Frequency la cual es una clase que 
     * representa la frecuencia de una palabra dentro de un texto
     * @param word 
     */
    public WordFrequency(final String word) {
        this.word = word;
        this.frequency = 1;
    } // METHOD WORD FREQUENCY ------------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD INCREMENT                                                          //
    // ------------------------------------------------------------------------- //
    /**
     * Permite incrementar la frecuencia de una palabra en 1 dentro de un texto
     */
    public synchronized void inc(){
        this.frequency++;
    } // METHOD INCREMENT ENDS ------------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD GET FREQUENCY                                                      //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener la frecuencia de la palabra
     * @return 
     */
    public int getFrequency() {
        return frequency;
    } // METHOD GET FREQUENCY ENDS --------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD SET FREQUENCY                                                      //
    // ------------------------------------------------------------------------- //
    /**
     * Permite establecer la frecuencia de la palabra asociada
     * @param frequency 
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    } // METHOD SET FREQUENCY END ---------------------------------------------- //

    // ------------------------------------------------------------------------- //
    // METHOD GET WORD                                                           //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener la palabra a la cual se encuentra asociada la frecuencia 
     * que esta clase almacena.
     * @return 
     */
    public String getWord() {
        return word;
    } // METHOD GET WORD ENDS -------------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD TO STRING                                                          //
    // ------------------------------------------------------------------------- //
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "{\"word\":\""+this.word+"\",\"frequency\":"+this.frequency+"}";
    } // METHOD TO STRING ENDS ------------------------------------------------- //
    
} // CLASS WORD FREQUENCY ENDS ------------------------------------------------- //
