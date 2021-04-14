package com.chadreque.software.paisapi.exception;

import com.chadreque.software.paisapi.model.ResponseMessage;
import com.chadreque.software.paisapi.util.Constante;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<ElementoNotFound> {
    public Response toResponse(ElementoNotFound ex) {
        ResponseMessage responseMessage = new ResponseMessage(
                new Date(),
                Response.Status.NOT_FOUND.getStatusCode(),
                Constante.NOT_FOUND_DESCRIPTION,
                Constante.NO_ELEMENT_FOUND_MESSAGE
        );

        return Response.status(Response.Status.NOT_FOUND).entity(responseMessage).build();
    }
}
