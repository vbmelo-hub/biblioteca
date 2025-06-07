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
            return "\n\n✘ Erro: Livro com ISBN " + isbnLivro + " não encontrado. ✘\n";
        } 
        
        
        if (usuario == null) 
        {
            return "\n\n✘ Erro: Usuário com CPF " + cpfUsuario + " não encontrado. ✘\n";
        }
        
        
        if (livro.getExemplaresDisponiveis() <= 1) 
        {
            return "\n\n✘ Ops... Erro: Não é possível emprestar o livro '" + livro.getTitulo() + "'. Apenas 1 exemplar disponível. ✘\n";
        }
               

        if (livro.decrementarExemplar()) 
        {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(diasEmprestimo);
            
            String idEmprestimo = BDSimulado.gerarIdEmprestimo();
            Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucaoPrevista);
            BDSimulado.addEmprestimo(idEmprestimo, novoEmprestimo);
            return "\n\n✔ Empréstimo realizado com sucesso! ✔" + "\n\n" + novoEmprestimo.toString();
        } 
        
        else 
        {
            return "\n\n✘ Erro: Não há exemplares disponíveis do livro '" + livro.getTitulo() + "'. ✘\n";
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
            return "\n\n✘ Erro: Não há empréstimo ativo para o livro " + isbnLivro + " e usuário " + cpfUsuario + ". ✘\n";
        }

        Livro livroDevolvido = emprestimoParaDevolver.getLivro();
        livroDevolvido.incrementarExemplar();

        emprestimoParaDevolver.setDataDevolucaoReal(LocalDate.now());

        return "\n\n✔ Devolução do livro '" + livroDevolvido.getTitulo() + "' por '" + emprestimoParaDevolver.getUsuario().getNome() + "' registrada com sucesso! ✔\n";
    }

    
    
    // Livros emprestados
    public String listarLivrosEmprestados() {
        String relatorio = "\n\n•✦ ────── Livros Emprestados (Ativos)  ────── ✦•\n";
        boolean encontrado = false;
        for (Emprestimo emprestimo : BDSimulado.getEmprestimos().values()) {
            if (emprestimo.isEmprestimoAtivo()) {
                relatorio = relatorio + emprestimo.toString();
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "\n\n✘ Nenhum livro atualmente emprestado. ✘\n";
        }
        return relatorio;
    }

    
    
    // Livros disponiveis
    public String verificarLivrosDisponiveis() {
        String relatorio = "\n\n•✦ ────── Livros Disponíveis ────── ✦•\n";
        boolean encontrado = false;
        for (Livro livro : BDSimulado.getLivros().values()) {
            if (livro.getExemplaresDisponiveis() > 0) {
                relatorio = relatorio + "Título: " + livro.getTitulo() + " (ISBN: " + livro.getIsbn() 
                         + ") ➜ Exemplares disponíveis: " 
                         + livro.getExemplaresDisponiveis() + "\n•✦ ──────────────────────────────── ✦•\n";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "\n\n✘ Nenhum livro disponível no momento. ✘\n";
        }
        return relatorio;
    }

    
        
    // Histórico de Empréstimos
    public String listarHistoricoEmprestimos() {
        if (BDSimulado.getEmprestimos().isEmpty()) {
            return "✘ Nenhum histórico de empréstimo registrado. ✘\n";
        }
        String relatorio = "\n•✦ ────── Histórico de Empréstimos ────── ✦•\n";
        for (Emprestimo emprestimo : BDSimulado.getEmprestimos().values()) {
            relatorio = relatorio + emprestimo.toString() + "\n•✦ ───────────────────────────────────────── ✦•\n";
        }
        return relatorio;
    }
}