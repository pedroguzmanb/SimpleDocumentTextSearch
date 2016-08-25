/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.Trie;
import cr.ed.ulacit.texttools.TextPurifier;
import cr.ed.ulacit.texttools.TextToListConverter;

// ----------------------------------------------------------------------------- //
// CLASS DOCUMENT                                                                //
// ----------------------------------------------------------------------------- //
/**
 * Representa un documento dentro del índice
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class Document {

    private Trie<WordFrequency> vector;
    private double relativeScoreToQuery;
    private String docPath;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Crea instancias de documento y los indexa
     * @param text
     * @param purifier 
     */
    public Document(String text, TextPurifier purifier) {
        TextToListConverter converter = new TextToListConverter();
        this.vector = purifier
                .extractSemanticVocabulary(converter
                        .toList(text)
                );
    } // CONSTRUCTOR ENDS ------------------------------------------------------ //
    
    // ------------------------------------------------------------------------- //
    // METHOD VECTOR                                                             //
    // ------------------------------------------------------------------------- //
    /**
     * 
     * @return 
     */
    public Trie<WordFrequency> vector(){
        return this.vector;
    } // METHOD VECTOR ENDS ---------------------------------------------------- //

    public double getRelativeScoreToQuery() {
        return relativeScoreToQuery;
    }

    public void setRelativeScoreToQuery(double relativeScoreToQuery) {
        this.relativeScoreToQuery = relativeScoreToQuery;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }
    
    
    
    

} // CLASS DOCUMENT ENDS ------------------------------------------------------- //
