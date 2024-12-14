package com.metrosp.service;

import com.metrosp.model.Grafo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metrosp.model.Vertice;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetroService {
    private final Grafo grafo;

    @Autowired
    public MetroService(Grafo grafo) {
        this.grafo = grafo;
    }

    public List<String> getEstacoes() {
        return grafo.getVertices().stream()
                .map(Vertice::getDado)
                .collect(Collectors.toList());
    }

    public String calcularRota(String partida, String chegada) {
        return grafo.DijkstraSem(partida, chegada);
    }
}
