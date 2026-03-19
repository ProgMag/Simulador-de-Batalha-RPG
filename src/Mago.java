public class Mago extends Personagem {

    private double mana;

    public Mago(String nome, double pontosDeVida, double pontosDeAtaque, double mana) {
        super(nome, pontosDeVida, pontosDeAtaque);
        this.mana = mana;
    }

    public double getMana() {
        return mana;
    }

    public void lancarFeitico(Personagem alvo) {
        int custoDeMana = 25;
        if (this.mana >= custoDeMana) {
            this.mana -= custoDeMana;
            alvo.recebeDano(getPontosDeAtaque() + 10);
            System.out.println(getNome() + " lança um feitiço de bola de fogo no " + alvo.getNome() + " causando " + (getPontosDeAtaque()
                    + 10) + " de dano!");
            System.out.println(this.mana + " de mana");
        } else {
            System.out.println("Sem mana suficiente para atacar!");
        }
    }
}
