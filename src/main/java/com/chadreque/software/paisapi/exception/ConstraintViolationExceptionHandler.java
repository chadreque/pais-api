package com.chadreque.software.paisapi.exception;

import com.chadreque.software.paisapi.model.ResponseMessage;
import com.chadreque.software.paisapi.util.Constante;
import org.springframework.transaction.TransactionSystemException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<TransactionSystemException> {
    public Response toResponse(TransactionSystemException ex) {
        ResponseMessage responseMessage = new ResponseMessage(new Date(),
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                Constante.INTERNAL_ERROR_DESCRIPTION,
                Constante.INVALID_FIELD_MESSAGE);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(responseMessage).build();
    }
}
