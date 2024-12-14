package com.metrosp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "arestas")
public class Aresta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int peso;

    @ManyToOne
    @JoinColumn(name = "inicio_id", nullable = false)
    private Vertice inicio;

    @ManyToOne
    @JoinColumn(name = "fim_id", nullable = false)
    private Vertice fim;

    @Column(nullable = false)
    private String linha;

    // Construtor vazio (pode ser necessário para JPA)
    public Aresta() {
    }

    public Aresta(int peso, Vertice inicio, Vertice fim, String linha) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        this.linha = linha;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }
}