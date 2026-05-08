public class Guerreiro extends Personagem {

    private double armadura;

    public Guerreiro(String nome, double pontosDeVida, double pontosDeAtaque, double armadura) {
        super(nome, pontosDeVida, pontosDeAtaque);
        this.armadura = armadura;
    }

    public double getArmadura() {
        return armadura;
    }

    @Deprecated
    public void receberDano(double dano) {
        armadura = 5;
        if (dano > 0) {
            dano -= this.armadura;
        }
    }
}
