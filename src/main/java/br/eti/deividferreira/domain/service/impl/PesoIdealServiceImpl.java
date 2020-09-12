package br.eti.deividferreira.domain.service.impl;

import br.eti.deividferreira.domain.entities.PesoIdeal;
import br.eti.deividferreira.domain.exception.RecursoNaoEncontradoException;
import br.eti.deividferreira.domain.repository.PesoIdealRepository;
import br.eti.deividferreira.domain.service.PesoIdealService;
import br.eti.deividferreira.web.response.PesoIdealResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class PesoIdealServiceImpl implements PesoIdealService {

    private final PesoIdealRepository pesoIdealRepository;

    PesoIdealServiceImpl(PesoIdealRepository pesoIdealRepository) {
        this.pesoIdealRepository = pesoIdealRepository;
    }

    @Override
    public List<PesoIdeal> todos() {
        return this.pesoIdealRepository.findAll();
    }

    @Override
    public PesoIdealResponse salvar(PesoIdeal pesoIdeal) {
        this.pesoIdealRepository.findByCpf(pesoIdeal.getCpf()).ifPresent(found -> {
            throw new WebApplicationException("Já existe um registro com esse CPF", 400);
        });
        return PesoIdealResponse.build(this.pesoIdealRepository.save(pesoIdeal));
    }

    @Override
    public PesoIdeal buscarPor(String cpf) {
        return this.pesoIdealRepository.findByCpf(cpf).orElseThrow(
                () -> new RecursoNaoEncontradoException("Nenhum IMC foi encontrado para este CPF"));
    }
}
