package br.eti.deividferreira.domain.entities;

public interface CalculaIMC {

    void calculaIMC();

    void definiClassificacao(Double imc);
}
