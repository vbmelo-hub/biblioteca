package aplicacao;

import java.time.LocalDate;
import java.util.Scanner;

import modelo.Livro; 
import modelo.Usuario;
import servico.ServicoEmprestimo;
import servico.ServicoLivro;
import servico.ServicoUsuario;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ServicoLivro servicoLivro = new ServicoLivro();
        ServicoUsuario servicoUsuario = new ServicoUsuario();
        ServicoEmprestimo servicoEmprestimo = new ServicoEmprestimo();
        byte opcao;

        do {
            printMenu();
            opcao = Byte.parseByte(teclado.nextLine()); 

            switch (opcao) {
                case 1: 
                    menuLivros(teclado, servicoLivro);
                    break;
                case 2: 
                    menuUsuarios(teclado, servicoUsuario);
                    break;
                case 3: 
                    menuEmprestimos(teclado, servicoEmprestimo, servicoLivro, servicoUsuario);
                    break;
                case 0:
                    System.out.println("Você escolheu sair do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);

        teclado.close();
    }

    public static void printMenu() {
        String menu = "\n--- MENU PRINCIPAL DA BIBLIOTECA ---\n";
        menu = menu + "1 - Gerenciamento de Livros\n";
        menu = menu + "2 - Gerenciamento de Usuários\n";
        menu = menu + "3 - Gerenciamento de Empréstimos\n";
        menu = menu + "0 - Sair\n";
        System.out.println(menu);
        System.out.print("Escolha uma opção: ");
    }

    private static void menuLivros(Scanner teclado, ServicoLivro servicoLivro) {
        byte subOpcao;
        do {
            printMenuLivros();
            subOpcao = Byte.parseByte(teclado.nextLine()); 

            switch (subOpcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = teclado.nextLine();
                    System.out.print("Autor: ");
                    String autor = teclado.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = teclado.nextLine();
                    System.out.print("Ano de Publicação: ");
      
                    int anoPublicacao = Integer.parseInt(teclado.nextLine());
                   
                    System.out.print("Editora: ");
                    String editora = teclado.nextLine();
                    System.out.print("Quantidade de Exemplares: ");
            
                    int quantidadeExemplares = Integer.parseInt(teclado.nextLine());
                    
                    System.out.println(servicoLivro.cadastrarLivro(titulo, autor, isbn, anoPublicacao, editora, quantidadeExemplares));
                    break;
                case 2: 
                    System.out.print("ISBN do livro: ");
                    String isbnConsulta = teclado.nextLine();
                    Livro livroConsultado = servicoLivro.consultarLivroPorIsbn(isbnConsulta);
                    if (livroConsultado != null) {
                        System.out.println("--- Livro Encontrado ---\n" + livroConsultado);
                    } else {
                        System.out.println("Livro com ISBN " + isbnConsulta + " não encontrado.");
                    }
                    break;
                case 3: 
                    System.out.println(servicoLivro.listarTodosLivros());
                    break;
                case 4:
                    System.out.print("ISBN do livro a ser removido: ");
                    String isbnRemover = teclado.nextLine();
                    System.out.println(servicoLivro.removerLivro(isbnRemover));
                    break;
                case 5: 
                    System.out.print("Nome do autor: ");
                    String autorBusca = teclado.nextLine();
                    System.out.println(servicoLivro.buscarLivrosPorAutor(autorBusca));
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (subOpcao != 0);
    }

    private static void printMenuLivros() {
        String menu = "\n--- GERENCIAMENTO DE LIVROS ---\n";
        menu = menu + "1 - Cadastrar livro\n";
        menu = menu + "2 - Consultar livro por ISBN\n";
        menu = menu + "3 - Listar todos os livros\n";
        menu = menu + "4 - Remover livro\n";
        menu = menu + "5 - Buscar livros por autor\n";
        menu = menu + "0 - Voltar ao Menu Principal\n";
        System.out.println(menu);
        System.out.print("Escolha uma opção: ");
    }

    private static void menuUsuarios(Scanner teclado, ServicoUsuario servicoUsuario) {
        byte subOpcao;
        do {
            printMenuUsuarios();
           
            subOpcao = Byte.parseByte(teclado.nextLine()); 

            switch (subOpcao) {
                case 1: 
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("E-mail: ");
                    String email = teclado.nextLine();
                    System.out.println(servicoUsuario.cadastrarUsuario(nome, cpf, email));
                    break;
                case 2: 
                    System.out.print("CPF do usuário: ");
                    String cpfConsulta = teclado.nextLine();
                    Usuario usuarioConsultado = servicoUsuario.consultarUsuarioPorCpf(cpfConsulta);
                    if (usuarioConsultado != null) {
                        System.out.println("--- Usuário Encontrado ---\n" + usuarioConsultado);
                    } else {
                        System.out.println("Usuário com CPF " + cpfConsulta + " não encontrado.");
                    }
                    break;
                case 3: 
                    System.out.println(servicoUsuario.listarTodosUsuarios());
                    break;
                case 4:
                    System.out.print("CPF do usuário a ser removido: ");
                    String cpfRemover = teclado.nextLine();
                    System.out.println(servicoUsuario.removerUsuario(cpfRemover));
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (subOpcao != 0);
    }

    private static void printMenuUsuarios() {
        String menu = "\n--- GERENCIAMENTO DE USUÁRIOS ---\n";
        menu = menu + "1 - Cadastrar usuário\n";
        menu = menu + "2 - Consultar usuário por CPF\n";
        menu = menu + "3 - Listar todos os usuários\n";
        menu = menu + "4 - Remover usuário\n";
        menu = menu + "0 - Voltar ao Menu Principal\n";
        System.out.println(menu);
        System.out.print("Escolha uma opção: ");
    }

    private static void menuEmprestimos(Scanner teclado, ServicoEmprestimo servicoEmprestimo, ServicoLivro servicoLivro, ServicoUsuario servicoUsuario) {
        byte subOpcao;
        do {
            printMenuEmprestimos();
          
            subOpcao = Byte.parseByte(teclado.nextLine()); 

            switch (subOpcao) {
                case 1: 
                    System.out.print("ISBN do Livro: ");
                    String isbnLivro = teclado.nextLine();
                    System.out.print("CPF do Usuário: ");
                    String cpfUsuario = teclado.nextLine();
                    System.out.print("Número de dias para empréstimo: ");
                   
                    int diasEmprestimo = Integer.parseInt(teclado.nextLine());
                    if (diasEmprestimo <= 0) {
                        System.out.println("O número de dias para empréstimo deve ser positivo.");
                        break; 
                    }
                    System.out.println(servicoEmprestimo.realizarEmprestimo(isbnLivro, cpfUsuario, diasEmprestimo));
                    break;
                case 2: 
                    System.out.print("ISBN do Livro a ser devolvido: ");
                    String isbnDevolucao = teclado.nextLine();
                    System.out.print("CPF do Usuário que devolveu: ");
                    String cpfDevolucao = teclado.nextLine();
                    System.out.println(servicoEmprestimo.registrarDevolucao(isbnDevolucao, cpfDevolucao));
                    break;
                case 3: 
                    System.out.println(servicoEmprestimo.listarLivrosEmprestados());
                    break;
                case 4: 
                    System.out.println(servicoEmprestimo.verificarLivrosDisponiveis());
                    break;
                case 5: 
                    System.out.println(servicoEmprestimo.listarHistoricoEmprestimos());
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (subOpcao != 0);
    }
    // Testando github
    private static void printMenuEmprestimos() {
        String menu = "\n--- GERENCIAMENTO DE EMPRÉSTIMOS ---\n";
        menu = menu + "1 - Realizar empréstimo\n";
        menu = menu + "2 - Registrar devolução\n";
        menu = menu + "3 - Listar todos os livros emprestados\n";
        menu = menu + "4 - Verificar quais livros estão disponíveis\n";
        menu = menu + "5 - Listar histórico de empréstimos\n";
        menu = menu + "0 - Voltar ao Menu Principal\n";
        System.out.println(menu);
        System.out.print("Escolha uma opção: ");
    }
}