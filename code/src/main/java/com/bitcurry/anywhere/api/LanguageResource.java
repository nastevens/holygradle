package com.bitcurry.anywhere.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

@Path("/languages")
public class LanguageResource {

    private static LanguageBean[] languageBeans = new LanguageBean[] {
            new LanguageBean("Java"),
            new LanguageBean("Groovy"),
            new LanguageBean("Javascript"),
            new LanguageBean("CoffeeScript"),
            new LanguageBean("CSS"),
            new LanguageBean("HTML")
    };

    @GET
    @Produces("application/json")
    public LanguageBean[] getLanguages() {
        return languageBeans;
    }

}
