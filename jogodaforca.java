import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Palavra secreta e tema
        String palavraSecreta = "PROGRAMACAO";
        String tema = "Tecnologia";
        int tentativasRestantes = 6;

        // Variáveis de jogo
        Set<Character> letrasUsadas = new HashSet<>();
        StringBuilder progresso = new StringBuilder("_".repeat(palavraSecreta.length()));

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Tema: " + tema);
        System.out.println("A palavra possui " + palavraSecreta.length() + " letras.");
        
        while (tentativasRestantes > 0) {
            exibirBoneco(tentativasRestantes);
            System.out.println("Palavra: " + progresso);
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            
            char tentativa = scanner.nextLine().toUpperCase().charAt(0);

            // Verifica se a letra já foi usada
            if (letrasUsadas.contains(tentativa)) {
                System.out.println("Você já usou essa letra. Tente outra.");
                continue;
            }

            letrasUsadas.add(tentativa);

            // Verifica se a letra está na palavra secreta
            if (palavraSecreta.indexOf(tentativa) >= 0) {
                System.out.println("Boa! A letra está na palavra.");
                for (int i = 0; i < palavraSecreta.length(); i++) {
                    if (palavraSecreta.charAt(i) == tentativa) {
                        progresso.setCharAt(i, tentativa);
                    }
                }
                // Verifica se o jogador venceu
                if (progresso.toString().equals(palavraSecreta)) {
                    System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                    break;
                }
            } else {
                System.out.println("Que pena! A letra não está na palavra.");
                tentativasRestantes--;
            }
        }

        if (tentativasRestantes == 0) {
            exibirBoneco(0);
            System.out.println("Você foi enforcado! A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }

    // Método para exibir o boneco na forca
    public static void exibirBoneco(int tentativasRestantes) {
        System.out.println("  _______");
        System.out.println(" |       |");
        System.out.println(" |       " + (tentativasRestantes <= 5 ? "O" : ""));
        System.out.println(" |      " + (tentativasRestantes <= 3 ? "/" : " ") + (tentativasRestantes <= 4 ? "|" : "") + (tentativasRestantes <= 2 ? "\\" : ""));
        System.out.println(" |      " + (tentativasRestantes <= 1 ? "/" : "") + " " + (tentativasRestantes == 0 ? "\\" : ""));
        System.out.println("_|_");
        System.out.println();
    }
}
