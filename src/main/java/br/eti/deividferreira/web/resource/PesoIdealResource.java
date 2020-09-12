package br.eti.deividferreira.web.resource;

import br.eti.deividferreira.domain.entities.PesoIdeal;
import br.eti.deividferreira.domain.service.PesoIdealService;
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
    public List<PesoIdeal> todos() {
        return this.pesoIdealService.todos();
    }

    @POST
    public Response salvar(@Valid PesoIdeal pesoIdeal) {
        return Response.ok(this.pesoIdealService.salvar(pesoIdeal))
                .status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{cpf}")
    public Response buscarPor(@PathParam("cpf") @CPF(message = "CPF Inválido") String cpf) {
        System.out.println("Teste " + cpf);
        return Response.ok(this.pesoIdealService.buscarPor(cpf)).build();
    }

}
