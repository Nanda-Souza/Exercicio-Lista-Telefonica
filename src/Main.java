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
            System.out.println("2 - Editar Contato");
            System.out.println("3 - Listar Contatos");
            System.out.println("4 - Buscar por Inicial");
            System.out.println("5 - Deletar Constato");
            System.out.println("0 - Sair");

            inputUsuario = scanner.nextLine().trim();

            switch (inputUsuario){
                case "1":
                    System.out.println("Contato Criado");
                    break;

                case "2":
                    System.out.println("Contato Editado");
                    break;

                case "3":
                    System.out.println("Contatos Listados");
                    break;

                case "4":
                    System.out.println("Contatos Listados por Inicial");
                    break;

                case "5":
                    System.out.println("Contato Deletado");
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