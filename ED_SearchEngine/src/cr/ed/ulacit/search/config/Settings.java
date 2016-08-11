/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ed.ulacit.search.config;

// ============================================================================= //
// CLASS IMPORTS                                                                 //
// ============================================================================= //
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// ============================================================================= //
// CLASS SETTINGS                                                                //
// ============================================================================= //
/**
 * Esta clase es una abstración de las configuraciones globales del programa
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class Settings {

    private static Settings settings;

    // Objeto que abstrae el acceso a las propiedades del sistema
    private Properties props;

    // ------------------------------------------------------------------------- //
    // CONSTRUCTOR DE LA CLASE                                                   //
    // ------------------------------------------------------------------------- //
    /**
     * Se implementa un constructor privado con el objetivo de implementar las
     * configuraciones como un singleton y consecuentemente pasar todas las
     * propiedades dentro de un patrón de flyweight
     */
    private Settings() {
        File configFile = new File("config.properties");
        if (configFile.exists()) {
            try {
                FileReader reader = new FileReader(configFile);
                
                // Se crea una nueva instancia de properties
                this.props = new Properties();
                
                // Se cargan las propiedades y configuraciones desde el arhivo 
                // de configuración del sistema. 
                props.load(reader);
                
                reader.close();
            } catch (FileNotFoundException ex) {
                // TODO - Manejo adecuado de excepciones
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } // CATCH ENDS 
        } // IF ENDS
    } // CONSTRUCTOR DE LA CLASE. ---------------------------------------------- //
    
    // ------------------------------------------------------------------------- //
    // METHOD GET INSTANCE                                                       //
    // ------------------------------------------------------------------------- //
    /**
     * Permite obtener una referencia a la clase que provee acceso a las
     * configuraciones
     * @return 
     */
    public static synchronized Settings getInstance(){
        if(settings == null){
            settings = new Settings();
        } // IF ENDS
        return settings;
    } // METHOD GET INSTANCE ENDS ---------------------------------------------- //
    
    // TODO IMPLEMENTAR PODER ACTUALIZAR PROPIEDADES EN RUNTIME
    /*
    File configFile = new File("config.properties");
 
    try {
        Properties props = new Properties();
        props.setProperty("host", "www.codejava.net");
        FileWriter writer = new FileWriter(configFile);
        props.store(writer, "host settings");
        writer.close();
    } catch (FileNotFoundException ex) {
        // file does not exist
    } catch (IOException ex) {
        // I/O error
    }
    */

} // CLASS SETTINGS ENDS ------------------------------------------------------- //
