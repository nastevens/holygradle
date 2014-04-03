package com.bitcurry.holygradle.api;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class LanguageResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(LanguageResource.class);
    }

    @Test
    public void testGet() {
        String response = target("languages").request().get(String.class);
        System.out.println(response);
    }

}