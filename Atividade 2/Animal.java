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

            System.out.println(nome + " foi Alimentado com " + quantidade + " unidades de comida.");

        }
        passarTempo();
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
        passarTempo();
    }

    public void dormir() {
        energia = 100;
        fome += 25;

        if (fome > 100) {
            fome = 100;
        }

        System.out.println(nome + " Dormiu!!");

        passarTempo();
    }

    protected void passarTempo() {
        fome += 5;
        energia -= 3;

        if (fome <= 80) {
            felicidade -= 10;
        }
        if (energia <= 10) {
            felicidade -= 5;
        }

        if (fome > 100) {
            fome = 100;
        }
        if (energia < 0) {
            energia = 0;
        }
    }

    public void getStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Fome: " + fome);
        System.out.println("Energia: " + energia);
        System.out.println("Felicidade: " + felicidade);

        if(felicidade >= 70){
            System.out.println("Seu bichinho está radiante de felicidade!!");
        }
        else if (felicidade >= 40 && felicidade <= 69){
            System.out.println("Seu bichinho está bem, mas podia estar melhor!");
        }
        else {
            System.out.println("Seu bichinho está triste, cuide melhor dele!!");
        }
    }

    public int getFome() {
        return fome;
    }
    
    public int getEnergia() {
        return energia;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public String getNome() {
        return nome;
    }
}