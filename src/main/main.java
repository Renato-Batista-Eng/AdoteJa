package main;

import entities.Adotante;
import entities.Endereco;
import entities.Pet;
import services.Abrigo;
import services.Adocao;
import services.AdotanteService;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Abrigo abrigo = new Abrigo();
        AdotanteService adotanteService = new AdotanteService();
        Adocao adocao = new Adocao(abrigo, adotanteService);
        Endereco endereco = new Endereco();

        System.out.println("""
                *********************** MENU ***********************
                1. Para se cadastrar como adotante.
                2. Mostrar adotante cadastrados.
                3. Cadastrar um pet.
                4. Mostrar pets cadastrados.
                5. Adotar um pet.
                0. Para sair.
                """);

        System.out.print("O que deseja fazer? ");
        int opcao = scan.nextInt();
        scan.nextLine();

        while(opcao != 0) {

            switch (opcao) {
                case 1:
                    System.out.print("Digite seu nome completo: ");
                    String adotanteNome = scan.nextLine();
                    System.out.print("Digite seu cpf: ");
                    String cpf = scan.next();
                    System.out.print("Digite seu telefone: ");
                    String telefone = scan.next();
                    System.out.println("\n----- Agora preencha os dados do seu endereço ----- \n");
                    scan.nextLine();
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
                    endereco = new Endereco(rua, numeroCasa, bairro, cidade, estado);
                    Adotante adotante = new Adotante(adotanteNome, cpf, telefone, endereco);
                    adotanteService.registrarAdotante(adotante);
                    break;

                case 2:
                    if(adotanteService.getAdotanteList().size() == 0) {
                        System.out.println("Nenhum adotante cadastrado até o momento");
                        break;
                    }

                    System.out.println("Lista de adotantes cadastrados\n--------------------");
                    for(Adotante a : adotanteService.getAdotanteList()) {
                        System.out.println(a.exibirInfo());
                        System.out.println("--------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do pet: ");
                    String petNome = scan.nextLine();
                    System.out.print("Digite sua espécie do pet: ");
                    String petEspecie = scan.nextLine();
                    System.out.print("Digite a idade do pet em meses: ");
                    int petIdade = scan.nextInt();
                    System.out.print("Digite o sexo do pet: ");
                    String petSexo = scan.next();
                    Pet pet = new Pet(petNome, petEspecie, petIdade, petSexo, null);
                    abrigo.registrarPet(pet);
                    break;

                case 4:
                    if(abrigo.getPetList().size() == 0) {
                        System.out.println("Não temos nenhum pet cadastrado no momento");
                    } else {
                        System.out.println("Lista de pets disponíveis para adoção\n--------------------");
                        for(Pet p : abrigo.getPetList()) {
                            System.out.println(p.exibirInfo());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    if(abrigo.getPetList().isEmpty()) {
                        System.out.println("Nenhum pet disponivel para adoção no momento");
                        break;
                    }

                    System.out.print("Digite o id do adotante: ");
                    Long adotanteId = scan.nextLong();

                    System.out.print("Agora digite o id do pet que deseja adotar: ");
                    Long petId = scan.nextLong();

                    adocao.adotarPet(adotanteId, petId);

            }

            System.out.println("""
                
                *********************** MENU ***********************
                1. Para se cadastrar como adotante.
                2. Mostrar adotante cadastrados.
                3. Cadastrar um pet.
                4. Mostrar pets disponíveis para adoção.
                5. Adotar um pet.
                0. Para sair.
                
                """);

            System.out.print("O que deseja fazer? ");
            opcao = scan.nextInt();
            scan.nextLine();
        }

    }

}
