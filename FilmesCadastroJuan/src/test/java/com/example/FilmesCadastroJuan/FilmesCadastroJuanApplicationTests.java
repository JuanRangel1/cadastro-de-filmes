package com.example.FilmesCadastroJuan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FilmesCadastroJuanApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveListarTresFilmesIniciais() {
        Filme[] filmes = restTemplate.getForObject("/filmes", Filme[].class);
        assertEquals(3, filmes.length);
    }
}
