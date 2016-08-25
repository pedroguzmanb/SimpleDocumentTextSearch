/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

import cr.ed.ulacit.texttools.TextToListConverter;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class StopWordDictionary {
    
    private List<String> stopWords;

    public StopWordDictionary() {
        this.stopWords = new ArrayList<String>();
    }
    
    // ------------------------------------------------------------------------- //
    // METHOD LOAD                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Method load ends
     * @param stopWords 
     */
    public void load(String stopWords){
        TextToListConverter converter = new TextToListConverter();
        cr.ed.ulacit.dstructures.List list = converter.toList(stopWords);
    } // METHOD LOAD ENDS ------------------------------------------------------ //
    
    
    
}
