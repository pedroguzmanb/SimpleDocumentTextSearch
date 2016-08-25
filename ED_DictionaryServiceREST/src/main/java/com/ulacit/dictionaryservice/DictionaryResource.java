/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulacit.dictionaryservice;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Pedro Guzmán (pguzmanb498@ulacit.ed.cr)
 */
@Path("Dictionary")
public class DictionaryResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DictionaryResource
     */
    public DictionaryResource() {
    }

    /**
     * Retrieves representation of an instance of com.ulacit.dictionaryservice.DictionaryResource
     * @return an instance of com.ulacit.dictionaryservice.Dictionary
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        Dictionary d = new Dictionary();
        d.load(DictionaryLoader.load());
        return new Gson().toJson(d);
    }

 
}
