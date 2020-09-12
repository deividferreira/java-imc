package br.eti.deividferreira.domain.service.impl;

import br.eti.deividferreira.domain.entities.Imc;
import br.eti.deividferreira.domain.entities.Individuo;
import br.eti.deividferreira.domain.exception.RecursoNaoEncontradoException;
import br.eti.deividferreira.domain.repository.ImcRepository;
import br.eti.deividferreira.domain.repository.IndividuoRepository;
import br.eti.deividferreira.domain.service.PesoIdealService;
import br.eti.deividferreira.web.request.PesoIdealRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class PesoIdealServiceImpl implements PesoIdealService {

    private final IndividuoRepository individuoRepository;
    private final ImcRepository imcRepository;

    PesoIdealServiceImpl(IndividuoRepository individuoRepository, ImcRepository imcRepository) {
        this.individuoRepository = individuoRepository;
        this.imcRepository = imcRepository;
    }

    @Override
    public List<Individuo> todos() {
        return this.individuoRepository.findAll();
    }

    @Override
    public Individuo salvar(PesoIdealRequest request) {
        this.individuoRepository.findByCpf(request.getCpfSemMascara()).ifPresentOrElse(found -> {
            var imc = request.toImc();
            validarImc(imc, found);

            this.imcRepository.save(imc);
        }, () -> {
            this.individuoRepository.save(request.toIndividuo());
        });

        return this.individuoRepository.findByCpf(request.getCpfSemMascara()).get();
    }

    @Override
    public Individuo buscarPor(String cpf) {
        String cpfSemMascara = cpf.replace(".", "").replace("-", "");
        return this.individuoRepository.findByCpf(cpfSemMascara).orElseThrow(
                () -> new RecursoNaoEncontradoException("Nenhum IMC foi encontrado para este CPF"));
    }

    private void validarImc(Imc imc, Individuo individuo) {
        this.imcRepository.findByPesoAndAlturaAndIndividuo(imc.getPeso(), imc.getAltura(), individuo).ifPresentOrElse(found -> {
            throw new WebApplicationException("Você já possui um IMC para este peso e altura", Response.Status.BAD_REQUEST);
        }, () ->  individuo.addImc(imc));
    }
}
