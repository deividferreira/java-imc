package br.eti.deividferreira.web.request;

import br.eti.deividferreira.domain.entities.Imc;
import br.eti.deividferreira.domain.entities.Individuo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
public class PesoIdealRequest {
    @Getter
    @Setter
    @NotBlank(message = "Nome não deve ser vazio")
    private String nome;
    @Getter
    @Setter
    @NotNull(message = "Altura não deve ser vazio")
    private Double altura;
    @Getter
    @Setter
    @NotNull(message = "Peso não deve ser vazio")
    private Double peso;
    @Getter
    @Setter
    @CPF(message = "CPF Inválido")
    @NotBlank(message = "CPF não deve ser vazio")
    private String cpf;

    public Individuo toIndividuo() {
        return new Individuo(this.nome, getCpfSemMascara(), new Imc(this.altura, this.peso));
    }

    public Imc toImc() {
        return new Imc(this.altura, this.peso);
    }

    public String getCpfSemMascara() {
        return this.cpf.replace(".", "").replace("-", "");
    }

}
