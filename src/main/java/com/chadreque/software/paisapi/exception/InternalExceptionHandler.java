package com.chadreque.software.paisapi.exception;

import com.chadreque.software.paisapi.model.ResponseMessage;
import com.chadreque.software.paisapi.util.Constante;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class InternalExceptionHandler implements ExceptionMapper<InternalException> {
    public Response toResponse(InternalException ex) {
        ResponseMessage responseMessage = new ResponseMessage(new Date(),
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                Constante.INTERNAL_ERROR_DESCRIPTION,
                Constante.INTERNAL_ERROR_MESSAGE);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(responseMessage).build();
    }
}
