package org.acme;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

@Path("/publish")
public class PublisherResource {

    String daprPort = System.getenv().getOrDefault("DAPR_HTTP_PORT", "3500"); // Porta em que o Dapr está escutando
    String pubsubName = "pubsub"; // O mesmo presente em metadata.name do arquivo .yaml do componente pubsub
    String daprUrl = "http://localhost:" + daprPort + "/v1.0/publish/" + pubsubName;

    @POST
    public Response post(Order order) {
        System.out.println("Publishing: Topic: " + order.topic + "; Message:" + order.message);
        String publishUrl = daprUrl + "/" + order.topic;

        Client client = ClientBuilder.newClient();
        return client
            .target(publishUrl)
            .request(MediaType.TEXT_PLAIN)
            .post(Entity.entity(order.message, MediaType.TEXT_PLAIN) );
    }
}