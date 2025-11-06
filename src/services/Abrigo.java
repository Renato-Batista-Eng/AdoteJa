package services;

import entities.Pet;

import java.util.ArrayList;
import java.util.List;

public class Abrigo {

    private List<Pet> petsDisponiveis = new ArrayList<>();
    private List<Pet> petsList = new ArrayList<>();

    public List<Pet> getPetsDisponiveis() {
        return petsDisponiveis;
    }

    public List<Pet> getPetsList() {
        return petsList;
    }

    public void registrarPet(Pet pet) {
        petsDisponiveis.add(pet);
        petsList.add(pet);
    }

    public Pet buscarPetPorId(Long petId) {
        for(Pet pet : petsDisponiveis){
            if(pet.getId().equals(petId)){
                return pet;
            }
        }
        return null;
    }

}
