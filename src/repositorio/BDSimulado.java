package repositorio;

import java.util.HashMap;
import modelo.Livro;
import modelo.Usuario;
import modelo.Emprestimo;

public class BDSimulado {
    private static HashMap<String, Livro> livros = new HashMap<>();
    private static HashMap<String, Usuario> usuarios = new HashMap<>();
    private static HashMap<String, Emprestimo> emprestimos = new HashMap<>(); 
    private static int contadorEmprestimos = 0;

    public static HashMap<String, Livro> getLivros() {
        return livros;
    }

    public static HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public static HashMap<String, Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    
    public static String gerarIdEmprestimo() {
        contadorEmprestimos++;
        return "EMP-" + contadorEmprestimos;
    }

    public static boolean addLivro(String isbn, Livro livro) {
        if (livros.get(isbn) == null) {
            livros.put(isbn, livro);
            return true;
        }
        return false;
    }

    public static boolean removerLivro(String isbn) {
        if (livros.containsKey(isbn)) {
            livros.remove(isbn);
            return true;
        }
        return false;
    }

    public static boolean addUsuario(String cpf, Usuario usuario) {
        if (usuarios.get(cpf) == null) {
            usuarios.put(cpf, usuario);
            return true;
        }
        return false;
    }

    public static boolean removerUsuario(String cpf) {
        if (usuarios.containsKey(cpf)) {
            usuarios.remove(cpf);
            return true;
        }
        return false;
    }

    public static boolean addEmprestimo(String idEmprestimo, Emprestimo emprestimo) {
        if (emprestimos.get(idEmprestimo) == null) {
            emprestimos.put(idEmprestimo, emprestimo);
            return true;
        }
        return false;
    }
}