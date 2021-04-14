package com.chadreque.software.paisapi.exception;

import com.chadreque.software.paisapi.model.ResponseMessage;
import com.chadreque.software.paisapi.util.Constante;
import org.springframework.dao.DataIntegrityViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class AlreadyExistsExceptionHandler implements ExceptionMapper<DataIntegrityViolationException> {
    public Response toResponse(DataIntegrityViolationException ex) {
        ResponseMessage responseMessage = new ResponseMessage(
                new Date(), Response.Status.CONFLICT.getStatusCode(),
                Constante.CONFLICT_DESCRIPTION,
                Constante.DUPLICATED_FIELD_MESSAGE);
        return Response.status(Response.Status.CONFLICT.getStatusCode()).entity(responseMessage).build();
    }
}
