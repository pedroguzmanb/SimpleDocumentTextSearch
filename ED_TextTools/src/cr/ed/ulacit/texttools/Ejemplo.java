/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class Ejemplo {

    

        public String eliminatePunctuation(String text) {
            text = text.toLowerCase().replaceAll("[^a-z0-9\\s']", "");

            return text;
        }

    
} // EJEMPLO ENDS --------------------------------------------------------------
