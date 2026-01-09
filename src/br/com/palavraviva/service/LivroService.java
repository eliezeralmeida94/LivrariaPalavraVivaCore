package br.com.palavraviva.service;

import br.com.palavraviva.exception.RegraNegocioException;
import br.com.palavraviva.model.Livro;
import br.com.palavraviva.repository.LivroRepository;
import java.util.List;

public class LivroService {

    private final LivroRepository repo;

    public LivroService(LivroRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Livro livro) throws RegraNegocioException {
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new RegraNegocioException("Título é obrigatório.");
        }
        if (livro.getPreco() < 0) {
            throw new RegraNegocioException("Preço não pode ser negativo.");
        }
        if (livro.getEstoque() < 0) {
            throw new RegraNegocioException("Estoque não pode ser negativo.");
        }
        repo.salvar(livro);
    }

    public Livro buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<Livro> listar() {
        return repo.listarTodos();
    }

    public void baixarEstoque(Long idLivro, int quantidade) throws RegraNegocioException {
        Livro livro = repo.buscarPorId(idLivro);
        if (livro == null) {
            throw new RegraNegocioException("Livro não encontrado.");
        }

        int novoEstoque = livro.getEstoque() - quantidade;
        if (novoEstoque < 0) {
            throw new RegraNegocioException("Estoque insuficiente.");
        }

        livro.setEstoque(novoEstoque);
        repo.salvar(livro);
    }
}
