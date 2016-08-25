/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

// ----------------------------------------------------------------------------- //
// CLASS IMPORTS                                                                 //
// ----------------------------------------------------------------------------- //

import cr.ed.ulacit.dstructures.Iterator;
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.Trie;
import cr.ed.ulacit.dstructures.impl.ConcurrentLinkedList;
import cr.ed.ulacit.texttools.TextPurifier;
import cr.ed.ulacit.texttools.TextToListConverter;
import cr.ed.ulacit.texttools.util.DoubleComparator;

// ----------------------------------------------------------------------------- //
// CLASS QUERY                                                                   //
// ----------------------------------------------------------------------------- //
/**
 * Representa una consulta
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class Query {
    
    private Trie<WordFrequency> vector;
    private List<WordFrequency> query;
    private List<Double> normalizedScores;
    
    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * 
     * @param query 
     */
    public Query(String query, TextPurifier purifier){
        TextToListConverter converter = new TextToListConverter();
        this.vector = purifier
                .extractSemanticVocabulary(converter
                        .toList(query)
                );
        this.query = this.vector.list(new WordFrequencyComparator());
        this.normalizedScores = new ConcurrentLinkedList(new DoubleComparator());
    } // CONSTRUCTOR METHOD ENDS ----------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD COMPUTE COSINE DISTANCE                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Permite calcular la distancia de coseno entre una consulta y un documento
     * @param doc
     * @return 
     */
    public double computeCosineDistance(final Document doc, final int nDocs){
        List<Double> scoreVector = new ConcurrentLinkedList(new DoubleComparator());
        Iterator<WordFrequency> queryIter = this.query.iterator();
        while(queryIter.hasNext()){
            WordFrequency qTF = queryIter.next();
            System.out.println("Term(doc): " + qTF.getWord() + " with freq: " + qTF.getFrequency() +  " at: " + doc.getDocPath());
            if(doc.vector().contains(qTF.getWord()) && doc.vector().get(qTF.getWord()).getFrequency() > 1){
                double idf = Math.log(nDocs) / Math.log(doc.vector().get(qTF.getWord()).getFrequency());
                double tfIdfTD =  doc.vector().get(qTF.getWord()).getFrequency() * idf;
                scoreVector.add(tfIdfTD);
            } // ELSE
            else{
                // En este caso, el término no existe en el documento y por lo 
                // tanto tiene una frecuencia de cero 0
                if(qTF.getFrequency() / (double)nDocs > 0.0){
                    scoreVector.add(qTF.getFrequency()/(double)nDocs);
                }
                else{
                    scoreVector.add(0.0);
                }
                
            } // ELSE
        } // WHILE ENDS
        System.out.println("Result vector" + scoreVector);
        Iterator<Double> scoresIter = scoreVector.iterator();
        double documentScore = 0.0;
        // Calculamos la sumatoria de la distribución ponderada de los términos
        // con respecto al total de documentos encontrados.
        while(scoresIter.hasNext()){
            documentScore+= scoresIter.next();
        } // WHILE ENDS
        doc.setRelativeScoreToQuery(documentScore);
        return documentScore;
    } // METHOD COMPUTE COSINE DISTANCE ENDS ----------------------------------- //

    public Trie<WordFrequency> getVector() {
        return vector;
    }

    public List<WordFrequency> getQuery() {
        return query;
    }

    public List<Double> getNormalizedScores() {
        return normalizedScores;
    }
    
    
    
} // CLASS QUERY ENDS ---------------------------------------------------------- //
