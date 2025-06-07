package aplicacao;

import java.util.Scanner;

import modelo.Livro; 
import modelo.Usuario;
import servico.ServicoEmprestimo;
import servico.ServicoLivro;
import servico.ServicoUsuario;

public class Aplicacao {

	
	
	
	
    // Menu Principal
    public static void printMenu() {
        String menu = "·◈ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◈·"
        		+ "\n    ♨ 3ª AVALIAÇÃO N1 - ORIENTAÇÃO A OBJETOS EM JAVA - PROF.JONAS PONTES ♨\n"
        		+ "·◈ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◈·\n\n\n"
        		+ "·◈ ━━━━━━━━ ◆ MENU PRINCIPAL ◆ ━━━━━━━━ ◈·\n"
        		+ "↪ 1 - 【˖✧ Gerenciamento de Livros ✧˖】\n"
        		+ "↪ 2 - 【˖✧ Gerenciamento de Usuários ✧˖】\n"
        		+ "↪ 3 - 【˖✧ Gerenciamento de Empréstimos ✧˖】\n"
        		+ "↪ 0 - 【˖✧ Sair ✧˖】\n";
        System.out.println(menu);	
        System.out.print("➤ Escolha uma opção: ");
    }
    
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
                    System.out.println("\n\n❯❯❯❯ Você escolheu sair do sistema. ᶻ 𝗓 𐰁 \n❯❯❯❯ Até logo professor! >ᴗ<");
                    break;
                default:
                    System.out.println("\n✘ Oh não! Opção inválida! •︵• ✘\n"
                    		+ "Por favor, escolha uma opção válida (Dica: Deve ser um número entre 0 e 3...).\n\n"
                    		+ "·◈ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◈·");
                    break;
            }
        } while (opcao != 0);

        teclado.close();
    }
        
    
    
    
     
    // Menu de Livros
    private static void printMenuLivros() 
    {
        String menu = "\n\n·◈ ━━━━━━━━ ◆ GERENCIAMENTO DE LIVROS ◆ ━━━━━━━━ ◈·\n"
        		+ "↪ 1 - 【˖✧ Cadastrar livro ✧˖】\n"
        		+ "↪ 2 - 【˖✧ Consultar livro por ISBN ✧˖】\n"
        		+ "↪ 3 - 【˖✧ Listar todos os livros ✧˖】\n"
        		+ "↪ 4 - 【˖✧ Remover livro ✧˖】\n"
        		+ "↪ 5 - 【˖✧ Buscar livros por autor ✧˖】\n"
        		+ "↪ 0 - 【˖✧ Voltar ao Menu Principal ✧˖】\n";
        System.out.println(menu);
        System.out.print("➤ Escolha uma opção: ");
    }
    
    private static void menuLivros(Scanner teclado, ServicoLivro servicoLivro) {
        byte subOpcao;
        do 
        {
            printMenuLivros();
            subOpcao = Byte.parseByte(teclado.nextLine()); 

            switch (subOpcao) 
            {
                case 1:
                    System.out.print("\n➤ Título: ");
                    String titulo = teclado.nextLine();
                    System.out.print("➤ Autor: ");
                    String autor = teclado.nextLine();
                    System.out.print("➤ ISBN: ");
                    String isbn = teclado.nextLine();
                    System.out.print("➤ Ano de Publicação: ");
                    int anoPublicacao = Integer.parseInt(teclado.nextLine());
                    System.out.print("➤ Editora: ");
                    String editora = teclado.nextLine();
                    System.out.print("➤ Quantidade de Exemplares: ");
                    int quantidadeExemplares = Integer.parseInt(teclado.nextLine());
                    
                    System.out.println(servicoLivro.cadastrarLivro(titulo, autor, isbn, anoPublicacao, editora, quantidadeExemplares));
                    break;
                
                case 2: 
                    System.out.print("\n➤ ISBN do livro: ");
                    String isbnConsulta = teclado.nextLine();
                    Livro livroConsultado = servicoLivro.consultarLivroPorIsbn(isbnConsulta);
                    if (livroConsultado != null) {
                        System.out.println("\n\n✔ Livro Encontrado ✔\n" + livroConsultado);
                    } else {
                        System.out.println("\n✘ Livro com ISBN " + isbnConsulta + " não encontrado. ✘");
                    }
                    break;
                
                case 3: 
                    System.out.println(servicoLivro.listarTodosLivros());
                    break;
                
                case 4:
                    System.out.print("\n➤ ISBN do livro a ser removido: ");
                    String isbnRemover = teclado.nextLine();
                    System.out.println(servicoLivro.removerLivro(isbnRemover));
                    break;
                
                case 5: 
                    System.out.print("\n➤ Nome do autor: ");
                    String autorBusca = teclado.nextLine();
                    System.out.println(servicoLivro.buscarLivrosPorAutor(autorBusca));
                    break;
                
                case 0:
                    System.out.println("\n❯❯❯❯ Retornando ao Menu Principal...\n\n");
                    break;
                
                default:
                    System.out.println("\n✘ Opção inválida! ✘");
                    break;
            }
        } while (subOpcao != 0);
    }

    
    
    
    
    //Menu de Usuarios
    private static void printMenuUsuarios() {
        String menu = "\n\n·◈ ━━━━━━━━ ◆ GERENCIAMENTO DE USUÁRIOS ◆ ━━━━━━━━ ◈·\n"
        		+ "↪ 1 - 【˖✧ Cadastrar usuário ✧˖】\n"
        		+ "↪ 2 - 【˖✧ Consultar usuário por CPF ✧˖】\n"
        		+ "↪ 3 - 【˖✧ Listar todos os usuários ✧˖】\n"
        		+ "↪ 4 - 【˖✧ Remover usuário ✧˖】\n"
        		+ "↪ 0 - 【˖✧ Voltar ao Menu Principal ✧˖】\n";
        System.out.println(menu);
        System.out.print("➤ Escolha uma opção: ");
    }
    
    private static void menuUsuarios(Scanner teclado, ServicoUsuario servicoUsuario) 
    {
        byte subOpcao;
        do {
            printMenuUsuarios();
           
            subOpcao = Byte.parseByte(teclado.nextLine()); 

            switch (subOpcao) {
                case 1: 
                    System.out.print("\n➤ Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("➤ CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("➤ E-mail: ");
                    String email = teclado.nextLine();
                    System.out.println(servicoUsuario.cadastrarUsuario(nome, cpf, email));
                    break;
                    
                case 2: 
                    System.out.print("\n➤ CPF do usuário: ");
                    String cpfConsulta = teclado.nextLine();
                    Usuario usuarioConsultado = servicoUsuario.consultarUsuarioPorCpf(cpfConsulta);
                    if (usuarioConsultado != null) {
                        System.out.println("\n\n✔ Usuário Encontrado ✔\n" + usuarioConsultado);
                    } else {
                        System.out.println("\n\n✘ Usuário com CPF " + cpfConsulta + " não encontrado. ✘");
                    }
                    break;
                    
                case 3: 
                    System.out.println(servicoUsuario.listarTodosUsuarios());
                    break;
                    
                case 4:
                    System.out.print("\n➤ CPF do usuário a ser removido: ");
                    String cpfRemover = teclado.nextLine();
                    System.out.println(servicoUsuario.removerUsuario(cpfRemover));
                    break;
                    
                case 0:
                    System.out.println("\n❯❯❯❯ Retornando ao Menu Principal...\n\n");
                    break;
                    
                default:
                    System.out.println("\n✘ Opção inválida! ✘");
                    break;
            }
        } while (subOpcao != 0);
    }
    
    
    
    
    
    // Menu de Emprestimos
    private static void printMenuEmprestimos() {
        String menu = "\n\n·◈ ━━━━━━━━ ◆ GERENCIAMENTO DE EMPRÉSTIMOS ◆ ━━━━━━━━ ◈·\n"
        		+ "↪ 1 - 【˖✧ Realizar empréstimo ✧˖】\n"
        		+ "↪ 2 - 【˖✧ Registrar devolução ✧˖】\n"
        		+ "↪ 3 - 【˖✧ Listar todos os livros emprestados ✧˖】\n"
        		+ "↪ 4 - 【˖✧ Verificar quais livros estão disponíveis ✧˖】\n"
        		+ "↪ 5 - 【˖✧ Listar histórico de empréstimos ✧˖】\n"
        		+ "↪ 0 - 【˖✧ Voltar ao Menu Principal ✧˖】\n";
        System.out.println(menu);
        System.out.print("\n➤ Escolha uma opção: ");
    }
    
    private static void menuEmprestimos(Scanner teclado, ServicoEmprestimo servicoEmprestimo, ServicoLivro servicoLivro, ServicoUsuario servicoUsuario) {
        byte subOpcao;
        do {
            printMenuEmprestimos();
          
            subOpcao = Byte.parseByte(teclado.nextLine()); 

            switch (subOpcao) {
                case 1: 
                    System.out.print("\n➤ ISBN do Livro: ");
                    String isbnLivro = teclado.nextLine();
                    System.out.print("➤ CPF do Usuário: ");
                    String cpfUsuario = teclado.nextLine();
                    System.out.print("➤ Número de dias para empréstimo: ");
                    int diasEmprestimo = Integer.parseInt(teclado.nextLine());
                    if (diasEmprestimo <= 0) 
                    {
                        System.out.println("\n➤ O número de dias para empréstimo deve ser positivo.");
                        break; 
                    }
                    System.out.println(servicoEmprestimo.realizarEmprestimo(isbnLivro, cpfUsuario, diasEmprestimo));
                    break;
                    
                case 2: 
                    System.out.print("\n➤ ISBN do Livro a ser devolvido: ");
                    String isbnDevolucao = teclado.nextLine();
                    System.out.print("➤ CPF do Usuário que devolveu: ");
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
                    System.out.println("\n❯❯❯❯ Retornando ao Menu Principal...\n\n");
                    break;
                    
                default:
                    System.out.println("\n✘ Opção inválida! ✘");
                    break;
            }
        } while (subOpcao != 0);
    }

}