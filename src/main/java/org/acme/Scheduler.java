package org.acme;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class Scheduler {

    @RestClient
    ReactiveClient client;

    @Inject
    PotatoConfig config;

    @Scheduled(every = "5s", delayed = "5s")
    void scheduledMethod() throws InterruptedException, ExecutionException {
        List<Entity> resp = client.testApi().await().indefinitely();

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        forkJoinPool.submit(() -> {
            resp.stream().forEach(uuid -> {
                System.out.println(uuid.toString());
            });
        }).get();
    }
}
