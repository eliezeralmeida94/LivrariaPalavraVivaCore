package br.com.palavraviva.repository;

import br.com.palavraviva.model.Venda;
import java.util.List;

public interface VendaRepository {
    void salvar(Venda venda);
    List<Venda> listarTodos();
}

