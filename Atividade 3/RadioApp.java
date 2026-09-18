import java.util.Scanner;

public class RadioApp {

    public static void main(String[] args) {

        RadioEstacoes.Musica[] forro = {
                new RadioEstacoes.Musica("Fim de Semana", "Kara Veia", "Forro", 354),
                new RadioEstacoes.Musica("Meu Sonho", "Tarcisio do Acordeon", "Forro", 391)
        };

        RadioEstacoes.Musica[] hiphop = {
                new RadioEstacoes.Musica("No piscar do olho", "Pumapjl", "HipHop", 358),
                new RadioEstacoes.Musica("Jesus chorou", "Racionais mc", "HipHop", 228)
        };

        RadioEstacoes.Musica[] funk = {
                new RadioEstacoes.Musica("Milionarios", "MC Hariel", "Funk", 328),
                new RadioEstacoes.Musica("Amassa a placa", "MC Kevin", "Funk", 288)
        };

        RadioEstacoes.Estacao[] estacoes = {
                new RadioEstacoes.Estacao("89.1 FM", "Forro", forro),
                new RadioEstacoes.Estacao("95.7 FM", "HipHop", hiphop),
                new RadioEstacoes.Estacao("157.7 FM", "Funk", funk)
        };

        RadioEstacoes radio = new RadioEstacoes(estacoes);

        Scanner scanner = new Scanner(System.in);

        int opcao;
        int incremento = 1;

        do {
            System.out.println("1 - Ligar / Desligar rádio");
            System.out.println("2 - Tocar / Pausar");
            System.out.println("3 - Aumentar volume");
            System.out.println("4 - Diminuir volume");
            System.out.println("5 - Trocar estação");
            System.out.println("6 - Próxima música");
            System.out.println("7 - Ver status");
            System.out.println("8 - Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    if (radio.isLigado()) {
                        radio.desligar();
                    } else {
                        radio.ligar();
                    }
                    break;

                case 2:
                    if (radio.isTocando()) {
                        radio.pausar();
                    } else {
                        radio.tocar();
                    }
                    break;

                case 3:
                    radio.aumentarVolume(incremento);
                    break;

                case 4:
                    radio.diminuirVolume(incremento);
                    break;

                case 5:

                    System.out.println("\nEstações disponíveis:");

                    for (int i = 0; i < estacoes.length; i++) {
                        System.out.println(
                                i + " - " +
                                        estacoes[i].frequencia +
                                        " (" +
                                        estacoes[i].genero +
                                        ")");
                    }

                    System.out.print("Escolha a estação: ");
                    int numeroEstacao = scanner.nextInt();

                    radio.trocarEstacao(numeroEstacao);
                    break;

                case 6:
                    radio.proximaMusica();
                    break;

                case 7:
                    System.out.println(radio.getStatus());
                    break;

                case 8:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 8);

        scanner.close();
    }
}