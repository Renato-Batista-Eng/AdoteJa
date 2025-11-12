package entities;

public abstract class Pessoa {

    private static Long ID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    public Pessoa(){
    }

    public Pessoa(String nome, String cpf, String telefone, Endereco endereco) {
        this.id = ID++;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String exibirInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("----- Endereço ----- \n").append(endereco).append("\n");

        return sb.toString();
    }

}
