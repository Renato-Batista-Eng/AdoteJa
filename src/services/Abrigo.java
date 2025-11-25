package services;

import entities.Animal;
import entities.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abrigo {

    Scanner scan = new Scanner(System.in);

    private List<Pet> petsDisponiveis = new ArrayList<>();
    private List<Animal> animaisList = new ArrayList<>();

    public List<Pet> getPetsDisponiveis() {
        return petsDisponiveis;
    }

    public List<Animal> getAnimaisList() {
        return animaisList;
    }

    public void registrarPet(Pet pet) {
        petsDisponiveis.add(pet);
        animaisList.add(pet);
    }

    public Pet buscarPetPorId(Long petId) {
        for(Animal animal : animaisList){
            if(animal.getId().equals(petId)){
                return (Pet) animal;
            }
        }
        return null;
    }

    public void atualizarPet() {

        System.out.print("Digite o ID do pet que deseja alterar dados: ");
        Long petId = scan.nextLong();

        Pet pet = buscarPetPorId(petId);

        if(pet != null) {
            System.out.print("Qual dado do pet você deseja alterar (nome, especie, idade, sexo) ? ");
            scan.nextLine();
            String editarDadoPet = scan.nextLine().toLowerCase();

            switch(editarDadoPet) {
                case "nome":
                    System.out.print("Digite o novo nome do pet: ");
                    String newPetNome = scan.nextLine();
                    pet.setNome(newPetNome);
                    System.out.println("\nNome atualizado com sucesso!");
                    break;

                case "especie":
                case "espécie":
                    System.out.print("Digite a nova espécie do pet: ");
                    String newPetEspecie = scan.next();
                    pet.setEspecie(newPetEspecie);
                    System.out.println("\nEspécie atualizada com sucesso!");
                    break;

                case "idade" :
                    System.out.print("Digite a nova idade do pet em meses: ");
                    int newPetIdade = scan.nextInt();
                    pet.setIdade(newPetIdade);
                    System.out.println("\nIdade atualizada com sucesso!");
                    break;

                case "sexo" :
                    System.out.print("Digite o novo sexo do pet (em meses): ");
                    String newPetSexo = scan.next();
                    pet.setSexo(newPetSexo);
                    System.out.println("\nSexo atualizado com sucesso!");
                    break;

                default:
                    System.out.println("Dado inválido!");
                    break;
            }

        } else {
            System.out.println("Pet não encontrado no banco de dados!");
        }

    }

}
