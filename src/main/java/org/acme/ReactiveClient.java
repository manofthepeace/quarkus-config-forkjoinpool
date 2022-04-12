package org.acme;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

@RegisterRestClient(configKey = "api")
public interface ReactiveClient {

    @GET
    @Path("/hello")
    public Uni<List<Entity>> testApi();

}
