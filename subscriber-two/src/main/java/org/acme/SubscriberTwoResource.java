package org.acme;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class SubscriberTwoResource {
    // As inscrições para esse subscriber foram feitas declarativamente nos arquivos deploy/a-subscriptions.yaml e deploy/c-subscriptions.yaml

    // Rota para o Dapr entregar as mensagens do tópico A
    @POST
    @Path("A")
    public Response aRoute(DaprJson json) {
        System.out.println("A: " + json.data);
        return Response.status(Response.Status.OK).build();
    }

    // Rota para o Dapr entregar as mensagens do tópico C
    @POST
    @Path("C")
    public Response cRoute(DaprJson json) {
        System.out.println("C: " + json.data);
        return Response.status(Response.Status.OK).build();
    }
}