package br.com.palavraviva.model;

public class Livro {

    private Long id;
    private String titulo;
    private String categoria;
    private int estoque;
    private double preco;

    public Livro() {}

    public Livro(Long id, String titulo, String categoria, int estoque, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.estoque = estoque;
        this.preco = preco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", estoque=" + estoque +
                ", preco=" + preco +
                '}';
    }
}

