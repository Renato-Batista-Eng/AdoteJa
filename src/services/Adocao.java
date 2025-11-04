package services;

import entities.Adotante;
import entities.Pet;

public class Adocao {

    private Abrigo abrigo;
    private AdotanteService adotanteService;

    public Adocao(Abrigo abrigo, AdotanteService adotanteService) {
        this.abrigo = abrigo;
        this.adotanteService = adotanteService;
    }

    public void adotarPet(Long adotanteId, Long petId) {
        Adotante adotante = adotanteService.buscarAdotantePorId(adotanteId);
        Pet pet = abrigo.buscarPetPorId(petId);
        if(adotante != null && pet != null){
            adotante.addPet(pet);
            pet.setAdotante(adotante);
            abrigo.getPetList().remove(pet);
            System.out.println("Adoção realizada com sucesso");
        } else {
            System.out.println("Dados inválidos, verifique os IDs digitados e tente novamente!");
        }

    }

    public String gerarComprovante() {
        return "Comprovante gerado";
    }

}
