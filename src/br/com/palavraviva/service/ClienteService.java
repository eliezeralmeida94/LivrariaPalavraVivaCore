package br.com.palavraviva.service;

import br.com.palavraviva.exception.RegraNegocioException;
import br.com.palavraviva.model.Cliente;
import br.com.palavraviva.repository.ClienteRepository;
import java.util.List;

public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(Cliente cliente) throws RegraNegocioException {
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new RegraNegocioException("Nome do cliente é obrigatório.");
        }
        repo.salvar(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repo.buscarPorId(id);
    }

    public List<Cliente> listar() {
        return repo.listarTodos();
    }
}
