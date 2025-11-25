package entities;

public class Animal {

    private static Long ID = 1L;

    private Long id;
    private String nome;
    private String especie;
    private int idade;
    private String sexo;
    private Boolean status = false;

    public Animal() {}

    public Animal(String nome, String especie, int idade, String sexo) {
        this.id = ID++;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.sexo = sexo;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String exibirInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Espécie: ").append(especie).append("\n");
        sb.append("Idade: ").append(idade).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");

        return sb.toString();
    }

}
