package com.metrosp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vertices")
public class Vertice {

    public Vertice() {
    }

    public Vertice(String dado) {
        this.dado = dado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dado;

    @OneToMany(mappedBy = "inicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aresta> arestasEntrada = new ArrayList<>();

    @OneToMany(mappedBy = "fim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aresta> arestasSaida = new ArrayList<>();

    public String getDado() {
        return dado;
    }

    public ArrayList<Aresta> getArestasEntrada() {
        return (ArrayList<Aresta>) arestasEntrada;
    }

    public ArrayList<Aresta> getArestasSaida() {
        return (ArrayList<Aresta>) arestasSaida;
    }

    public void adicionarArestaEntrada(Aresta aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta aresta) {
        this.arestasSaida.add(aresta);
    }

}
