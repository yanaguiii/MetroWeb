package com.metrosp.controller;

import com.metrosp.service.MetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/metro")
public class MetroController {
    @Autowired
    private MetroService metroService;

    @GetMapping("/estacoes")
    public List<String> getEstacoes() {
        return metroService.getEstacoes();
    }

    @GetMapping("/rota")
    public String calcularRota(@RequestParam String partida, @RequestParam String chegada) {
        return metroService.calcularRota(partida, chegada);
    }
}

