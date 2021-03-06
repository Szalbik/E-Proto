package com.resource.proto;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost").port(8080).build();
        ResourceConfig config = new ResourceConfig()
                .packages("com.resource.proto")
                .packages("org.glassfish.jersey.examples.linking")
                .register(DeclarativeLinkingFeature.class)
                .register(RestError.class)
                .register(new DateParamConverterProvider("yyyy-MM-dd"));

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

        try {
            server.start();
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}