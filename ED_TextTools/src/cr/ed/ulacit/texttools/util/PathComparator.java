/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools.util;

import cr.ed.ulacit.dstructures.Comparator;
import java.nio.file.Path;

// ----------------------------------------------------------------------------- //
// CLASS PATH COMPARATOR                                                         //
// ----------------------------------------------------------------------------- //
/**
 * Representa un comparador de instancias de PATH
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class PathComparator implements Comparator<Path> {

    // ------------------------------------------------------------------------- //
    // METHOD COMPARE                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Compara una Path con otro
     * @param a
     * @param b
     * @return 
     */
    @Override
    public int compare(Path a, Path b) {
        return a.compareTo(b);
    } // METHOD COMPARE ENDS --------------------------------------------------- //
    
} // CLASS PATH COMPARATOR ENDS ------------------------------------------------ //
