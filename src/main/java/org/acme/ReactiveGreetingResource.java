package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;

@Path("/")
public class ReactiveGreetingResource {
    @Inject
    Logger log;

    @GET
    @Path("/hello")
    public List<Entity> hello() {
        List<Entity> entities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            entities.add(new Entity(UUID.randomUUID().toString()));
        }
        return entities;
    }
}