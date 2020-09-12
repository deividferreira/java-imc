package br.eti.deividferreira.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@Table(name = "peso_ideal")
public class PesoIdeal implements CalculaIMC {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;
    @Getter
    @Column(name = "data_insercao", nullable = false)
    private LocalDate dataInsercao;
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 90)
    @NotBlank(message = "Nome não deve ser vazio")
    private String nome;
    @Getter
    @Setter
    @CPF(message = "CPF Inválido")
    @Column(name = "cpf", length = 11, unique = true, nullable = false)
    @NotBlank(message = "CPF não deve ser vazio")
    private String cpf;
    @Getter
    @Setter
    @Column(name = "altura", nullable = false)
    @NotNull(message = "Altura não deve ser vazio")
    private Double altura;
    @Getter
    @Setter
    @Column(name = "peso", nullable = false)
    @NotNull(message = "Peso não deve ser vazio")
    private Double peso;
    @Getter
    @Setter
    @Column(name = "classificacao", length = 50)
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @Getter
    @Setter
    @Column(name = "imc")
    private Double imc;

    @PrePersist
    private void prePersist() {
        this.dataInsercao = LocalDate.now();
        this.calculaIMC();
        this.definiClassificacao(this.imc);
    }

    @Override
    public void calculaIMC() {
        this.imc = this.peso / Math.pow(this.altura, 2);
    }

    @Override
    public void definiClassificacao(Double imc) {
        this.classificacao = Classificacao.getClassificacao(imc);
    }
}
