package br.eti.deividferreira.web.response;

import br.eti.deividferreira.domain.entities.Classificacao;
import br.eti.deividferreira.domain.entities.PesoIdeal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PesoIdealResponse {
    @Getter
    @Setter
    private Double imc;
    @Getter
    @Setter
    private Classificacao classificacao;

    public static PesoIdealResponse build(PesoIdeal pesoIdeal) {
        return new PesoIdealResponse(pesoIdeal.getImc(), pesoIdeal.getClassificacao());
    }
}
