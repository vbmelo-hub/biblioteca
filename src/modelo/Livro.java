package modelo;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private int ano;
	private String editora;
	private int qtdExemplar;
	
public Livro(String titulo, String autor, String isbn, int ano, String editora, int qtdExemplar) {
	this.titulo = titulo;
	this.autor = autor;
	this.isbn = isbn;
	this.ano = ano;
	this.editora = editora;
	this.qtdExemplar = qtdExemplar;
}
public String getIsbn() {return isbn;}
public String getAutor() {return autor;}
public String getTitulo( ) {return titulo;}
public int getQtdExemplar() {return qtdExemplar;}

public void setQtdExemplar(int qtdExemplar) {this.qtdExemplar = qtdExemplar;}
@Override
public String toString() {
    return titulo + " | " + autor + " | ISBN: " + isbn + " | Ano: " + ano + " | Editora: " + editora + " | Qtde: " + qtdExemplar;
}
}