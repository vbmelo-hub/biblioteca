package servico;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import repositorio.BDSimulado;

import java.time.LocalDate;
import java.util.Map;

public class ServicoEmprestimo {

	
	
	// Emprestimo
    public String realizarEmprestimo(String isbnLivro, String cpfUsuario, int diasEmprestimo) {
        Livro livro = BDSimulado.getLivros().get(isbnLivro);
        Usuario usuario = BDSimulado.getUsuarios().get(cpfUsuario);

        if (livro == null) 
        {
            return "✘ Erro: Livro com ISBN " + isbnLivro + " não encontrado. ✘";
        } 
        
        
        if (usuario == null) 
        {
            return "✘ Erro: Usuário com CPF " + cpfUsuario + " não encontrado. ✘";
        }
        
        
        if (livro.getExemplaresDisponiveis() <= 1) 
        {
            return "✘ Ops... Erro: Não é possível emprestar o livro '" + livro.getTitulo() + "'. Apenas 1 exemplar disponível. ✘";
        }
               

        if (livro.decrementarExemplar()) 
        {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(diasEmprestimo);
            
            String idEmprestimo = BDSimulado.gerarIdEmprestimo();
            Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucaoPrevista);
            BDSimulado.addEmprestimo(idEmprestimo, novoEmprestimo);
            return "Empréstimo realizado com sucesso! " + novoEmprestimo.toString();
        } 
        
        else 
        {
            return "✘ Erro: Não há exemplares disponíveis do livro '" + livro.getTitulo() + "'. ✘";
        }
    }

    
    
    // Devolução
    public String registrarDevolucao(String isbnLivro, String cpfUsuario) {
        Emprestimo emprestimoParaDevolver = null;

        for (Map.Entry<String, Emprestimo> entry : BDSimulado.getEmprestimos().entrySet()) {
            Emprestimo emp = entry.getValue();
            if (emp.isEmprestimoAtivo() && emp.getLivro().getIsbn().equals(isbnLivro) && emp.getUsuario().getCpf().equals(cpfUsuario)) {
                emprestimoParaDevolver = emp;
                break;
            }
        }

        if (emprestimoParaDevolver == null) {
            return "✘ Erro: Não há empréstimo ativo para o livro " + isbnLivro + " e usuário " + cpfUsuario + ". ✘";
        }

        Livro livroDevolvido = emprestimoParaDevolver.getLivro();
        livroDevolvido.incrementarExemplar();

        emprestimoParaDevolver.setDataDevolucaoReal(LocalDate.now());

        return "✔ Devolução do livro '" + livroDevolvido.getTitulo() + "' por '" + emprestimoParaDevolver.getUsuario().getNome() + "' registrada com sucesso! ✔";
    }

    
    
    // Livros emprestados
    public String listarLivrosEmprestados() {
        String relatorio = "•✦ ────── Livros Emprestados (Ativos)  ────── ✦•\n";
        boolean encontrado = false;
        for (Emprestimo emprestimo : BDSimulado.getEmprestimos().values()) {
            if (emprestimo.isEmprestimoAtivo()) {
                relatorio = relatorio + emprestimo.toString() + "────────────────────────────────────\n";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "✔ Nenhum livro atualmente emprestado. ✔";
        }
        return relatorio;
    }

    
    
    // Livros disponiveis
    public String verificarLivrosDisponiveis() {
        String relatorio = "•✦ ────── Livros Disponíveis ────── ✦•\n";
        boolean encontrado = false;
        for (Livro livro : BDSimulado.getLivros().values()) {
            if (livro.getExemplaresDisponiveis() > 0) {
                relatorio = relatorio + "Título: " + livro.getTitulo() +
                         " (ISBN: " + livro.getIsbn() +
                         ") ➜ Exemplares disponíveis: " + livro.getExemplaresDisponiveis() +
                         "\n────────────────────────────────────\n";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "✘ Nenhum livro disponível no momento. ✘";
        }
        return relatorio;
    }

    
        
    // Histórico de Empréstimos
    public String listarHistoricoEmprestimos() {
        if (BDSimulado.getEmprestimos().isEmpty()) {
            return "✘ Nenhum histórico de empréstimo registrado. ✘";
        }
        String relatorio = "•✦ ────── Histórico de Empréstimos ────── ✦•\n";
        for (Emprestimo emprestimo : BDSimulado.getEmprestimos().values()) {
            relatorio = relatorio + emprestimo.toString() + "\n────────────────────────────────────\n";
        }
        return relatorio;
    }
}