package br.edu.iesb.pea.models;

public class Automovel {

    private Long id;
    private String nome;
    private boolean possuiCorFosca;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPossuiCorFosca() {
        return possuiCorFosca;
    }

    public void setPossuiCorFosca(boolean possuiCorFosca) {
        this.possuiCorFosca = possuiCorFosca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
