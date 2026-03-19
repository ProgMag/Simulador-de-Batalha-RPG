import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int POCAO_CURA = 10;
    private static final int DANO_CRITICO = 8;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random dado = new Random();

        System.out.println("--- Seja bem vindo a nossa batalha de RPG ---\n" +
                "Qual o nome do seu herói? ");
        String nomeHeroi = sc.nextLine();

        ArrayList<Personagem> monstros = new ArrayList<>();

        monstros.add(new Personagem("Goblin", 35, 24));
        monstros.add(new Personagem("Esqueleto", 36, 45));
        monstros.add(new Personagem("Dragão Vermelho", 65, 78));

        Mago heroi = new Mago(nomeHeroi, 135, 63, 100);

        int quantidadeDePocao = 3;

        for (Personagem monstroDaVez : monstros) {

            System.out.println("\n Um " + monstroDaVez.getNome() + " apareceu!");

            while (heroi.getPontosDeVida() > 0 && monstroDaVez.getPontosDeVida() > 0) {

                System.out.println("\n --- Turno de " + nomeHeroi + " --- " +
                        " \n1 - Atacar " +
                        " \n2 - Poções de cura: " + quantidadeDePocao +
                        " \n3 - Bola de fogo (Mana: " + heroi.getMana() + ")" +
                        "Escolha sua ação: ");
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> {
                        int dadoDoHeroi = dado.nextInt(10) + 1;
                        executarAtaque(heroi, monstroDaVez, dadoDoHeroi);
                    }
                    case 2 -> {
                        if (quantidadeDePocao > 0) {
                            heroi.curar(POCAO_CURA);
                            System.out.println(heroi.getNome() + " bebe a poção magica e recebe " + POCAO_CURA + " de vida!");
                            quantidadeDePocao--;
                        } else {
                            System.out.println("Seu estoque de poções de cura acabou!");
                        }
                    }
                    case 3 -> {
                        heroi.lancarFeitico(monstroDaVez);
                    }
                    default -> System.out.println("Ação invalida!");
                }

                if (monstroDaVez.getPontosDeVida() == 0) break;

                System.out.println("\n --- Turno do " + monstroDaVez.getNome() + " ---");
                int dadoDoVilao = dado.nextInt(10) + 1;
                executarAtaque(monstroDaVez, heroi, dadoDoVilao);

                if (heroi.getPontosDeVida() == 0) {
                    break;
                }
            }

            if (heroi.getPontosDeVida() > 0) {
                System.out.println("O Herói " + heroi.getNome() + " venceu a batalha!");
            } else {
                System.out.println("O Vilão " + monstroDaVez.getNome() + " venceu a batalha!");
                break;
            }
        }
        System.out.println("\n --- Fim de Jogo ---");
        if (heroi.getPontosDeVida() > 0) {
            System.out.println("Parabéns, você venceu todos os monstros da masmorra!");
        } else {
            System.out.println("Tente novamente!");
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