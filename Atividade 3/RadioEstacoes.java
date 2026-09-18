public class RadioEstacoes {

    private Estacao[] estacoes;
    private int estacaoAtual;
    private int musicaAtual;
    private int volume;
    private boolean ligado;
    private boolean tocando;

    public RadioEstacoes(Estacao[] estacoes) {
        volume = 50;
        ligado = false;
        estacaoAtual = 0;
        musicaAtual = 0;

    }

    public static  class Musica {
        public String titulo;
        public String artista;
        public String genero;
        private int duracaoSegundos;

        public Musica(String titulo, String artista, String genero, int duracaoSegundos) {
            this.titulo = titulo;
            this.artista = artista;
            this.genero = genero;
            this.duracaoSegundos = duracaoSegundos;
        }

        public String getDuracaoFormatada() {
            int minutos = duracaoSegundos / 60;
            int segundos = duracaoSegundos % 60;

            return String.format("%02d:%02d", minutos, segundos);
        }
    }

    public static class Estacao {
        public String frequencia;
        public String genero;
        public Musica[] playlist;

        public Estacao(String frequencia, String genero, Musica[] playlist) {
            this.frequencia = frequencia;
            this.genero = genero;
            this.playlist = playlist;
        }
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("Rádio ligado.");
    }

    public void desligar() {
        ligado = false;
        tocando = false;

    }

    public void tocar() {
        if (!ligado) {
            System.out.println("Ligue o rádio");
            return;
        }

        tocando = true;

        Musica musica = estacoes[estacaoAtual].playlist[musicaAtual];

        System.out.println("Titulo: " + musica.titulo);
        System.out.println("Artista: " + musica.artista);
        System.out.println("Duração: " + musica.getDuracaoFormatada());
    }

    public void pausar() {
        if (!ligado) {
            System.out.println("Radio Desligado!");
        } else if (!tocando) {
            System.out.println("Já esta pausado!");
        } else {
            tocando = false;
            System.out.println("Rádio pausada!");
        }
    }

    public void aumentarVolume(int incremento) {
        if (incremento < 0) {
            System.out.println("Ação não permetida!");
        } else {
            volume += incremento;
        }
        if (volume > 100) {
            volume = 100;
        }
    }

    public void diminuirVolume(int incremento) {
        if (incremento < 0) {
            System.out.println("Ação não permetida!");
        } else {
            volume -= incremento;
        }
        if (volume > 100) {
            volume = 100;
        }

    }

    public void trocarEstacao(int numeroEstacao) {
        if (numeroEstacao < 0 || numeroEstacao >= estacoes.length) {
            System.out.println("Estação inválida!");
            return;
        }

        estacaoAtual = numeroEstacao;
        musicaAtual = 0;

        if (tocando) {
            tocar();
        }
    }

    public void proximaMusica() {
        if (!ligado) {
            System.out.println("É necessário ligar o rádio.");
            return;
        }

        Musica[] playlistAtual = estacoes[estacaoAtual].playlist;

        musicaAtual = (musicaAtual + 1) % playlistAtual.length;

        tocar();
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append("Estado: ");
        sb.append(ligado ? "Ligado" : "Desligado");
        sb.append("\n");

        sb.append("Volume: ").append(volume).append("\n");

        if (estacoes != null && estacoes.length > 0) {
            Estacao estacao = estacoes[estacaoAtual];

            sb.append("Estação: ").append(estacao.frequencia).append("\n");
            sb.append("Gênero: ").append(estacao.genero).append("\n");

            Musica musica = estacao.playlist[musicaAtual];

            sb.append("Música: ");

            if (tocando) {
                sb.append(musica.titulo)
                        .append(" - ")
                        .append(musica.artista);
            } else {
                sb.append("Pausada");
            }
        }

        return sb.toString();
    }

    public boolean isLigado() {
        return ligado;
    }

    public boolean isTocando() {
        return tocando;
    }
}