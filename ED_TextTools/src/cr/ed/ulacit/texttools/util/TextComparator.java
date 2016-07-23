/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools.util;

import cr.ed.ulacit.dstructures.Comparator;

// ----------------------------------------------------------------------------- //
// CLASS TEXT COMPARATOR                                                         //
// ----------------------------------------------------------------------------- //
/**
 * Esta clase implementa la funcionalidad para realizar comparaciones entre dos
 * cadenas de caracteres. 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class TextComparator implements Comparator<String>{

    // ------------------------------------------------------------------------- //
    // METHOD COMPARE                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Permite comparar dos elementos de texto. Devuelve 1 si a es mayor que b,
     * 0 si ambos son iguales o -1 si a es menor que b.
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    } // METHOD COMPARE ENDS --------------------------------------------------- //
    
} // CLASS TEXT COMPARATOR ENDS ------------------------------------------------ //
