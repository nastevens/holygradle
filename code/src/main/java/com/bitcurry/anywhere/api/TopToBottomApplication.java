package com.bitcurry.anywhere.api;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/v1/")
public class TopToBottomApplication extends ResourceConfig {
    public TopToBottomApplication() {
        registerClasses(LanguageResource.class);
    }
}
