package com.bitcurry.holygradle.api;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/v1/")
public class HolyGradleApplication extends ResourceConfig {
    public HolyGradleApplication() {
        registerClasses(LanguageResource.class);
    }
}
