//

/*
 * =============================================================================
 *  APACHE 2.0 LICENSE
 * =============================================================================
 * Copyright (c) 2016 CICC-ULACIT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ulacit.ocheckers.connect;

// ----------------------------------------------------------------------------- //
// CLASS IMPORTS                                                                 //
// ----------------------------------------------------------------------------- //
import com.google.gson.Gson;
import cr.ed.ulacit.search.gui.external.Dictionary;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// ----------------------------------------------------------------------------- //
// CLASS HTTP SIMPLE REST CLIENT                                                 //
// ----------------------------------------------------------------------------- //
/**
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
public class HttpSimpleRestClient {

    // ------------------------------------------------------------------------- //
    // BASE URL                                                                  //
    // ------------------------------------------------------------------------- //
    /**
     * MUY importante cambiar el puerto del servidor a 8080 en máquinas donde
     * glassfish corre con el puerto por defecto
     */
    private final String baseURL = "http://localhost:2999/ED_DictionaryServiceREST/api/Dictionary";

    // ------------------------------------------------------------------------- //
    // METHOD POST                                                               //
    // ------------------------------------------------------------------------- //
    /**
     * Envía datos a un API
     *
     * @param jsonToSend
     * @param resource
     * @return
     */
    public String post(final String jsonToSend, final String resource) {
        String url = baseURL + resource;
        System.out.println(url);
        try {
            URL targetUrl = new URL(url);

            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(jsonToSend.getBytes());
            outputStream.flush();
            if (httpConnection.getResponseCode() != 200 && httpConnection.getResponseCode() != 204) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());
            } // IF ENDS
            if (httpConnection.getResponseCode() != 204) {
                BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
                String output;
                System.out.println("Output from Server:\n");
                while ((output = responseBuffer.readLine()) != null) {
                    System.out.println(output);
                } // WHILE ENDS
                httpConnection.disconnect();
            } // IF ENDS

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return "";
    } // METHOD POST ENDS ------------------------------------------------------ //

    // ------------------------------------------------------------------------- //
    // METHOD GET                                                                //
    // ------------------------------------------------------------------------- //
    /**
     *
     * @param resourceUrl
     * @return
     */
    public Dictionary get() {
        InputStreamReader resource = null;
        try {
            String url = baseURL;
            resource = new InputStreamReader(new URL(url).openStream());
            BufferedReader readResourceResponse = new BufferedReader(resource);
            String line;
            StringBuilder stringResult = new StringBuilder();
            while ((line = readResourceResponse.readLine()) != null) {
                stringResult.append(line);
            }
            return new Gson().fromJson(stringResult.toString(), Dictionary.class);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                resource.close();
            } catch (IOException ex) {
                System.out.println(ex);
            } // CATCH ENDS 
        } // FINALLY ENDS
        return null;
    } // METHOD GET ENDS ------------------------------------------------------- //

} // CLASS HTTP SIMPLE REST CLIENT ENDS ---------------------------------------- //