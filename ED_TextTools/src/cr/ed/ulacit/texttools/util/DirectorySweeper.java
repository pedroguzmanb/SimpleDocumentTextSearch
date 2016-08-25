/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.texttools.util;

// ============================================================================= //
import cr.ed.ulacit.dstructures.List;
import cr.ed.ulacit.dstructures.impl.ConcurrentLinkedList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

// CLASS DIRECTORY SWEEPER                                                       //
// ============================================================================= //
/**
 * Esta clase representa una objeto que se encarga de buscar todos los archivos
 * de texto indexable en un directorio y los carga en el sistema hacia la cola
 * de procesamiento de indexación para que éstos puedan ser procesados.
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class DirectorySweeper {

    // TODO - Implementar leer todos los archivos de texto de un directorio y 
    // luego enviarlos a la cola de procesamiento
    public static synchronized List<Path> sweep(String directory) {
        List<Path> files = new ConcurrentLinkedList<Path>(new PathComparator());
        try {
            Files.walk(Paths.get(directory)).forEach(fileFound -> {
                if (Files.isRegularFile(fileFound) && ( getExtension(
                        fileFound.toString()
                ) // if ends
                        .hashCode() == "txt".hashCode())){
                   files.add(fileFound);
                } // IF ENDS
            }); // FILES ENDS
        } catch (IOException ex) {
            Logger.getLogger(DirectorySweeper.class.getName()).log(Level.SEVERE, null, ex);
        } // catch ends
        return files;
    } // METHOD SWEEP DIRECTORY ENDS  ------------------------------------------ //

    // ------------------------------------------------------------------------- //
    // METHOD GET EXTENSION                                                      //
    // ------------------------------------------------------------------------- //
    /**
     * Este método permite obtener la extensión de un archivo en una ubicación
     * dada
     * @param file path del archivo
     * @return la extensión del archivo
     */
    private static String getExtension(String file) {
        String extension = "";
        int i = file.lastIndexOf('.');
        if (i > 0) {
            extension = file.substring(i + 1);
        } // IF ENDS 
        return extension;
    } // METHOD GET EXTENSION ENDS --------------------------------------------- //

} // PUBLIC CLASS DIRECTORY SWEEPER ENDS --------------------------------------- //
