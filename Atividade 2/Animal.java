public class Animal {
    private String nome;
    private int fome;
    private int energia;
    private int felicidade;
    protected String especie;

    public Animal(String nome, String especie) {
        this.fome = 50;
        this.energia = 100;
        this.felicidade = 50;
        this.nome = nome;
        this.especie = especie;

    }

    public void alimentar(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade Negativa!!");
        } else {
            this.fome -= quantidade;

            if (this.fome < 0) {
                this.fome = 0;
            }

            System.out.println(nome + "foi Alimentado com " + quantidade + " unidades de comida.");

        }

    }

    public void brincar() {
        if (this.energia <= 20) {
            System.out.println("Animal com pouca energia, não pode brincar!");
        } else {
            this.felicidade += 10;
            this.energia -= 20;

            if (this.felicidade > 100 || this.energia >= 0) {
                this.felicidade = 100;
                this.energia = 0;

                System.out.println(nome + " está feliz!");
            }
        }
    }
}