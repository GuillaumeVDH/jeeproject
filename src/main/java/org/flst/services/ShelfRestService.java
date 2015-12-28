package org.flst.services;

import org.flst.entity.Shelf;
import org.flst.entity.Shelfs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by anthonycallaert on 22/12/2015.
 */
@Path("/shelf")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
@Stateless
public class ShelfRestService {

    @PersistenceContext(unitName = "jeeproject")
    private EntityManager entityManager;

    @Context
    private UriInfo uriInfo;

    /**
     * JSON : curl -X GET -H "Accept: application/json" http://localhost:8080/which-shelf-0.0.1-SNAPSHOT/rs/article/1 -v
     * XML  : curl -X GET -H "Accept: application/xml" http://localhost/which-shelf-0.0.1-SNAPSHOT/rs/article/1 -v
     */
    @GET
    @Path("{id}")
    public Response getShelf(@PathParam("id") Integer id){
        Shelf shelf = entityManager.find(Shelf.class, id);

        if(shelf == null){
            throw new NotFoundException();
        }

        return Response.ok(shelf).build();
    }

    /**
     * JSON : curl -X GET -H "Accept: application/json" http://localhost:8080/which-shelf-0.0.1-SNAPSHOT/rs/article -v
     * XML  : curl -X GET -H "Accept: application/xml" http://localhost:8080/which-shelf-0.0.1-SNAPSHOT/rs/article -v
     */
    @GET
    public Response getAllShelfs(){
        TypedQuery<Shelf> typedQuery = (TypedQuery<Shelf>) entityManager.createNamedQuery(Shelf.FIND_ALL);
        Shelfs shelfs = new Shelfs(typedQuery.getResultList());
        return Response.ok(shelfs).build();
    }
}
