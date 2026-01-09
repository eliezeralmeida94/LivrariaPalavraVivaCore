package br.com.palavraviva.repository.impl;

import br.com.palavraviva.model.Livro;
import br.com.palavraviva.repository.LivroRepository;
import java.util.ArrayList;
import java.util.List;

public class LivroRepositoryMemoria implements LivroRepository {

    private final List<Livro> livros = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public void salvar(Livro livro) {
        if (livro.getId() == null) {
            livro.setId(proximoId++);
            livros.add(livro);
            return;
        }

        // Atualização simples
        Livro existente = buscarPorId(livro.getId());
        if (existente != null) {
            livros.remove(existente);
        }
        livros.add(livro);
    }

    @Override
    public Livro buscarPorId(Long id) {
        for (Livro l : livros) {
            if (l.getId().equals(id)) return l;
        }
        return null;
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }
}

