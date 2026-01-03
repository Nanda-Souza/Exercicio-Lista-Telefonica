import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variaveis de Controle
        Scanner scanner = new Scanner(System.in);
        String inputUsuario;
        int idContato = 1;
        String nomeContato;
        String telefoneContato;


        //Lista de contatos
        ArrayList<Contato> contatos = new ArrayList<>();


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
                    System.out.println("\n Digite o Nome do Contato: ");
                    nomeContato = scanner.nextLine().trim();

                    while (!Contato.nomeValido(nomeContato)){
                        System.out.println("Nome inválido. Digite novamente:");
                        nomeContato = scanner.nextLine().trim();
                    }

                    System.out.println("\n Digite o Numero de telefone do Contato: ");
                    telefoneContato = scanner.nextLine().trim();

                    while (!Telefone.numTelValido(telefoneContato)){
                        System.out.println("Número inválido. Digite um numero de telefone valido com 9 até 14 digitos:");
                        telefoneContato = scanner.nextLine().trim();
                    }

                    Telefone telefone = new Telefone();

                    telefone.setNumTelefone(telefoneContato);

                    Contato contato = new Contato();

                    contato.setId(idContato++);
                    contato.setNome(nomeContato);
                    contato.setNumTelefone(telefone);

                    contatos.add(contato);

                    System.out.println("\n Contato Adicionado com Sucesso!");
                    break;

                case "2":
                    System.out.println("Contato Editado");
                    break;

                case "3":
                    System.out.println("Contatos Listados");
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        System.out.println("\nLista de Contatos:");
                        //Percorre a lista e imprime cada objeto pessoa
                        for (Contato c : contatos) {
                            System.out.println(c);
                        }
                    }
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