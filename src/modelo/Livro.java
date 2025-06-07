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
    public Livro(String titulo, String autor, String isbn, int anoPublicacao, String editora, int quantidadeExemplares) 
    {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.quantidadeExemplares = quantidadeExemplares;
        this.exemplaresDisponiveis = quantidadeExemplares;
    }
    
    

    // Getters
    public String getTitulo() 
    {
        return titulo;
    }

    public String getAutor() 
    {
        return autor;
    }

    public String getIsbn() 
    {
        return isbn;
    }

    public int getExemplaresDisponiveis() 
    {
        return exemplaresDisponiveis;
    }

    
    
    // Métodos 
    public boolean decrementarExemplar() 
    {
        if (this.exemplaresDisponiveis > 0) 
        {
            this.exemplaresDisponiveis--;
            return true;
        }
        return false;
    }

    public void incrementarExemplar() 
    {
        this.exemplaresDisponiveis++;
    }

    
    
    // Relatório
    public String toString() 
    {
        return "\n🕮 Título: " + titulo 
               + "\n🕮 Autor: " + autor 
               + "\n🕮 ISBN: " + isbn 
               + "\n🕮 Ano: " + anoPublicacao 
               + "\n🕮 Editora: " + editora 
               + "\n🕮 Total de exemplares: " + quantidadeExemplares 
               + "\n🕮 Exemplares disponíveis: " + exemplaresDisponiveis + "\n";
    }
}