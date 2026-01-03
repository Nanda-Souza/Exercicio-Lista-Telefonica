import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variaveis de Controle
        Scanner scanner = new Scanner(System.in);
        String inputUsuario;


        //Menu Inicial
        do{

            System.out.println("\n==== Agenda Telefônica ====");
            System.out.println("1 - Cadastrar Contato");
            System.out.println("0 - Sair");

            inputUsuario = scanner.nextLine().trim();

            switch (inputUsuario){
                case "1":
                    System.out.println("Usuario Criado");
                    break;

                case "0":
                    System.out.println("Fechando Agenda");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (!inputUsuario.equals("0"));


    }
}