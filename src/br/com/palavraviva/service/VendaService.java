/**
 * Service responsável pelas regras de negócio de venda.
 * Centraliza validações e controle de estoque.
 */

package br.com.palavraviva.service;

import br.com.palavraviva.exception.RegraNegocioException;
import br.com.palavraviva.model.Cliente;
import br.com.palavraviva.model.Livro;
import br.com.palavraviva.model.Venda;
import br.com.palavraviva.repository.VendaRepository;

import java.time.LocalDate;
import java.util.List;

public class VendaService {

    private final VendaRepository vendaRepo;
    private final LivroService livroService;
    private final ClienteService clienteService;

    public VendaService(VendaRepository vendaRepo, LivroService livroService, ClienteService clienteService) {
        this.vendaRepo = vendaRepo;
        this.livroService = livroService;
        this.clienteService = clienteService;
    }

    public void realizarVenda(Long idLivro, Long idCliente, int quantidade) throws RegraNegocioException {

        if (quantidade <= 0) {
            throw new RegraNegocioException("Quantidade deve ser maior que zero.");
        }

        Livro livro = livroService.buscarPorId(idLivro);
        if (livro == null) {
            throw new RegraNegocioException("Livro não encontrado.");
        }

        Cliente cliente = clienteService.buscarPorId(idCliente);
        if (cliente == null) {
            throw new RegraNegocioException("Cliente não encontrado.");
        }

        // regra principal: baixa estoque
        livroService.baixarEstoque(idLivro, quantidade);

        double total = livro.getPreco() * quantidade;
        Venda venda = new Venda(null, idLivro, idCliente, quantidade, total, LocalDate.now());
        vendaRepo.salvar(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepo.listarTodos();
    }
}
