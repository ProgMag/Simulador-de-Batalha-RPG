import java.util.Random;
import java.util.Scanner;

public class Main {
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

        while (heroi.getPontosDeVida() > 0 && vilao.getPontosDeVida() > 0) {

            System.out.println(" --- Turno de " + nomeHeroi +
                    " \n1 - Atacar " +
                    " \n2 - Poções de cura (quantidade: 3)\n" +
                    " Escolha sua ação: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    int dadoDoHeroi = dado.nextInt(10) + 1;

            if (dadoDoHeroi == 5) {
                System.out.println("Dado lançado pelo " + nomeHeroi +
                        "\nNumero obtido de: " + dadoDoHeroi);

                vilao.recebeDano(heroi.getPontosDeAtaque());

                System.out.println(nomeHeroi + " ataca " + nomeVilao + " e recebe " + heroi.getPontosDeAtaque() + " de dano básico\n" +
                        "Vida do vilão: " + vilao.getPontosDeVida());

                // dano critico
            } else if (dadoDoHeroi == 8) {
                System.out.println("Dado lançado pelo " + nomeHeroi +
                        "\nNumero obtido de: " + dadoDoHeroi);

                vilao.recebeDano(heroi.getPontosDeAtaque() * 2);

                System.out.println(nomeHeroi + " ataca " + nomeVilao + " e recebe " + (heroi.getPontosDeAtaque() * 2) + " de dano critico\n" +
                        "Vida do vilão: " + vilao.getPontosDeVida());
            } else {
                System.out.format("""
                        Dado lançado por: %s
                        Valor obtido: %d
                        %s errou o ataque
                        %s se esquiva
                        """, nomeHeroi, dadoDoHeroi, nomeHeroi, nomeVilao);
            }
            if (vilao.getPontosDeVida() == 0) {
                System.out.println("""
                        Fim de jogo
                        Vilão perdeu
                        Herói venceu
                        """);
                break;
            }

            // vez do vilão
            int dadoDoVilao = dado.nextInt(10) + 1;

            if (dadoDoVilao == 5) {
                System.out.println("Dado lançado pelo " + nomeVilao +
                        "\nNumero obtido de: " + dadoDoVilao);

                heroi.recebeDano(vilao.getPontosDeAtaque());

                System.out.println(nomeVilao + " ataca " + nomeHeroi + " e recebe " + vilao.getPontosDeAtaque() + " de dano básico\n" +
                        "Vida do herói: " + heroi.getPontosDeVida());

                //dano critico

            } else if (dadoDoVilao == 8) {
                System.out.println("Dado lançado pelo " + nomeVilao +
                        "\nNumero obtido de: " + dadoDoVilao);

                heroi.recebeDano(vilao.getPontosDeAtaque() * 2);

                System.out.println(nomeVilao + " ataca " + nomeHeroi + " e recebe " + (vilao.getPontosDeAtaque() * 2) + " de dano critico\n" +
                        "Vida do herói: " + heroi.getPontosDeVida());
            } else {
                System.out.format("""
                        Dado lançado por: %s
                        Valor obtido: %d
                        %s errou o ataque
                        %s se esquiva
                        """, nomeVilao, dadoDoVilao, nomeVilao, nomeHeroi);
            }
            if (heroi.getPontosDeVida() == 0) {
                System.out.println("""
                        Fim de jogo
                        Herói perdeu
                        Vilão venceu
                        """);
                break;
            }
        }
    }
}