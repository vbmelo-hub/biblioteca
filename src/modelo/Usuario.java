package modelo;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;

    
    
    // Construtor
    public Usuario(String nome, String cpf, String email) 
    {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    
    
    // Getters utilizados
    public String getNome() 
    {
        return nome;
    }

    public String getCpf() 
    {
        return cpf;
    }

    
    
    // Relatório
    public String toString() 
    {
        return "🧍 Nome: " + nome 
               + "\n🧍 CPF: " + cpf 
               + "\n🧍 E-mail: " + email;
    }
}