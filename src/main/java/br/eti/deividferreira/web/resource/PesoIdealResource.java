package br.eti.deividferreira.web.resource;

import br.eti.deividferreira.domain.entities.Individuo;
import br.eti.deividferreira.domain.service.PesoIdealService;
import br.eti.deividferreira.web.request.PesoIdealRequest;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("imc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PesoIdealResource {

    private final PesoIdealService pesoIdealService;

    public PesoIdealResource(PesoIdealService pesoIdealService) {
        this.pesoIdealService = pesoIdealService;
    }

    @GET
    public List<Individuo> todos() {
        return this.pesoIdealService.todos();
    }

    @POST
    public Response salvar(@Valid PesoIdealRequest request) {
        return Response.ok(this.pesoIdealService.salvar(request))
                .status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{cpf}")
    public Response buscarPor(@PathParam("cpf") @CPF(message = "CPF Inválido") String cpf) {
        return Response.ok(this.pesoIdealService.buscarPor(cpf)).build();
    }

}
