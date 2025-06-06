package servico;

import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoUsuario {

    public String cadastrarUsuario(String nome, String cpf, String email) {
        if (BDSimulado.getUsuarios().containsKey(cpf)) {
            return "✘ Erro: Usuário com CPF " + cpf + " já cadastrado. ✘";
        }
        Usuario novoUsuario = new Usuario(nome, cpf, email);
        BDSimulado.addUsuario(cpf, novoUsuario);
        return "✔ Usuário cadastrado com sucesso! [CPF: " + cpf + "] ✔";
    }

    public Usuario consultarUsuarioPorCpf(String cpf) {
        return BDSimulado.getUsuarios().get(cpf);
    }

    public String listarTodosUsuarios() {
        if (BDSimulado.getUsuarios().isEmpty()) {
            return "✘ Nenhum usuário cadastrado. ✘";
        }
        String relatorio = "•✦ ────── Lista de Usuários ────── ✦•\n";
        for (Usuario usuario : BDSimulado.getUsuarios().values()) {
            relatorio = relatorio + usuario.toString() + "\n────────────────────────────────────\n";
        }
        return relatorio;
    }

    public String removerUsuario(String cpf) {
        if (BDSimulado.removerUsuario(cpf)) {
            return "✔ Usuário com CPF " + cpf + " removido com sucesso. ✔";
        }
        return "✘ Erro: Usuário com CPF " + cpf + " não encontrado. ✘";
    }
}