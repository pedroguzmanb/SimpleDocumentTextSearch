/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulacit.dictionaryservice;

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

    public void setDictionary(List<String> dictionary) {
        this.dictionary = dictionary;
    }
    
    
    
}
