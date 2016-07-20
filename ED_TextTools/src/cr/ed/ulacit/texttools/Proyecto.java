/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools;

/**
 *
 * @author ADMIN
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Ejemplo ej=new Ejemplo();   
         
    String texto ="Make sure you start with stories at your level, and go gradually up. \n" +
" Do not start with difficult stories that you can't really understand, OK?";
   
    System.out.println(ej.eliminatePunctuation(texto));
    }
    
}
