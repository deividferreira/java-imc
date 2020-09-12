package br.eti.deividferreira.domain.entities;

public enum Classificacao {
    BAIXO("Baixo peso", 18.5),
    ADEQUADO("Peso adequado", 25.0),
    SOBREPESO("Sobrepeso", 30.0),
    OBESIDADE("Obesidade", null);

    private String descricao;
    private Double limite;

    Classificacao(String descricao, Double limite) {
        this.descricao = descricao;
        this.limite = limite;
    }

    public static Classificacao getClassificacao(Double imc) {
        if (imc.compareTo(Classificacao.BAIXO.limite) == -1)
            return Classificacao.BAIXO;
        else if (imc.compareTo(Classificacao.ADEQUADO.limite) == -1)
            return Classificacao.ADEQUADO;
        else if (imc.compareTo(Classificacao.SOBREPESO.limite) == -1)
            return Classificacao.SOBREPESO;
        else
            return Classificacao.OBESIDADE;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
