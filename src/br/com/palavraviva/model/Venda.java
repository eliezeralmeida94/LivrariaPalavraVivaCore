package br.com.palavraviva.model;

import java.time.LocalDate;

public class Venda {
    private Long id;
    private Long idLivro;
    private Long idCliente;
    private int quantidade;
    private double total;
    private LocalDate data;

    public Venda() {}

    public Venda(Long id, Long idLivro, Long idCliente, int quantidade, double total, LocalDate data) {
        this.id = id;
        this.idLivro = idLivro;
        this.idCliente = idCliente;
        this.quantidade = quantidade;
        this.total = total;
        this.data = data;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdLivro() { return idLivro; }
    public void setIdLivro(Long idLivro) { this.idLivro = idLivro; }

    public Long getIdCliente() { return idCliente; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", idLivro=" + idLivro +
                ", idCliente=" + idCliente +
                ", quantidade=" + quantidade +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}

