package br.eti.deividferreira.infra.json;

import br.eti.deividferreira.infra.MensagemErro;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultWebExceptionProvider implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        return Response.status(exception.getResponse().getStatus())
                .entity(MensagemErro.of(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
