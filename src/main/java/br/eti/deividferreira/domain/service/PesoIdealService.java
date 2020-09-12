package br.eti.deividferreira.domain.service;

import br.eti.deividferreira.domain.entities.Individuo;
import br.eti.deividferreira.web.request.PesoIdealRequest;

import javax.transaction.Transactional;
import java.util.List;

public interface PesoIdealService {

    /**
     * Retorna todos os dados
     *
     * @return todos os calculos contendo todas as informações
     */
    List<Individuo> todos();

    /**
     * salva o objeto no banco de dados
     *
     * @param request
     * @return o objeto salvo
     */
    @Transactional
    Individuo salvar(PesoIdealRequest request);

    /**
     * busca um determinado registro por CPF
     * @param cpf
     * @return o PesoIdeal
     */
    Individuo buscarPor(String cpf);

}
