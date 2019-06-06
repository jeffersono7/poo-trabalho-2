package br.edu.iesb.pea.models;

public class Item {

    private Automovel automovel;
    private Integer quantidade;
    private Double valor;
    private String cor;
    private boolean ehFosca;

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isEhFosca() {
        return ehFosca;
    }

    public void setEhFosca(boolean ehFosca) {
        this.ehFosca = ehFosca;
    }
}
