package modelo;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    // Construtor
    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = null; // Inicialmente nulo
    }

    // Getters
    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    // Setter para registrar a devolução
    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    // Método para verificar se o empréstimo está ativo (não devolvido)
    public boolean isEmprestimoAtivo() {
        return this.dataDevolucaoReal == null;
    }

    @Override
    public String toString() {
        String statusDevolucao = (dataDevolucaoReal == null) ? "Empréstimo Ativo" : "Devolvido em " + dataDevolucaoReal;
        return "--- Detalhes do Empréstimo ---\n" +
               "Livro: " + livro.getTitulo() + " (ISBN: " + livro.getIsbn() + ")\n" +
               "Usuário: " + usuario.getNome() + " (CPF: " + usuario.getCpf() + ")\n" +
               "Data do Empréstimo: " + dataEmprestimo + "\n" +
               "Data de Devolução Prevista: " + dataDevolucaoPrevista + "\n" +
               "Status: " + statusDevolucao;
    }
}