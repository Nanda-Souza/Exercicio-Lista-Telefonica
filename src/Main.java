import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean inputValido(String input) {
        return input != null &&
                input.matches("^[12]$");
    }

    public static boolean idValido(String id) {
        return id != null &&
                id.matches("\\d+");
    }

    public static boolean inicialValida(String inicial) {
        return inicial != null &&
                inicial.matches("^[A-Za-z]+$") &&
                inicial.length() == 1;
    }

    public static void main(String[] args) {
        //Variaveis de Controle
        Scanner scanner = new Scanner(System.in);
        String inputUsuario;
        int idContato = 1;
        String nomeContato;
        String telefoneContato;
        boolean resultadoEncontrado;
        boolean contatoEditado;


        //Lista de contatos
        ArrayList<Contato> contatos = new ArrayList<>();


        //Menu Inicial
        do{

            System.out.println("\n==== Agenda Telefônica ====");
            System.out.println("1 - Cadastrar Contato");
            System.out.println("2 - Editar Contato");
            System.out.println("3 - Listar Contatos");
            System.out.println("4 - Buscar por Inicial");
            System.out.println("5 - Deletar Contato");
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
                    if (contatos.isEmpty()) {
                        System.out.println("Para editar um contato é necessário cadastrar um contato primeiro!");
                    } else {

                        System.out.println("\nDigite o ID do Contato:");
                        inputUsuario = scanner.nextLine().trim();

                        while (!idValido(inputUsuario)){
                            System.out.println("ID inválido, digite um ID válido para excluir o contato:");
                            inputUsuario = scanner.nextLine().trim();
                        }

                        int idBusca = Integer.parseInt(inputUsuario);
                        resultadoEncontrado = false;
                        contatoEditado = false;

                        for (Contato c: contatos){
                            if (c.getId() == idBusca) {

                                System.out.println("\nDeseja editar o nome do contato? ");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");

                                inputUsuario = scanner.nextLine().trim();

                                while (!inputValido(inputUsuario)){
                                    System.out.println("\nOpção inválida, digite 1 para sim e 2 para não:");
                                    inputUsuario = scanner.nextLine().trim();
                                }

                                if (inputUsuario.equals("1")){
                                    System.out.println("\nInsira um novo nome para o contato " + c.getNome() + ":");

                                    nomeContato = scanner.nextLine().trim();

                                    while (!Contato.nomeValido(nomeContato)){
                                        System.out.println("Nome inválido. Digite novamente:");
                                        nomeContato = scanner.nextLine().trim();
                                    }

                                    c.setNome(nomeContato);
                                    contatoEditado = true;

                                }

                                System.out.println("\nDeseja editar o numero do contato? ");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");

                                inputUsuario = scanner.nextLine().trim();

                                while (!inputValido(inputUsuario)){
                                    System.out.println("\nOpção inválida, digite 1 para sim e 2 para não:");
                                    inputUsuario = scanner.nextLine().trim();
                                }

                                if (inputUsuario.equals("1")){
                                    System.out.println("\nInsira um novo numero para o contato " + c.getNome() + ":");

                                    telefoneContato = scanner.nextLine().trim();

                                    while (!Telefone.numTelValido(telefoneContato)){
                                        System.out.println("Número inválido. Digite um numero de telefone valido com 9 até 14 digitos:");
                                        telefoneContato = scanner.nextLine().trim();
                                    }

                                    Telefone novoTelefone = new Telefone();
                                    novoTelefone.setNumTelefone(telefoneContato);
                                    c.setNumTelefone(novoTelefone);
                                    contatoEditado = true;


                                }

                                resultadoEncontrado = true;
                                break;
                            }
                        }

                        if (contatoEditado){
                            System.out.println("Contato Editado!");
                        } else if (resultadoEncontrado) {
                            System.out.println("Nenhuma edição realizada!");
                        } else {
                            System.out.println("ID não encontrado!");
                        }

                    };
                    break;

                case "3":
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado. Favor cadastrar um contato!");
                    } else {
                        System.out.println("\nLista de Contatos:");
                        //Percorre a lista e imprime cada objeto pessoa
                        for (Contato c : contatos) {
                            System.out.println(c);
                        }
                    }
                    break;

                case "4":
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado. Favor cadastrar um contato!");
                    } else {
                        System.out.println("\nFavor inserir a letra inicial dos contatos que deseja exibir: ");
                        inputUsuario = scanner.nextLine().trim();

                        while (!inicialValida(inputUsuario)){
                            System.out.println("Letra inválida, digite apenas uma letra para realizar a busca por inicial!");
                            inputUsuario = scanner.nextLine().trim();
                        }

                        char inicialEscolhida = inputUsuario.toLowerCase().charAt(0);
                        ArrayList<Contato> listaPorInicial =  new ArrayList<>();

                        listaPorInicial = Contato.listarContatoPorInicial(contatos, inicialEscolhida);

                        if (listaPorInicial.isEmpty()){
                            System.out.println("Nenhum contato encontrado para inicial " + inicialEscolhida + "!");
                        } else {
                            System.out.println("\nLista de Contatos pela inicial " + inicialEscolhida + ":");
                            for (Contato c : listaPorInicial) {
                                System.out.println(c);
                            }
                        }


                    }
                    break;

                case "5":
                    if (contatos.isEmpty()) {
                        System.out.println("Para deletar um contato é necessário cadastrar um contato primeiro!");
                    } else {

                        System.out.println("\nDigite o ID do Contato:");
                        inputUsuario = scanner.nextLine().trim();

                        while (!idValido(inputUsuario)){
                            System.out.println("ID inválido, digite um ID válido para excluir o contato:");
                            inputUsuario = scanner.nextLine().trim();
                        }

                        int idBusca = Integer.parseInt(inputUsuario);
                        resultadoEncontrado = false;

                        for (Contato c: contatos){
                            if (c.getId() == idBusca) {
                                resultadoEncontrado = true;
                                break;
                            }
                        }

                        if (resultadoEncontrado){
                            contatos.removeIf(c -> c.getId() == idBusca);
                            System.out.println("Contato Removido!");
                        } else {
                            System.out.println("ID não encontrado!");
                        }





                    }
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