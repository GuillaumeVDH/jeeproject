package org.flst.jeeproject.services;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBException;
import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * Created by anthonycallaert on 22/12/2015.
 */

public class ShelfRestService {
    private static URI uri = UriBuilder.fromUri("http://localhost/which-shelf-0.0.1-SNAPSHOT/rs/article").port(8080).build();
    private static Client client = ClientBuilder.newClient();

    @Test
    public void shouldNotFindTheArticleID() throws JAXBException {

        // GETs a Book with an unknown ID
        Response response = client.target(uri).path("invalidID").request().get();
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
