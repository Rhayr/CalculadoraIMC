import java.util.Scanner;

public class calculoIMC {
    public static void main(String[] args) {
        Scanner lerTeclado = new Scanner(System.in);
        System.out.println("Digite o seu nome: ");
        String nome = lerTeclado.nextLine();

        String generoTexto = """
                Digite o seu gênero:
                Masculino (M) Feminino (F) Não quero me identificar (N)""";
        System.out.println(generoTexto);
        String genero = lerTeclado.nextLine().toUpperCase();
        char generoChar = genero.charAt(0);

        System.out.println("Digite a sua altura: ");
        double altura = lerTeclado.nextDouble();
        lerTeclado.nextLine();

        System.out.println("Digite o seu peso: ");
        double peso = lerTeclado.nextDouble();
        lerTeclado.nextLine();

        System.out.print("\033[H\033[2J");

        double imc = Calculo(altura, peso);
        System.out.printf("O IMC de %s é %.2f\n", nome, imc);
        interpretarResultadoIMC(imc, generoChar);

        lerTeclado.close();
    }

    public static double Calculo(double altura, double peso) {
        return peso / Math.pow(altura, 2);
    }

    public static void interpretarResultadoIMC(double imc, char generoChar) {
        switch (generoChar) {
            case 'F':
                interpretarResultadoIMCFem(imc);
                break;
            case 'N':
                interpretarResultadoIMCFem(imc);
                break;
            case 'M':
                interpretarResultadoIMCMasc(imc);
                break;
            default:
                System.out.println("Gênero inválido.");
        }
    }

    public static void interpretarResultadoIMCFem(double imc) {
        if (imc < 19) {
            System.out.println("Abaixo do peso.");
        } else if (imc >= 19 && imc < 23.9) {
            System.out.println("Peso normal.");
        } else if (imc >= 24 && imc < 28.9) {
            System.out.println("Obesidade leve.");
        } else if (imc >= 29 && imc < 38.9) {
            System.out.println("Obesidade moderada.");
        } else {
            System.out.println("Obesidade mórbida.");
        }
    }

    public static void interpretarResultadoIMCMasc(double imc) {
        if (imc < 20) {
            System.out.println("Abaixo do peso.");
        } else if (imc >= 20 && imc < 24.9) {
            System.out.println("Peso normal.");
        } else if (imc >= 25 && imc < 29.9) {
            System.out.println("Obesidade leve.");
        } else if (imc >= 30 && imc < 39.9) {
            System.out.println("Obesidade moderada.");
        } else {
            System.out.println("Obesidade mórbida.");
        }
    }
}
