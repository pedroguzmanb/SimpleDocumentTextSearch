/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools.util;

import cr.ed.ulacit.dstructures.Comparator;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class DoubleComparator implements Comparator<Double> {

    @Override
    public int compare(Double a, Double b) {
        return a.compareTo(b);
    }
    
}
