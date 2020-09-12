package br.eti.deividferreira.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@EqualsAndHashCode
@Table(name = "individuo")
public class Individuo {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

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

    @OneToMany(mappedBy = "individuo", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Imc> imcs;

    public Individuo() {
        this.imcs = new ArrayList<>();
    }

    public Individuo(String nome, String cpf, Imc imc) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        addImc(imc);
    }

    public List<Imc> getImcs() {
        return Collections.unmodifiableList(this.imcs);
    }

    public void addImc(Imc imc) {
        this.imcs.add(imc);
        imc.setIndividuo(this);
    }

}
