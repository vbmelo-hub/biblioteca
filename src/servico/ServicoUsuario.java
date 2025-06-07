package servico;

import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoUsuario {

    public String cadastrarUsuario(String nome, String cpf, String email) {
        if (BDSimulado.getUsuarios().containsKey(cpf)) {
            return "\n\n✘ Erro: Usuário com CPF " + cpf + " já cadastrado. ✘\n";
        }
        Usuario novoUsuario = new Usuario(nome, cpf, email);
        BDSimulado.addUsuario(cpf, novoUsuario);
        return "\n\n✔ Usuário cadastrado com sucesso! [CPF: " + cpf + "] ✔\n";
    }

    public Usuario consultarUsuarioPorCpf(String cpf) {
        return BDSimulado.getUsuarios().get(cpf);
    }

    public String listarTodosUsuarios() {
        if (BDSimulado.getUsuarios().isEmpty()) {
            return "\n\n✘ Nenhum usuário cadastrado. ✘";
        }
        String relatorio = "\n\n•✦ ────── Lista de Usuários ────── ✦•\n\n";
        for (Usuario usuario : BDSimulado.getUsuarios().values()) {
            relatorio = relatorio + usuario.toString() + "\n•✦ ─────────────────────────────── ✦•\n";
        }
        return relatorio;
    }

    public String removerUsuario(String cpf) {
        if (BDSimulado.removerUsuario(cpf)) {
            return "\n\n✔ Usuário com CPF " + cpf + " removido com sucesso. ✔\n";
        }
        return "\n\n✘ Erro: Usuário com CPF " + cpf + " não encontrado. ✘\n";
    }
}