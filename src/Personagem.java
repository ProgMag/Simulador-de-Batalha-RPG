public class Personagem {
    private String nome;
    private double pontosDeVida;
    private double pontosDeAtaque;

    public Personagem(String nome, double pontosDeVida, double pontosDeAtaque) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.pontosDeAtaque = pontosDeAtaque;
    }

    public String getNome() {
        return nome;
    }

    public double getPontosDeVida() {
        return pontosDeVida;
    }

    public double getPontosDeAtaque() {
        return pontosDeAtaque;
    }

    public void recebeDano(double dano) {
        pontosDeVida -= dano;
        if (pontosDeVida <= 0) {
            pontosDeVida = 0;
//            System.out.println("Personagem morto!");
        }
//        System.out.println("Vida: " + pontosDeVida);
    }
}
