package modelo;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private String editora;
    private int quantidadeExemplares;
    private int exemplaresDisponiveis;
    
    // Construtor
    public Livro(String titulo, String autor, String isbn, int anoPublicacao, String editora, int quantidadeExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.quantidadeExemplares = quantidadeExemplares;
        this.exemplaresDisponiveis = quantidadeExemplares;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    // Métodos para gerenciar exemplares
    public boolean decrementarExemplar() {
        if (this.exemplaresDisponiveis > 0) {
            this.exemplaresDisponiveis--;
            return true;
        }
        return false;
    }

    public void incrementarExemplar() {
        this.exemplaresDisponiveis++;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               "\nAutor: " + autor +
               "\nISBN: " + isbn +
               "\nAno: " + anoPublicacao +
               "\nEditora: " + editora +
               "\nTotal de exemplares: " + quantidadeExemplares +
               "\nExemplares disponíveis: " + exemplaresDisponiveis;
    }
}