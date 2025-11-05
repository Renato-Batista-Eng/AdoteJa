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

    Adotante adotante = new Adotante();
    Pet pet = new Pet();

    public void adotarPet(Long adotanteId, Long petId) {
        adotante = adotanteService.buscarAdotantePorId(adotanteId);
        pet = abrigo.buscarPetPorId(petId);
        if(adotante != null && pet != null){
            adotante.addPet(pet);
            pet.setAdotante(adotante);
            abrigo.getPetList().remove(pet);
            System.out.println("Adoção realizada com sucesso");
            gerarComprovante();
        } else {
            System.out.println("Dados inválidos, verifique os IDs digitados e tente novamente!");
        }

    }

    public String gerarComprovante() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comprovante gerado").append("\n\n");
        sb.append(adotante.exibirInfo());
        sb.append(pet.exibirInfo());
        return sb.toString();
    }

}
