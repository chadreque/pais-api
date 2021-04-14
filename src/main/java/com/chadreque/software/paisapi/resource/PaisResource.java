package com.chadreque.software.paisapi.resource;

import com.chadreque.software.paisapi.exception.InternalException;
import com.chadreque.software.paisapi.model.Pais;
import com.chadreque.software.paisapi.model.ResponseMessage;
import com.chadreque.software.paisapi.service.PaisService;
import com.chadreque.software.paisapi.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Component
@Path("/paises")
//@RestController
//@RequestMapping("/paises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaisResource {

    @Autowired
    private PaisService service;

@GET
    public Response listar(@QueryParam("orderby") String orderBy, @QueryParam("ordertype") String orderType) {
        return Response.ok().entity(service.listar(orderBy, orderType)).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        if(id == null)
            throw new InternalException();

        return Response.ok().entity(service.getPais(id)).build();
    }

    @POST
    public Response inserir(Pais pais) {
        if(pais == null)
            throw new InternalException();

        return Response.status(Response.Status.CREATED).entity(service.merge(pais)).build();
    }

    @PUT
    public Response actualizar(Pais pais) {
        if(pais == null)
            throw new InternalException();

        return Response.status(Response.Status.ACCEPTED).entity(service.merge(pais)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Long id) {
        if(id == null)
            throw new InternalException();

        service.eliminar(id);

        ResponseMessage responseMessage = new ResponseMessage(
                new Date(),
                Response.Status.ACCEPTED.getStatusCode(),
                Constante.ACCEPTED_DESCRIPTION,
                id + Constante.DELETE_SUCCESS_MESSAGE
        );

        return Response.status(Response.Status.ACCEPTED).entity(responseMessage).build();
    }
}
