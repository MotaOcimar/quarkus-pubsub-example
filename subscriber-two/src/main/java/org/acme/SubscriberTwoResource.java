package org.acme;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class SubscriberTwoResource {
    // As inscrições para esse subscriber foram feitas declarativamente no arquivo deploy/subscriptions.yaml
    // TODO: garantir que o nome do arquivo deploy/subscriptions.yaml está atualizado no comentário acima
    // TODO: Avisar que estou usando Jackson (https://quarkus.io/guides/rest-json#creating-the-maven-project)


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