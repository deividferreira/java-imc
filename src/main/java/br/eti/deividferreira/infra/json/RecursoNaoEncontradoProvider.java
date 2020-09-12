package br.eti.deividferreira.infra.json;

import br.eti.deividferreira.domain.exception.RecursoNaoEncontradoException;
import br.eti.deividferreira.infra.MensagemErro;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RecursoNaoEncontradoProvider implements ExceptionMapper<RecursoNaoEncontradoException> {
    @Override
    public Response toResponse(RecursoNaoEncontradoException exception) {
        return Response.status(exception.getResponse().getStatus())
                .entity(MensagemErro.of(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
