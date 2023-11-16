package contatoscli.src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var controller = new ContatoController();
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 0 -> encerrarPrograma();
                case 1 -> controller.criarContato();
                case 2 -> controller.recuperarContato();
                case 3 -> controller.updateContato();
                case 4 -> controller.deletarContato();
                default -> opcaoInvalida();
            }
        } while (opcao != 0);
    }

    public static int menu() {
        System.out.println("0 - Sair");
        System.out.println("1 - Criar contato");
        System.out.println("2 - Recuperar contato");
        System.out.println("3 - Update contato");
        System.out.println("4 - Deletar contato");
        System.out.print("Sua opção: ");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        return opcao;
    }

    private static void encerrarPrograma() {
        System.out.println("Programa encerrado.");
    }

    private static void opcaoInvalida() {
        System.out.println("Opção não encontrada. Escolha um valor válido (0,1,2,3,4).");
    }

}