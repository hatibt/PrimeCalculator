package com.hatib.resources;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Hatib on 11/05/2016.
 */
@Provider
public class PrimeCalculatorExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {

        ErrorMessage errorMessage = createErrorMessage(ex);
        return Response.status(errorMessage.getStatus())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private ErrorMessage createErrorMessage(Exception ex) {
        if(ex instanceof WebApplicationException) {
            return new ErrorMessage(((WebApplicationException) ex).getResponse().getStatus(), ex.getMessage());
        } else {
            return new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ex.getMessage());
        }
    }
}