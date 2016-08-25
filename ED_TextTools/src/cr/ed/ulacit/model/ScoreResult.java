/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.model;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class ScoreResult {
    
    private Document doc;
    private double score;

    public ScoreResult(Document doc, double score) {
        this.doc = doc;
        this.score = score;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" SCORE: " + this.score + " \t" + " DOC: " + this.doc.getDocPath());
        return sb.toString();
    }
    
}
