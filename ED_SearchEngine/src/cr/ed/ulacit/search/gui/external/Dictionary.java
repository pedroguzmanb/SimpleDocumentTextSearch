/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.search.gui.external;

import cr.ed.ulacit.dstructures.impl.ConcurrentLinkedList;
import cr.ed.ulacit.texttools.util.TextComparator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class Dictionary {
    
    private List<String> dictionary = new ArrayList<String>();
    
    public void load(List<String> dic){
        this.dictionary.addAll(dic);
    }

    public List<String> getDictionary() {
        return dictionary;
    }
    
    // ------------------------------------------------------------------------- //
    // METHOD EXPORT                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * 
     * @return 
     */
    public cr.ed.ulacit.dstructures.List<String> export(){
        cr.ed.ulacit.dstructures.List<String> list = new ConcurrentLinkedList<String>(new TextComparator());
        this.dictionary.stream().forEach((item) -> {
            list.add(item);
        });
        return list;
    }

    public void setDictionary(List<String> dictionary) {
        this.dictionary = dictionary;
    }
    
    
    
}
