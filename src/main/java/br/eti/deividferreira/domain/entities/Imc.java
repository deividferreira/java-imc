package br.eti.deividferreira.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@Table(name = "imc")
public class Imc implements CalculaIMC {
    @Id
    @Getter
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

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

    @Getter
    @Column(name = "data_insercao", nullable = false)
    private LocalDate dataInsercao;

    @Setter
    @Getter
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_individuo", nullable = false)
    private Individuo individuo;

    public Imc() {
    }

    public Imc(Double altura, Double peso) {
        this.peso = peso;
        this.altura = altura;
    }

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
