package br.eti.deividferreira.domain.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RecursoNaoEncontradoException extends WebApplicationException {

    public RecursoNaoEncontradoException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}
