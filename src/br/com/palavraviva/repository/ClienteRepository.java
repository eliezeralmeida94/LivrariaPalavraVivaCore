package br.com.palavraviva.repository;

import br.com.palavraviva.model.Cliente;
import java.util.List;

public interface ClienteRepository {
    void salvar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
}

