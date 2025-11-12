package entities;

public class Pet {

    private static Long ID = 1L;

    private Long id;
    private String nome;
    private String especie;
    private int idade;
    private String sexo;
    private Boolean status = false;

    private Adotante adotante;

    public Pet() {}

    public Pet(String nome, String especie, int idade, String sexo, Adotante adotante) {
        this.id = ID++;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.sexo = sexo;
        this.adotante = adotante;
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

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
        this.status = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Espécie: ").append(especie).append("\n");
        sb.append("Idade: ").append(idade).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");

        String pet = (getAdotante() != null) ? "Adotado por " + getAdotante().getNome() : "Este pet ainda não foi adotado";
        sb.append("Status: ").append(pet).append("\n");

        return sb.toString();
    }

    public String exibirInfo() {
        return  toString();
    }

}