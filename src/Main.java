import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int POCAO_CURA = 3;
    private static final int DANO_CRITICO = 8;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random dado = new Random();

        System.out.println("--- Seja bem vindo a nossa batalha de RPG ---\n" +
                "Qual o nome do seu herói? ");
        String nomeHeroi = sc.nextLine();

        System.out.println("Qual o nome do seu vilão? ");
        String nomeVilao = sc.nextLine();

        Personagem heroi = new Personagem(nomeHeroi, 100, 30);
        Personagem vilao = new Personagem(nomeVilao, 110, 18);

        int quantidadeDePocao = 3;

        while (heroi.getPontosDeVida() > 0 && vilao.getPontosDeVida() > 0) {

            System.out.println("\n --- Turno de " + nomeHeroi + " --- " +
                    " \n1 - Atacar " +
                    " \n2 - Poções de cura: " + quantidadeDePocao + "\n" +
                    " Escolha sua ação: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    int dadoDoHeroi = dado.nextInt(10) + 1;
                    executarAtaque(heroi, vilao, dadoDoHeroi);
                }
                case 2 -> {
                    if (quantidadeDePocao > 0) {
                        heroi.curar(POCAO_CURA);
                        System.out.println(heroi.getNome() + " bebe a poção magica e recebe 10 de vida!");
                        quantidadeDePocao--;
                    } else {
                        System.out.println("Seu estoque de poções de cura acabou!");
                    }
                }
                default -> System.out.println("Ação invalida!");
            }

            if (vilao.getPontosDeVida() == 0) break;

            System.out.println("\n --- Turno do " + vilao.getNome() + " ---");
            int dadoDoVilao = dado.nextInt(10) + 1;
            executarAtaque(vilao, heroi, dadoDoVilao);

            if (heroi.getPontosDeVida() == 0) {
                break;
            }
        }

        System.out.println("\n --- Fim de Jogo ---");
        if (heroi.getPontosDeVida() > 0) {
            System.out.println("O Herói " + heroi.getNome() + " venceu a batalha!");
        } else {
            System.out.println("O Vilão " + vilao.getNome() + " venceu a batalha!");
        }
    }

    private static void executarAtaque(Personagem atacante, Personagem defensor, int valorDoDado) {
        System.out.println("Dado lançado por " + atacante.getNome() + " Numero obtido: " + valorDoDado);

        if (valorDoDado >= 1 && valorDoDado <= 5) {
            defensor.recebeDano(atacante.getPontosDeAtaque());
            System.out.println(atacante.getNome() + " ataca " + defensor.getNome() +
                    " e causa " + atacante.getPontosDeAtaque() + " de dano básico.");

        } else if (valorDoDado == DANO_CRITICO) {
            double danoCritico = atacante.getPontosDeAtaque() * 2;
            defensor.recebeDano(danoCritico);
            System.out.println("CRÍTICO! " + atacante.getNome() + " ataca " + defensor.getNome() +
                    " e causa " + danoCritico + " de dano!");

        } else {
            System.out.println(atacante.getNome() + " errou o ataque! " + defensor.getNome() + " se esquivou.");
        }
        System.out.println("Vida atual de " + defensor.getNome() + ": " + defensor.getPontosDeVida());
    }
}
