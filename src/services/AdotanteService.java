package services;

import entities.Adotante;

import java.util.ArrayList;
import java.util.List;

public class AdotanteService {

    private List<Adotante> adotanteList = new ArrayList<>();

    public List<Adotante> getAdotanteList() {
        return adotanteList;
    }

    public void registrarAdotante(Adotante adotante) {
        adotanteList.add(adotante);
    }

    public Adotante buscarAdotantePorId(Long adotanteId) {
        for(Adotante adotante : adotanteList){
            if(adotante.getId().equals(adotanteId)){
                return adotante;
            }
        }
        return null;
    }

}
