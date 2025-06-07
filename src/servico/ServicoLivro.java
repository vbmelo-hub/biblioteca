package servico;

import modelo.Livro;
import repositorio.BDSimulado;

public class ServicoLivro {

    public String cadastrarLivro(String titulo, String autor, String isbn, int anoPublicacao, String editora, int quantidadeExemplares) {
        if (BDSimulado.getLivros().containsKey(isbn)) {
            return "\n\n✘ Erro: Livro com ISBN " + isbn + " já cadastrado. ✘\n";
        }
        Livro novoLivro = new Livro(titulo, autor, isbn, anoPublicacao, editora, quantidadeExemplares);
        BDSimulado.addLivro(isbn, novoLivro);
        return "\n\n✔ Livro cadastrado com sucesso! [ISBN: " + isbn + "] ✔\n";
    }

    public Livro consultarLivroPorIsbn(String isbn) {
        return BDSimulado.getLivros().get(isbn);
    }

    public String listarTodosLivros() {
        if (BDSimulado.getLivros().isEmpty()) {
            return "\n\n✘ Nenhum livro cadastrado. ✘\n";
        }
        String relatorio = "\n\n•✦ ────── Lista de Livros ────── ✦•\n";
        for (Livro livro : BDSimulado.getLivros().values()) {
            relatorio = relatorio + livro.toString() + "\n•✦ ────────────────────────────── ✦•\n";
        }
        return relatorio;
    }

    public String removerLivro(String isbn) {
        if (BDSimulado.removerLivro(isbn)) {
            return "\n\n✔ Livro com ISBN " + isbn + " removido com sucesso. ✔\n";
        }
        return "\n\n✘ Erro: Livro com ISBN " + isbn + " não encontrado. ✘\n";
    }

    public String buscarLivrosPorAutor(String autor) {
        String resultado = "\n\n•✦ ────── Livros do Autor: " + autor + " ────── ✦•\n";
        boolean encontrado = false;
        for (Livro livro : BDSimulado.getLivros().values()) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado = resultado + livro.toString() + "\n";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "\n\n✘ Nenhum livro encontrado para o autor: " + autor + " ✘\n";
        }
        return resultado;
    }
}