/*
 * Copyright (C) 2016 Pedro Guzmán & Salgua Salha (ULACIT)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ulacit.dictionaryservice;

// Importamos la lista doblemente enlazada que implementamos en el paquete de 

import java.util.ArrayList;
import java.util.List;

// estructuras


// ============================================================================= //
// TEXT TO LIST CONVERTER                                                        //
// ============================================================================= //
/**
 * Esta clase representa un convertor de texto a lista. Lo provee son métodos
 * que permiten convertir un String a una lista de palabras por medio de un
 * proceso de eliminación de puntuación y caracteres especiales. La idea es que
 * sólo quede una lista en la cual cada elemento es una palabra del texto.
 *
 * @author Salgua Salha (ssalhaa954@ulacit.ed.cr)
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class TextToListConverter {

    // ------------------------------------------------------------------------- //
    // METHOD TO LIST                                                            //
    // ------------------------------------------------------------------------- //
    /**
     * Este método recibe un string que contiene todo un texto con puntuación y
     * lo transforma en una lista de palabras sin puntuación. Cada elemento de
     * la lista es una palabra del texto. La conversión utiliza expresiones
     * regulares para eliminar la puntuación.
     *
     * @param text
     * @return
     */
    public List<String> toList(String text) {

        // Primero ocupamos declarar una lista vacía donde vamos a agregar las 
        // palabras una vez que hemos eliminado la puntuación y utilizado el 
        // método split() de la clase String para dividir el texto en un vector
        // o arreglo de palabras.
        List<String> words = new ArrayList<String>();
        
        

        // RECOMENDACIONES: Antes de insertar los elementos en la lista, se debe
        //                  convertir todo el text a mayúscula para que no exista
        //                  diferencia entre un texto en minúscula y otro en 
        //                  mayúscula. Lo que nos interesa es el significado de
        //                  las palabras. 
        // (TO DO SALGUA) -- Aquí se debe implementar la lógica de éste método
        //Primero converti el texto en mayuscula y elimine todo los carcteres 
        //como puntos,comas....ect 
        //segundo se creo un ciclo para ir agregando las palabras divididas en una
        //lista
        text = text.replaceAll("[^a-zA-Z0-9\\s']", "").toUpperCase();
        // DEBUG --- 
        //System.out.println();
        String[] wordsText = text.split("\\s*(=>|,|\\s)\\s*");
        for (String wordText : wordsText) {
            words.add(wordText);
        } // FOR ENDS
        // Al final, en la lista words deben estar todas las palabras que 
        // componen el texto sin puntuación.
        return words;
    } // METHOD TO LIST ENDS --------------------------------------------------- //

    
   
} // METHOD TEXT TO LIST CONVERTER --------------------------------------------- //
