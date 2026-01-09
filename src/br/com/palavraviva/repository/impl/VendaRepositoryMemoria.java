package br.com.palavraviva.repository.impl;

import br.com.palavraviva.model.Venda;
import br.com.palavraviva.repository.VendaRepository;
import java.util.ArrayList;
import java.util.List;

public class VendaRepositoryMemoria implements VendaRepository {

    private final List<Venda> vendas = new ArrayList<>();
    private long proximoId = 1;

    @Override
    public void salvar(Venda venda) {
        if (venda.getId() == null) {
            venda.setId(proximoId++);
        }
        vendas.add(venda);
    }

    @Override
    public List<Venda> listarTodos() {
        return new ArrayList<>(vendas);
    }
}
