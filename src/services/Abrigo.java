package services;

import entities.Pet;

import java.util.ArrayList;
import java.util.List;

public class Abrigo {

    private List<Pet> petList = new ArrayList<>();

    public List<Pet> getPetList() {
        return petList;
    }

    public void registrarPet(Pet pet) {
        petList.add(pet);
    }

    public Pet buscarPetPorId(Long petId) {
        for(Pet pet : petList){
            if(pet.getId().equals(petId)){
                return pet;
            }
        }
        return null;
    }

}
