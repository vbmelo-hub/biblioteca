package servico;

import modelo.Livro;
import repositorio.BDSimulado;

public class ServicoLivro {

    public String cadastrarLivro(String titulo, String autor, String isbn, int anoPublicacao, String editora, int quantidadeExemplares) {
        if (BDSimulado.getLivros().containsKey(isbn)) {
            return "Erro: Livro com ISBN " + isbn + " já cadastrado.";
        }
        Livro novoLivro = new Livro(titulo, autor, isbn, anoPublicacao, editora, quantidadeExemplares);
        BDSimulado.addLivro(isbn, novoLivro);
        return "Livro cadastrado com sucesso! [ISBN: " + isbn + "]";
    }

    public Livro consultarLivroPorIsbn(String isbn) {
        return BDSimulado.getLivros().get(isbn);
    }

    public String listarTodosLivros() {
        if (BDSimulado.getLivros().isEmpty()) {
            return "Nenhum livro cadastrado.";
        }
        String relatorio = "--- Lista de Livros ---\n";
        for (Livro livro : BDSimulado.getLivros().values()) {
            relatorio = relatorio + livro.toString() + "\n-------------------------\n";
        }
        return relatorio;
    }

    public String removerLivro(String isbn) {
        if (BDSimulado.removerLivro(isbn)) {
            return "Livro com ISBN " + isbn + " removido com sucesso.";
        }
        return "Erro: Livro com ISBN " + isbn + " não encontrado.";
    }

    public String buscarLivrosPorAutor(String autor) {
        String resultado = "--- Livros do Autor: " + autor + " ---\n";
        boolean encontrado = false;
        for (Livro livro : BDSimulado.getLivros().values()) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado = resultado + livro.toString() + "\n-------------------------\n";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "Nenhum livro encontrado para o autor: " + autor;
        }
        return resultado;
    }
}