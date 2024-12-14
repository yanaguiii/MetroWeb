package com.metrosp.model;

import com.metrosp.repository.ArestaRepository;
import com.metrosp.repository.VerticeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class Grafo {

    @Autowired
    private VerticeRepository verticeRepository;

    @Autowired
    private ArestaRepository arestaRepository;

    @PostConstruct
    public void init() {
        inicializarGrafo();
    }

    @Transactional
    public void inicializarGrafo() {
        if (verticeRepository.count() == 0) {
            adicionarEstacoes();
            adicionarArestas();
        }
    }

    public List<Vertice> getVertices() {
        return verticeRepository.findAll();
    }

    private void adicionarEstacoes() {
        String[] estacoes = {
                "Jabaquara", "Conceição", "São Judas", "Saúde", "Praça da Árvore",
                "Vila Mariana", "Ana Rosa", "Paraíso", "Vergueiro",
                "São Joaquim", "Liberdade", "Sé", "São Bento", "Luz", "Tiradentes",
                "Armênia", "Portuguesa-Tietê", "Carandiru", "Santana", "Jardim São Paulo-Ayrton Senna",
                "Parada Inglesa", "Tucuruvi", "Vila Madalena", "Sumaré", "Clínicas",
                "Consolação", "Trianon-Masp", "Brigadeiro", "Santos-Imigrantes",
                "Alto do Ipiranga", "Sacomã", "Tamanduateí", "Vila Prudente", "Palmeiras-Barra Funda",
                "Marechal Deodoro", "Santa Cecília", "República", "Anhangabaú","Pedro II", "Brás",
                "Bresser-Mooca", "Belém", "Tatuapé", "Carrão", "Penha",
                "Vila Matilde", "Guilhermina-Esperança", "Patriarca", "Artur Alvim", "Corinthians-Itaquera",
                "Oratório", "São Lucas", "Camilo Haddad", "Vila Tolstói", "Vila União",
                "Jardim Planalto", "Sapopemba", "Fazenda da Juta", "São Mateus", "Jardim Colonial",
                "Oscar Freire", "Higienópolis-Mackenzie", "Juventus", "Domingos de Moraes",
                "Fradique Coutinho", "Faria Lima", "Pinheiros", "Butantã", "São Paulo-Morumbi",
                "Vila Sônia", "Capão Redondo", "Campo Limpo", "Vila das Belezas", "Giovanni Gronchi",
                "Santo Amaro", "Largo Treze", "Adolfo Pinheiro", "Alto da Boa Vista", "Borba Gato",
                "Brooklin", "Campo Belo", "Eucaliptos", "Moema", "AACD-Servidor",
                "Hospital São Paulo", "Santa Cruz", "Chácara Klabin", "Jundiaí", "Várzea Paulista",
                "Campo Limpo Paulista", "Botujuru", "Francisco Morato", "Baltazar Fidélis", "Caieiras",
                "Franco da Rocha", "João Dias", "Mendes-Vila Natal", "Imperatriz Leopoldina",
                "Perus", "Vila Aurora", "Jaraguá", "Vila Clarice", "Pirituba",
                "Piqueri", "Lapa", "Água Branca", "Júlio Prestes", "Osasco", "Presidente Altino",
                "Comandante Sampaio", "Quitaúna", "General Miguel Costa", "Carapicuíba", "Santa Terezinha",
                "Antonio João", "Sagrado Coração", "Jandira", "Jardim Silveira", "Jardim Belval",
                "Barueri", "Engenheiro Cardoso", "Itapevi", "Santa Rita", "Amador Bueno",
                "Ceasa", "Villa-Lobos-Jaguaré", "Cidade Universitária", "Hebraica-Rebouças", "Cidade Jardim",
                "Vila Olímpia", "Berrini", "Morumbi", "Granja Julieta", "Socorro",
                "Jurubatuba", "Autódromo", "Interlagos", "Grajaú", "Mooca",
                "Ipiranga", "São Caetano", "Utinga", "Prefeito Saladino",
                "Santo André", "Capuava", "Mauá", "Guapituba", "Ribeirão Pires",
                "Rio Grande da Serra", "Dom Bosco", "José Bonifácio", "Guaianases", "Antonio Gianetti Neto",
                "Ferraz de Vasconcelos", "Poá", "Suzano", "Jundiapeba", "Braz Cubas",
                "Mogi das Cruzes", "Estudantes", "Engenheiro Goulart", "USP Leste", "Comendador Ermelino",
                "São Miguel Paulista", "Jardim Helena-Vila Mara", "Itaim Paulista", "Jardim Romano",
                "Engenheiro Manoel Feio", "Itaquaquecetuba", "Aracaré", "Calmon Viana", "Guarulhos-Cecap",
                "Aeroporto-Guarulhos"
        };
        for (String estacao : estacoes) {
            adicionarVertice(estacao);
        }
    }

    private void adicionarVertice(String dado) {
        if (dado != null && !dado.isEmpty() && verticeRepository.findByDado(dado) == null) {
            Vertice novoVertice = new Vertice(dado);
            verticeRepository.save(novoVertice);
        }
    }

    public void adicionarArestas() {
        //Linha Azul
        adicionarAresta(2, "Jabaquara", "Conceição", "Linha 1 - Azul");
        adicionarAresta(4, "Conceição", "São Judas", "Linha 1 - Azul");
        adicionarAresta(2, "São Judas", "Saúde", "Linha 1 - Azul");
        adicionarAresta(2, "Saúde", "Praça da Árvore", "Linha 1 - Azul");
        adicionarAresta(2, "Praça da Árvore", "Santa Cruz", "Linha 1 - Azul");
        adicionarAresta(2, "Santa Cruz", "Vila Mariana", "Linha 1 - Azul");
        adicionarAresta(2, "Vila Mariana", "Ana Rosa", "Linha 1 - Azul");
        adicionarAresta(2, "Ana Rosa", "Paraíso", "Linha 1 - Azul");
        adicionarAresta(2, "Paraíso", "Vergueiro", "Linha 1 - Azul");
        adicionarAresta(2, "Vergueiro", "São Joaquim", "Linha 1 - Azul");
        adicionarAresta(2, "São Joaquim", "Liberdade", "Linha 1 - Azul");
        adicionarAresta(2, "Liberdade", "Sé", "Linha 1 - Azul");
        adicionarAresta(2, "Sé", "São Bento", "Linha 1 - Azul");
        adicionarAresta(2, "São Bento", "Luz", "Linha 1 - Azul");
        adicionarAresta(2, "Luz", "Tiradentes", "Linha 1 - Azul");
        adicionarAresta(2, "Tiradentes", "Armênia", "Linha 1 - Azul");
        adicionarAresta(2, "Armênia", "Portuguesa-Tietê", "Linha 1 - Azul");
        adicionarAresta(2, "Portuguesa-Tietê", "Carandiru", "Linha 1 - Azul");
        adicionarAresta(2, "Carandiru", "Santana", "Linha 1 - Azul");
        adicionarAresta(2, "Santana", "Jardim São Paulo-Ayrton Senna", "Linha 1 - Azul");
        adicionarAresta(2, "Jardim São Paulo-Ayrton Senna", "Parada Inglesa", "Linha 1 - Azul");
        adicionarAresta(2, "Parada Inglesa", "Tucuruvi", "Linha 1 - Azul");

        // Linha 2 - Verde
        adicionarAresta(2, "Vila Madalena", "Sumaré", "Linha 2 - Verde");
        adicionarAresta(2, "Sumaré", "Clínicas", "Linha 2 - Verde");
        adicionarAresta(2, "Clínicas", "Consolação", "Linha 2 - Verde");
        adicionarAresta(2, "Consolação", "Trianon-Masp", "Linha 2 - Verde");
        adicionarAresta(2, "Trianon-Masp", "Brigadeiro", "Linha 2 - Verde");
        adicionarAresta(2, "Brigadeiro", "Paraíso", "Linha 2 - Verde");
        adicionarAresta(2, "Paraíso", "Ana Rosa", "Linha 2 - Verde");
        adicionarAresta(2, "Ana Rosa", "Chácara Klabin", "Linha 2 - Verde");
        adicionarAresta(2, "Chácara Klabin", "Santos-Imigrantes", "Linha 2 - Verde");
        adicionarAresta(2, "Santos-Imigrantes", "Alto do Ipiranga", "Linha 2 - Verde");
        adicionarAresta(2, "Alto do Ipiranga", "Sacomã", "Linha 2 - Verde");
        adicionarAresta(2, "Sacomã", "Tamanduateí", "Linha 2 - Verde");
        adicionarAresta(2, "Tamanduateí", "Vila Prudente", "Linha 2 - Verde");

        // Linha 3 - Vermelha
        adicionarAresta(2, "Palmeiras-Barra Funda", "Marechal Deodoro", "Linha 3 - Vermelha");
        adicionarAresta(2, "Marechal Deodoro", "Santa Cecília", "Linha 3 - Vermelha");
        adicionarAresta(2, "Santa Cecília", "República", "Linha 3 - Vermelha");
        adicionarAresta(2, "República", "Anhangabaú", "Linha 3 - Vermelha");
        adicionarAresta(2, "Anhangabaú", "Sé", "Linha 3 - Vermelha");
        adicionarAresta(2, "Sé", "Pedro II", "Linha 3 - Vermelha");
        adicionarAresta(2, "Pedro II","Brás", "Linha 3 - Vermelha");
        adicionarAresta(2, "Brás", "Bresser-Mooca", "Linha 3 - Vermelha");
        adicionarAresta(2, "Bresser-Mooca", "Belém", "Linha 3 - Vermelha");
        adicionarAresta(2, "Belém", "Tatuapé", "Linha 3 - Vermelha");
        adicionarAresta(2, "Tatuapé", "Carrão", "Linha 3 - Vermelha");
        adicionarAresta(2, "Carrão", "Penha", "Linha 3 - Vermelha");
        adicionarAresta(2, "Penha", "Vila Matilde", "Linha 3 - Vermelha");
        adicionarAresta(2, "Vila Matilde", "Guilhermina-Esperança", "Linha 3 - Vermelha");
        adicionarAresta(2, "Guilhermina-Esperança", "Patriarca", "Linha 3 - Vermelha");
        adicionarAresta(2, "Patriarca", "Artur Alvim", "Linha 3 - Vermelha");
        adicionarAresta(2, "Artur Alvim", "Corinthians-Itaquera", "Linha 3 - Vermelha");

        // Linha 4 - Amarela
        adicionarAresta(2, "Luz", "República", "Linha 4 - Amarela");
        adicionarAresta(2, "República", "Higienópolis-Mackenzie", "Linha 4 - Amarela");
        adicionarAresta(2, "Higienópolis-Mackenzie", "Consolação", "Linha 4 - Amarela");
        adicionarAresta(2, "Consolação", "Oscar Freire", "Linha 4 - Amarela");
        adicionarAresta(2, "Oscar Freire", "Fradique Coutinho", "Linha 4 - Amarela");
        adicionarAresta(2, "Fradique Coutinho", "Faria Lima", "Linha 4 - Amarela");
        adicionarAresta(2, "Faria Lima", "Pinheiros", "Linha 4 - Amarela");
        adicionarAresta(2, "Pinheiros", "Butantã", "Linha 4 - Amarela");
        adicionarAresta(2, "Butantã", "São Paulo-Morumbi", "Linha 4 - Amarela");
        adicionarAresta(2, "São Paulo-Morumbi", "Vila Sônia", "Linha 4 - Amarela");

        // Linha 5 - Lilás
        adicionarAresta(3, "Capão Redondo", "Campo Limpo", "Linha 5 - Lilás");
        adicionarAresta(3, "Campo Limpo", "Vila das Belezas", "Linha 5 - Lilás");
        adicionarAresta(3, "Vila das Belezas", "Giovanni Gronchi", "Linha 5 - Lilás");
        adicionarAresta(3, "Giovanni Gronchi", "Santo Amaro", "Linha 5 - Lilás");
        adicionarAresta(3, "Santo Amaro", "Largo Treze", "Linha 5 - Lilás");
        adicionarAresta(3, "Largo Treze", "Adolfo Pinheiro", "Linha 5 - Lilás");
        adicionarAresta(3, "Adolfo Pinheiro", "Alto da Boa Vista", "Linha 5 - Lilás");
        adicionarAresta(3, "Alto da Boa Vista", "Borba Gato", "Linha 5 - Lilás");
        adicionarAresta(3, "Borba Gato", "Brooklin", "Linha 5 - Lilás");
        adicionarAresta(3, "Brooklin", "Campo Belo", "Linha 5 - Lilás");
        adicionarAresta(3, "Campo Belo", "Eucaliptos", "Linha 5 - Lilás");
        adicionarAresta(3, "Eucaliptos", "Moema", "Linha 5 - Lilás");
        adicionarAresta(3, "Moema", "AACD-Servidor", "Linha 5 - Lilás");
        adicionarAresta(3, "AACD-Servidor", "Hospital São Paulo", "Linha 5 - Lilás");
        adicionarAresta(3, "Hospital São Paulo", "Santa Cruz", "Linha 5 - Lilás");
        adicionarAresta(3, "Santa Cruz", "Chácara Klabin", "Linha 5 - Lilás");

        // Linha 15 - Prata (Monotrilho)
        adicionarAresta(2, "Vila Prudente", "Oratório", "Linha 15 - Prata");
        adicionarAresta(2, "Oratório", "São Lucas", "Linha 15 - Prata");
        adicionarAresta(2, "São Lucas", "Camilo Haddad", "Linha 15 - Prata");
        adicionarAresta(2, "Camilo Haddad", "Vila Tolstói", "Linha 15 - Prata");
        adicionarAresta(2, "Vila Tolstói", "Vila União", "Linha 15 - Prata");
        adicionarAresta(2, "Vila União", "Jardim Planalto", "Linha 15 - Prata");
        adicionarAresta(2, "Jardim Planalto", "Sapopemba", "Linha 15 - Prata");
        adicionarAresta(2, "Sapopemba", "Fazenda da Juta", "Linha 15 - Prata");
        adicionarAresta(2, "Fazenda da Juta", "São Mateus", "Linha 15 - Prata");
        adicionarAresta(2, "São Mateus", "Jardim Colonial", "Linha 15 - Prata");

        // Linha 7 - Rubi (CPTM)
        adicionarAresta(5, "Jundiaí", "Várzea Paulista", "Linha 7 - Rubi");
        adicionarAresta(5, "Várzea Paulista", "Campo Limpo Paulista", "Linha 7 - Rubi");
        adicionarAresta(5, "Campo Limpo Paulista", "Botujuru", "Linha 7 - Rubi");
        adicionarAresta(5, "Botujuru", "Francisco Morato", "Linha 7 - Rubi");
        adicionarAresta(5, "Francisco Morato", "Baltazar Fidélis", "Linha 7 - Rubi");
        adicionarAresta(5, "Baltazar Fidélis", "Franco da Rocha", "Linha 7 - Rubi");
        adicionarAresta(5, "Franco da Rocha", "Caieiras", "Linha 7 - Rubi");
        adicionarAresta(5, "Caieiras", "Perus", "Linha 7 - Rubi");
        adicionarAresta(5, "Perus", "Vila Aurora", "Linha 7 - Rubi");
        adicionarAresta(5, "Vila Aurora", "Jaraguá", "Linha 7 - Rubi");
        adicionarAresta(5, "Jaraguá", "Vila Clarice", "Linha 7 - Rubi");
        adicionarAresta(5, "Vila Clarice", "Pirituba", "Linha 7 - Rubi");
        adicionarAresta(5, "Pirituba", "Piqueri", "Linha 7 - Rubi");
        adicionarAresta(5, "Piqueri", "Lapa", "Linha 7 - Rubi");
        adicionarAresta(5, "Lapa", "Água Branca", "Linha 7 - Rubi");
        adicionarAresta(5, "Água Branca", "Palmeiras-Barra Funda", "Linha 7 - Rubi");
        adicionarAresta(5, "Palmeiras-Barra Funda", "Luz", "Linha 7 - Rubi");

        // Linha 8 - Diamante (CPTM)
        adicionarAresta(5, "Júlio Prestes", "Palmeiras-Barra Funda", "Linha 8 - Diamante");
        adicionarAresta(5, "Palmeiras-Barra Funda", "Lapa", "Linha 8 - Diamante");
        adicionarAresta(5, "Lapa", "Domingos de Moraes", "Linha 8 - Diamante");
        adicionarAresta(5, "Domingos de Moraes", "Imperatriz Leopoldina", "Linha 8 - Diamante");
        adicionarAresta(5, "Imperatriz Leopoldina", "Presidente Altino", "Linha 8 - Diamante");
        adicionarAresta(5, "Presidente Altino", "Osasco", "Linha 8 - Diamante");
        adicionarAresta(5, "Osasco", "Comandante Sampaio", "Linha 8 - Diamante");
        adicionarAresta(5, "Comandante Sampaio", "Quitaúna", "Linha 8 - Diamante");
        adicionarAresta(5, "Quitaúna", "General Miguel Costa", "Linha 8 - Diamante");
        adicionarAresta(5, "General Miguel Costa", "Carapicuíba", "Linha 8 - Diamante");
        adicionarAresta(5, "Carapicuíba", "Santa Terezinha", "Linha 8 - Diamante");
        adicionarAresta(5, "Santa Terezinha", "Antonio João", "Linha 8 - Diamante");
        adicionarAresta(5, "Antonio João", "Barueri", "Linha 8 - Diamante");
        adicionarAresta(5, "Barueri", "Jardim Belval", "Linha 8 - Diamante");
        adicionarAresta(5, "Jardim Belval", "Jardim Silveira", "Linha 8 - Diamante");
        adicionarAresta(5, "Jardim Silveira", "Jandira", "Linha 8 - Diamante");
        adicionarAresta(5, "Jandira", "Sagrado Coração", "Linha 8 - Diamante");
        adicionarAresta(5, "Sagrado Coração", "Engenheiro Cardoso", "Linha 8 - Diamante");
        adicionarAresta(5, "Engenheiro Cardoso", "Itapevi", "Linha 8 - Diamante");
        adicionarAresta(5, "Itapevi", "Santa Rita", "Linha 8 - Diamante");
        adicionarAresta(5, "Santa Rita", "Amador Bueno", "Linha 8 - Diamante");



        // Linha 9 - Esmeralda (CPTM)
        adicionarAresta(4, "Osasco", "Presidente Altino", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Presidente Altino", "Ceasa", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Ceasa", "Villa-Lobos-Jaguaré", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Villa-Lobos-Jaguaré", "Cidade Universitária", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Cidade Universitária", "Pinheiros", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Pinheiros", "Hebraica-Rebouças", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Hebraica-Rebouças", "Cidade Jardim", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Cidade Jardim", "Vila Olímpia", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Vila Olímpia", "Berrini", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Berrini", "Morumbi", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Morumbi", "Granja Julieta", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Granja Julieta", "João Dias", "Linha 9 - Esmeralda");
        adicionarAresta(4, "João Dias", "Santo Amaro", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Santo Amaro", "Socorro", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Socorro", "Jurubatuba", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Jurubatuba", "Autódromo", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Autódromo", "Interlagos", "Linha 9 - Esmeralda");
        adicionarAresta(4, "Interlagos", "Grajaú", "Linha 9 - Esmeralda");
        ;adicionarAresta(4, "Grajaú", "Mendes-Vila Natal", "Linha 9 - Esmeralda");

        // Linha 10 - Turquesa (Brás ↔ Rio Grande da Serra)
        adicionarAresta(4, "Luz", "Brás", "Linha 10 - Turquesa");
        adicionarAresta(4, "Brás", "Juventus", "Linha 10 - Turquesa");
        adicionarAresta(4, "Juventus", "Ipiranga", "Linha 10 - Turquesa");
        adicionarAresta(4, "Ipiranga", "Tamanduateí", "Linha 10 - Turquesa");
        adicionarAresta(4, "Tamanduateí", "São Caetano", "Linha 10 - Turquesa");
        adicionarAresta(4, "São Caetano", "Utinga", "Linha 10 - Turquesa");
        adicionarAresta(4, "Utinga", "Prefeito Saladino", "Linha 10 - Turquesa");
        adicionarAresta(4, "Prefeito Saladino", "Santo André", "Linha 10 - Turquesa");
        adicionarAresta(4, "Santo André", "Capuava", "Linha 10 - Turquesa");
        adicionarAresta(4, "Capuava", "Mauá", "Linha 10 - Turquesa");
        adicionarAresta(4, "Mauá", "Guapituba", "Linha 10 - Turquesa");
        adicionarAresta(4, "Guapituba", "Ribeirão Pires", "Linha 10 - Turquesa");
        adicionarAresta(4, "Ribeirão Pires", "Rio Grande da Serra", "Linha 10 - Turquesa");

        // Linha 11 - Coral (Luz ↔ Estudantes)
        adicionarAresta(5, "Luz", "Brás", "Linha 11 - Coral");
        adicionarAresta(7, "Brás", "Tatuapé", "Linha 11 - Coral");
        adicionarAresta(5, "Tatuapé", "Corinthians-Itaquera", "Linha 11 - Coral");
        adicionarAresta(5, "Corinthians-Itaquera", "Dom Bosco", "Linha 11 - Coral");
        adicionarAresta(5, "Dom Bosco", "José Bonifácio", "Linha 11 - Coral");
        adicionarAresta(5, "José Bonifácio", "Guaianases", "Linha 11 - Coral");
        adicionarAresta(5, "Guaianases", "Antonio Gianetti Neto", "Linha 11 - Coral");
        adicionarAresta(5, "Antonio Gianetti Neto", "Ferraz de Vasconcelos", "Linha 11 - Coral");
        adicionarAresta(5, "Ferraz de Vasconcelos", "Poá", "Linha 11 - Coral");
        adicionarAresta(5, "Poá", "Suzano", "Linha 11 - Coral");
        adicionarAresta(5, "Suzano", "Jundiapeba", "Linha 11 - Coral");
        adicionarAresta(5, "Jundiapeba", "Braz Cubas", "Linha 11 - Coral");
        adicionarAresta(5, "Braz Cubas", "Mogi das Cruzes", "Linha 11 - Coral");
        adicionarAresta(5, "Mogi das Cruzes", "Estudantes", "Linha 11 - Coral");

        // Linha 12 - Safira (Brás ↔ Calmon Viana)
        adicionarAresta(4, "Brás", "Tatuapé", "Linha 12 - Safira");
        adicionarAresta(14, "Tatuapé", "Engenheiro Goulart", "Linha 12 - Safira");
        adicionarAresta(4, "Engenheiro Goulart", "USP Leste", "Linha 12 - Safira");
        adicionarAresta(4, "USP Leste", "Comendador Ermelino", "Linha 12 - Safira");
        adicionarAresta(4, "Comendador Ermelino", "São Miguel Paulista", "Linha 12 - Safira");
        adicionarAresta(4, "São Miguel Paulista", "Jardim Helena-Vila Mara", "Linha 12 - Safira");
        adicionarAresta(4, "Jardim Helena-Vila Mara", "Itaim Paulista", "Linha 12 - Safira");
        adicionarAresta(4, "Itaim Paulista", "Jardim Romano", "Linha 12 - Safira");
        adicionarAresta(4, "Jardim Romano", "Engenheiro Manoel Feio", "Linha 12 - Safira");
        adicionarAresta(4, "Engenheiro Manoel Feio", "Itaquaquecetuba", "Linha 12 - Safira");
        adicionarAresta(4, "Itaquaquecetuba", "Aracaré", "Linha 12 - Safira");
        adicionarAresta(4, "Aracaré", "Calmon Viana", "Linha 12 - Safira");

        // Linha 13 - Jade (Engenheiro Goulart ↔ Aeroporto-Guarulhos)
        adicionarAresta(7, "Engenheiro Goulart", "Guarulhos-Cecap", "Linha 13 - Jade");
        adicionarAresta(7, "Guarulhos-Cecap", "Aeroporto-Guarulhos", "Linha 13 - Jade");

    }

    public void adicionarAresta(int peso, String inicio, String fim, String linha) {
        Vertice verticeInicio = verticeRepository.findByDado(inicio);
        Vertice verticeFim = verticeRepository.findByDado(fim);
        if (verticeInicio != null && verticeFim != null) {
            Aresta aresta = new Aresta(peso, verticeInicio, verticeFim, linha);
            arestaRepository.save(aresta);

            // Adicionando aresta reversa (se necessário)
            Aresta arestaReversa = new Aresta(peso, verticeFim, verticeInicio, linha);
            arestaRepository.save(arestaReversa);
        }
    }

    public String DijkstraSem(String partida, String fim) {
        Vertice verticeInicio = verticeRepository.findByDado(partida);
        Vertice verticeFim = verticeRepository.findByDado(fim);

        if (verticeInicio == null || verticeFim == null) {
            return "Estação de partida ou chegada não encontrada.";
        }

        List<Vertice> vertices = verticeRepository.findAll();
        Map<Vertice, Integer> distancias = new HashMap<>();
        Map<Vertice, Vertice> predecessores = new HashMap<>();
        Set<Vertice> visitados = new HashSet<>();

        for (Vertice v : vertices) {
            distancias.put(v, Integer.MAX_VALUE);
            predecessores.put(v, null);
        }
        distancias.put(verticeInicio, 0);

        PriorityQueue<Vertice> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        fila.add(verticeInicio);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();
            if (!visitados.add(atual)) continue;

            for (Aresta aresta : atual.getArestasSaida()) {
                Vertice vizinho = aresta.getFim();
                int novaDistancia = distancias.get(atual) + aresta.getPeso();

                if (novaDistancia < distancias.get(vizinho)) {
                    distancias.put(vizinho, novaDistancia);
                    predecessores.put(vizinho, atual);
                    fila.add(vizinho);
                }
            }
        }

        if (distancias.get(verticeFim) == Integer.MAX_VALUE) {
            return "Caminho não encontrado.";
        }

        List<Vertice> caminho = new ArrayList<>();
        for (Vertice v = verticeFim; v != null; v = predecessores.get(v)) {
            caminho.add(0, v);
        }

        StringBuilder resultado = new StringBuilder("Caminho mais curto: ");
        for (int i = 0; i < caminho.size(); i++) {
            resultado.append(caminho.get(i).getDado());
            if (i < caminho.size() - 1) resultado.append(" -> ");
        }
        resultado.append("\nTempo médio do caminho: ").append(distancias.get(verticeFim)).append(" minutos.");

        return resultado.toString();
    }
}
