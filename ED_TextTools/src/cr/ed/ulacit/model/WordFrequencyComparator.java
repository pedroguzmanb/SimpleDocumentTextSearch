/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

import cr.ed.ulacit.dstructures.Comparator;

// ----------------------------------------------------------------------------- //
// CLASS WORD FREQUENCY COMPARATOR                                               //
// ----------------------------------------------------------------------------- //
/**
 * Permite realizar comparaciones entre dos WordFrequency distitnos
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class WordFrequencyComparator implements Comparator<WordFrequency>{

    // ------------------------------------------------------------------------- //
    // METHOD COMPARE                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * 0 si ambos son iguales, 1 si a > b y -1 si b > a
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int compare(WordFrequency a, WordFrequency b) {
        return a.getWord().compareTo(b.getWord());
    } // METHOD COMPARE ENDS --------------------------------------------------- //
    
} // METHOD WORD FREQUENCY COMPARATOR ------------------------------------------ //
