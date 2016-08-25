/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulacit.dictionaryservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

// ============================================================================= //
// CLASS TEXT FILE READER                                                        //
// ============================================================================= //
/**
 * Esta clase provee métodos para leer archivos de texto desde disco
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class TextFileReader {

    // ------------------------------------------------------------------------- //
    // METHOD READ FILE                                                          //
    // ------------------------------------------------------------------------- //
    /**
     * Este método recibe la ubicación de un archivo de texto y permite leer su
     * contenido y almacenarlo dentro de una cadena de caracteres.
     *
     * @param path - ubicación del archivo.
     *
     * @return El contenido del archivo dentro de un String
     */
    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        // Creamos una referencia al archivo en disco que queremos leer
        Path p = Paths.get(path);
        // Abrimos un lector de archivos que permite leer el archivo que se
        // encuentra en el disco
        try (BufferedReader reader = Files.newBufferedReader(p)) {
            String line = "";
            // Guardamos cada lína del archivo en el StringBuilder
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            } // WHILE ENDS
        } catch (IOException ex) {
            Logger.getLogger(TextFileReader.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("OCURRIÓ UN ERROR AL LEER EL ARCHIVO: " + path);
        } // TRY ENDS
        return sb.toString();
    } // METHOD READ FILE ENDS ------------------------------------------------- //

    /**
     * 
     * @param path
     * @return 
     */
    public static String readAnyFile(String path) {
        FileInputStream input;
        String result = null;
        try {
            input = new FileInputStream(new File(path));
            CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
            decoder.onMalformedInput(CodingErrorAction.IGNORE);
            InputStreamReader reader = new InputStreamReader(input, decoder);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            result = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

} // CLASS TXT FILE READER ENDS ------------------------------------------------ //

