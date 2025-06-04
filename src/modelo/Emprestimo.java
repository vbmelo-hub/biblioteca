package modelo;

import java.time.LocalDate;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	public Emprestimo(Livro livro, Usuario usuario) {
		this.livro = livro;
		this.usuario = usuario;
		this.dataEmprestimo = LocalDate.now();
	}
	
	public Livro getLivro() {return livro;}
	public Usuario getUsuario() {return usuario;}
	public LocalDate getDataEmprestimo() {return dataEmprestimo;}
	public LocalDate getDataDevolucao() {return dataDevolucao;}
	
	public void devolver() {
		this.dataDevolucao = LocalDate.now();
	}
	
	public boolean isDevolvido() {
		return dataDevolucao != null;
	}
	
	@Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + " | Usuário: " + usuario.getCpf() + " | Emprestado em: " + dataEmprestimo + (isDevolvido() ? " | Devolvido em: " + dataDevolucao : " | Em aberto");
    }
}
