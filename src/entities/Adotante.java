package entities;

import java.util.ArrayList;
import java.util.List;

public class Adotante extends Pessoa {

    private List<Pet> pets = new ArrayList<>();

    public Adotante() {
        super();
    }

    public Adotante(String nome, String cpf, String telefone, Endereco endereco) {
        super(nome, cpf, telefone, endereco);
    }


    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String exibirInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.exibirInfo());
        String pet = (getPets().size() == 0) ? "Nenhum pet adotado" : getPets().toString();
        sb.append("Pet: ").append(pet).append("\n");

        return sb.toString();
    }

}
