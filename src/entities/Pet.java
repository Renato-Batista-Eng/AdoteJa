package entities;

public class Pet extends Animal {

    private Adotante adotante;

    public Pet() {}

    public Pet(String nome, String especie, int idade, String sexo, Adotante adotante) {
        super(nome, especie, idade, sexo);
        this.adotante = adotante;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
        setStatus(true);
    }

    @Override
    public String exibirInfo() {
        return toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.exibirInfo());
        String adotante = (getAdotante() != null) ? "Adotado por " + getAdotante().getNome() : "Este pet ainda não foi adotado";
        sb.append("Status: ").append(adotante).append("\n");

        return sb.toString();
    }

}