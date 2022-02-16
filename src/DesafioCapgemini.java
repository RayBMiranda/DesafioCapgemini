import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author raybm
 */
public class DesafioCapgemini {
    static List<String> anagramas = new ArrayList<>();

    //Função Principal para Menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroQuestao = -1;
        while(numeroQuestao != 0){
            System.out.println("Digite o número da Questão 1,2,3 ou 0 para sair ");
            numeroQuestao = scanner.nextInt();
            switch (numeroQuestao){
                case 1:
                    //Função que atende a Questão 1
                    imprimeAsteristico();
                    break;
                case 2:
                    //Função que atende a Questão 2
                    quantosDigitosFaltam();
                    break;
                case 3:
                    //Função que atende a Questão 3
                    exibeResultado();
                    break;
                case 0: break;
                default: System.out.println("Opção Inválida !");
            }
        }
    }

    //Função que atende a Questão 1
    public static void imprimeAsteristico(){
        try {
            System.out.println("Digite o número desejado");
            Scanner scanner = new Scanner(System.in);
            int numeroDigitado;
            int asteristico    = 0;
            String linha = "";

            numeroDigitado = scanner.nextInt();

            while(asteristico < numeroDigitado) {
                asteristico++;
                for(int espacos = numeroDigitado-asteristico; espacos > 0; espacos--) {
                    linha += " ";
                }
                for(int i = asteristico; i > 0; i--) {
                    linha += "*";
                }
                System.out.println(linha);
                linha = "";
            }
        } catch (Exception e) {
            System.out.println("Digite um número !");
        }
    }

    //Função que atende a Questão 2
    private static void quantosDigitosFaltam() {
        System.out.println("Digite a senha");
        Scanner scanner = new Scanner(System.in);
        String senha = scanner.nextLine();
        if(senha.length() <= 6){
            System.out.println(6-senha.length());
        }
    }

    //Função que atende a Questão 3
    public static void exibeResultado(){
        System.out.println("Digite a string");
        Scanner scanner = new Scanner(System.in);
        String palavra = scanner.nextLine();
        preparaAnagramas("", palavra);
        System.out.println(anagramas.size());
    }

    //Função que atende a Questão 3 OBS: Foi dividido em 2 para utilização da recursividade
    public static void preparaAnagramas(String prefixo, String palavra) {
        if (palavra.length() <= 1) {
            if(!anagramas.contains(prefixo + palavra))
                anagramas.add(prefixo + palavra);
        } else {
            for (int i = 0; i < palavra.length(); i++) {
                String atual = palavra.substring(i, i + 1);
                String anterior = palavra.substring(0, i);
                String posterior = palavra.substring(i + 1);
                preparaAnagramas(prefixo + atual, anterior + posterior);
            }
        }
    }
}
