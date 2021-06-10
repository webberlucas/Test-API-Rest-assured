package br.com.automacaoAPI.model;

import br.com.automacaoAPI.teste.BaseTeste;

import java.math.BigDecimal;

public class SimulaCredCPF {

    private String nome = "Jose Pai";
    private String cpf = "98745632122";
    private String email = "JosePai@gmail.com";
    private BigDecimal valor = BigDecimal.valueOf(10000);
    private int parcelas = 5;
    private boolean seguro = true;

   // public SimulaCredCPF(){}

    public SimulaCredCPF(String nome, String cpf, String email, BigDecimal valor, int parcelas, boolean seguro) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.parcelas = parcelas;
        this.seguro = seguro;
    }

    public SimulaCredCPF(String nome, String email, BigDecimal valor, int parcelas, boolean seguro) {
        this.nome = nome;
        this.email = email;
        this.valor = valor;
        this.parcelas = parcelas;
        this.seguro = seguro;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public boolean isSeguro() {
        return seguro;
    }
}
