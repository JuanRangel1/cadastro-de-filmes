package com.example.FilmesCadastroJuan;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final List<Filme> filmes = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(4);

    public FilmeController() {
        filmes.add(new Filme(1L, "Interestelar", "Ficção Científica", 2014));
        filmes.add(new Filme(2L, "O Poderoso Chefão", "Drama", 1972));
        filmes.add(new Filme(3L, "Homem-Aranha: Sem Volta para Casa", "Ação", 2021));
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmes;
    }

    @GetMapping("/{id}")
    public Filme buscarFilme(@PathVariable Long id) {
        return filmes.stream()
                .filter(filme -> filme.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Filme cadastrarFilme(@RequestBody Filme filme) {
        filme.setId(proximoId.getAndIncrement());
        filmes.add(filme);
        return filme;
    }
}
