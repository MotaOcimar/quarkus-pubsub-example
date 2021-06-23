package org.acme;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class SubscriberOneResource {
    
    // Rota para do Dapr pegar suas inscrições
    // TODO: Avisar que estou usando Jackson (https://quarkus.io/guides/rest-json#creating-the-maven-project)
    @GET
    @Path("dapr/subscribe")
    public Set<Subscription> subscribe() {
        Subscription aSubscription = new Subscription("pubsub", "A", "A");
        Subscription bSubscription = new Subscription("pubsub", "B", "B");
        return Set.of(aSubscription, bSubscription);
    }

    // Rota para o Dapr entregar as mensagens do tópico A
    @POST
    @Path("A")
    public Response aRoute(DaprJson json) {
        System.out.println("A: " + json.data);
        return Response.status(Response.Status.OK).build();
    }

    // Rota para o Dapr entregar as mensagens do tópico B
    @POST
    @Path("B")
    public Response bRoute(DaprJson json) {
        System.out.println("B: " + json.data);
        return Response.status(Response.Status.OK).build();
    }

}