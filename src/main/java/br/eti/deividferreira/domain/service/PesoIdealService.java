package br.eti.deividferreira.domain.service;

import br.eti.deividferreira.domain.entities.PesoIdeal;
import br.eti.deividferreira.web.response.PesoIdealResponse;

import java.util.List;

public interface PesoIdealService {

    /**
     * Retorna todos os dados
     *
     * @return todos os calculos contendo todas as informações
     */
    List<PesoIdeal> todos();

    /**
     * salva o objeto no banco de dados
     *
     * @param pesoIdeal
     * @return o objeto salvo
     */
    PesoIdealResponse salvar(PesoIdeal pesoIdeal);

    /**
     * busca um determinado registro por CPF
     * @param cpf
     * @return o PesoIdeal
     */
    PesoIdeal buscarPor(String cpf);

}
