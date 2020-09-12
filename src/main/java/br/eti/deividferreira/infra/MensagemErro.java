package br.eti.deividferreira.infra;

import lombok.Getter;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;
import java.util.stream.Collectors;

public final class MensagemErro {

    @Getter
    private int httpStatus;
    @Getter
    private String mensagem;

    private MensagemErro(int httpStatus, String mensagem) {
        this.httpStatus = httpStatus;
        this.mensagem = mensagem;
    }

    public static MensagemErro of(WebApplicationException exception) {
        final String message = exception.getMessage() != null
                ? exception.getMessage() : "";
        return new MensagemErro(exception.getResponse().getStatus(), message);
    }

    public static MensagemErro of(Throwable exception, Status status) {
        return new MensagemErro(status.getStatusCode(), exception.getMessage());
    }

    public static MensagemErro of(ConstraintViolationException exception, Status status) {
        String mensagem = exception.getConstraintViolations().stream()
                .map(cv -> cv.getMessage())
                .collect(Collectors.joining(", "));
        return new MensagemErro(status.getStatusCode(), mensagem);
    }

}
