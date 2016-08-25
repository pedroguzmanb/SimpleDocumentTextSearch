/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools.util;

// ============================================================================= //
// CLASS IMPORTS                                                                 //
// ============================================================================= //


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

// ============================================================================= //
// CLASS TEXT FILE WRITER                                                        //
// ============================================================================= //
/**
 * Esta clase provee herramientas que permiten escribit archivos en disco 
 * de manera que éstos sean persistentes. 
 * 
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class TextFileWriter {
    
    public static boolean persist(String content, String path){
        boolean persisted = false;
        // Se utiliza un try clause para que cierre el stream de escritura
        // de manera automática
        try (PrintWriter out = new PrintWriter(path)) {
            out.println(content);
            persisted = true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            persisted = false;
        } // CATCH ENDS
        return persisted;
    } // METHOD PERSIST ENDS --------------------------------------------------- //
    
} // METHOD TEXT FILE WRITER ENDS
