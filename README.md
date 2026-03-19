Batalha de RPG em Java
Um sistema clássico de combate de RPG por turnos rodando direto no console! Este projeto foi construído em Java para colocar em prática conceitos de Lógica de Programação e Orientação a Objetos (POO).

Sobre o Jogo
Neste mini-game interativo, você assume o papel de um Herói lutando contra um Vilão. O combate é ditado pela sorte dos dados (RNG) e pelas suas escolhas estratégicas durante o seu turno. Sobreviva aos ataques, gerencie suas poções de cura e tente acertar ataques críticos para vencer!

Funcionalidades
Personalização: Dê o nome que quiser ao seu Herói e ao Vilão.

Sistema de Dados (RNG): Cada ataque rola um dado virtual de 1 a 10 para definir o resultado.

Dano Crítico e Esquiva: Não é só bater! O ataque pode ser normal, causar dano em dobro ou errar completamente o alvo.

Inventário Dinâmico: O Herói possui um estoque limitado de poções de cura. Use com sabedoria!

Código Limpo (Clean Code): Estrutura refatorada utilizando o princípio DRY (Don't Repeat Yourself) e remoção de "Magic Numbers".

Regras do Combate
Durante o turno do herói, o jogador pode escolher entre Atacar ou Usar Poção.
Quando uma ação de ataque ocorre (tanto do herói quanto do vilão), um dado de 10 lados é rolado:

Resultado 1 a 5: Ataque Básico. Causa o dano padrão do personagem.

Resultado 8: Ataque Crítico. Causa o dobro do dano padrão.

Outros Resultados: Esquiva/Erro. O atacante erra o golpe e nenhum dano é causado.

Poções de Cura:

O Herói começa com 3 poções no inventário.

Cada poção recupera 10 pontos de vida.

Tentar usar uma poção sem ter estoque faz o herói perder o turno!

Tecnologias e Conceitos Utilizados
Java (Linguagem principal)

java.util.Scanner para entrada de dados interativa.

java.util.Random para geração de números aleatórios.

Orientação a Objetos: Classes (Main e Personagem), Encapsulamento (private), Construtores, Getters e Métodos customizados (recebeDano, curar).

Estruturas de Controle: Laços de repetição (while), Condicionais (if/else) e switch/case.

Como Executar
Certifique-se de ter o Java JDK instalado na sua máquina.

Clone este repositório ou baixe os arquivos Main.java e Personagem.java.

Abra o terminal na pasta onde os arquivos estão localizados.

Compile o código com o comando:

Bash
javac Main.java Personagem.java
Execute o jogo com o comando:

Bash
java Main
