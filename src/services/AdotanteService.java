package services;

import entities.Adotante;
import entities.Endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdotanteService {

    Scanner scan = new Scanner(System.in);

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

    public void atualizarAdotante() {

        System.out.print("Digite o ID do adotante que deseja alterar dados: ");
        Long adotanteId = scan.nextLong();

        Adotante adotante = buscarAdotantePorId(adotanteId);

        if(adotante != null) {
            System.out.print("Qual dado do adotante você deseja alterar (nome, cpf, telefone, endereco) ? ");
            scan.nextLine();
            String editarDadoAdotante = scan.nextLine().toLowerCase();

            switch(editarDadoAdotante) {
                case "nome":
                    System.out.print("Digite o novo nome do adotante: ");
                    String newAdotanteNome = scan.nextLine();
                    adotante.setNome(newAdotanteNome);
                    System.out.println("\nNome atualizado com sucesso!");
                    break;

                case "cpf":
                    System.out.print("Digite o novo CPF do adotante: ");
                    String newAdotanteCpf = scan.next();
                    adotante.setCpf(newAdotanteCpf);
                    System.out.println("\nCPF atualizadao com sucesso!");
                    break;

                case "telefone" :
                    System.out.print("Digite o novo telefone do adotante: ");
                    String newAdotanteTelefone = scan.next();
                    adotante.setTelefone(newAdotanteTelefone);
                    System.out.println("\nTelefone atualizado com sucesso!");
                    break;

                case "endereco" :
                case "endereço" :
                    System.out.println("\n----- Agora preencha os dados do seu endereço ----- \n");
                    System.out.print("Digite o nome da rua: ");
                    String rua = scan.nextLine();
                    System.out.print("Digite o número da casa: ");
                    int numeroCasa = scan.nextInt();
                    System.out.print("Digite o nome do bairro: ");
                    scan.nextLine();
                    String bairro = scan.nextLine();
                    System.out.print("Digite o nome da cidade: ");
                    String cidade = scan.nextLine();
                    System.out.print("Digite o nome do estado: ");
                    String estado = scan.nextLine();
                    Endereco endereco = new Endereco(rua, numeroCasa, bairro, cidade, estado);
                    adotante.setEndereco(endereco);
                    System.out.println("\nEndereço atualizado com sucesso!");
                    break;

                default:
                    System.out.println("Dado inválido!");
                    break;
            }

        } else {
            System.out.println("Adotante não encontrado no banco de dados!");
        }

    }

}
