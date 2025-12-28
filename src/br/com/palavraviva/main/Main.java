/**
 * Classe principal utilizada para testes manuais do core do sistema.
 * Simula cadastro de livros, clientes, realização de vendas
 * e atualização automática de estoque.
 */

package br.com.palavraviva.main;

import br.com.palavraviva.exception.RegraNegocioException;
import br.com.palavraviva.model.Cliente;
import br.com.palavraviva.model.Livro;
import br.com.palavraviva.repository.impl.ClienteRepositoryMemoria;
import br.com.palavraviva.repository.impl.LivroRepositoryMemoria;
import br.com.palavraviva.repository.impl.VendaRepositoryMemoria;
import br.com.palavraviva.service.ClienteService;
import br.com.palavraviva.service.LivroService;
import br.com.palavraviva.service.VendaService;

public class Main {

    public static void main(String[] args) {

        // Repositórios (memória)
        LivroRepositoryMemoria livroRepo = new LivroRepositoryMemoria();
        ClienteRepositoryMemoria clienteRepo = new ClienteRepositoryMemoria();
        VendaRepositoryMemoria vendaRepo = new VendaRepositoryMemoria();

        // Services
        LivroService livroService = new LivroService(livroRepo);
        ClienteService clienteService = new ClienteService(clienteRepo);
        VendaService vendaService = new VendaService(vendaRepo, livroService, clienteService);

        try {
            // Cadastro (teste)
            livroService.cadastrar(new Livro(null, "Bíblia de Estudo", "Evangélico", 10, 79.90));
            livroService.cadastrar(new Livro(null, "A Cruz e o Punhal", "Evangélico", 5, 59.90));
            clienteService.cadastrar(new Cliente(null, "João da Silva"));

            System.out.println("=== Livros ===");
            livroService.listar().forEach(System.out::println);

            System.out.println("\n=== Clientes ===");
            clienteService.listar().forEach(System.out::println);

            // Venda (teste)
            System.out.println("\n=== Realizando venda (Livro 1, Cliente 1, qtd 2) ===");
            vendaService.realizarVenda(1L, 1L, 2);

            System.out.println("\n=== Livros após venda (estoque atualizado) ===");
            livroService.listar().forEach(System.out::println);

            System.out.println("\n=== Vendas registradas ===");
            vendaService.listarVendas().forEach(System.out::println);

        } catch (RegraNegocioException e) {
            System.out.println("Erro de regra de negócio: " + e.getMessage());
        }
    }
}
