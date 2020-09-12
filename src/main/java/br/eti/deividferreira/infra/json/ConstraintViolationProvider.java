package br.eti.deividferreira.infra.json;

import br.eti.deividferreira.infra.MensagemErro;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationProvider implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Status.BAD_REQUEST)
                .entity(MensagemErro.of(exception, Status.BAD_REQUEST))
                .type(MediaType.APPLICATION_JSON)
                .build();

    }
}
