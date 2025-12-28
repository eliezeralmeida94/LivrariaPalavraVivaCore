package br.com.palavraviva.repository.impl;

import br.com.palavraviva.model.Cliente;
import br.com.palavraviva.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria implements ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(proximoId++);
            clientes.add(cliente);
            return;
        }
        Cliente existente = buscarPorId(cliente.getId());
        if (existente != null) clientes.remove(existente);
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
}
