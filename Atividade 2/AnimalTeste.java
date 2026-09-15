import java.util.Scanner;

public class AnimalTeste {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("---> Cadastre seu animal <---");
        System.out.print("Digite o nome do animal: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a espécie do animal: ");
        String especie = scanner.nextLine();
        System.out.println("Seu Animal cadastrado com sucesso!");

        Animal animal = new Animal(nome, especie);

        int opcao;

        do {
            System.out.println("===> Menu <===");
            System.out.println("1 - Status do Bixinho");
            System.out.println("2 - Alimentar");
            System.out.println("3 - Brincar");
            System.out.println("4 - Dormir");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    animal.getStatus();
                    break;
                case 2:
                    System.out.print("Digite a quantidade de alimento: ");
                    int quantidade = scanner.nextInt();
                    animal.alimentar(quantidade);
                    break;
                case 3:
                    animal.brincar();
                    break;
                case 4:
                    animal.dormir();
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");

            }
        } while (opcao != 5);

        scanner.close();
    }
}       