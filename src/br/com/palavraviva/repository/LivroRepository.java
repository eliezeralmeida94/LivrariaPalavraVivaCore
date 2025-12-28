package br.com.palavraviva.repository;

import br.com.palavraviva.model.Livro;
import java.util.List;

public interface LivroRepository {
    void salvar(Livro livro);
    Livro buscarPorId(Long id);
    List<Livro> listarTodos();
}

