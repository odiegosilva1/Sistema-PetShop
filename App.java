import java.util.ArrayList;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Estoque estoque = new Estoque();
        int opcao;

        do {
            System.out.println("\n--- MENU PETSHOP ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar pet para cliente");
            System.out.println("3. Cadastrar funcionário");
            System.out.println("4. Cadastrar produto");
            System.out.println("5. Mostrar todos os clientes e seus pets");
            System.out.println("6. Buscar pets por raça");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço do cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    clientes.add(new Cliente(nomeCliente, enderecoCliente));
                    System.out.println("Cliente cadastrado!");
                    break;
                case 2:
                    System.out.print("Nome do cliente dono do pet: ");
                    String nomeBusca = scanner.nextLine();
                    Cliente dono = null;
                    for (Cliente c : clientes) {
                        if (c.nome.equalsIgnoreCase(nomeBusca)) {
                            dono = c;
                            break;
                        }
                    }
                    if (dono != null) {
                        System.out.print("Nome do pet: ");
                        String nomePet = scanner.nextLine();
                        System.out.print("Raça: ");
                        String raca = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Tipo (mamífero/peixe/ave): ");
                        String tipo = scanner.nextLine();
                        dono.adicionarPet(new Pet(nomePet, raca, idade, tipo));
                        System.out.println("Pet adicionado ao cliente.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nome do funcionário: ");
                    String nomeFunc = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String enderecoFunc = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Cargo (veterinário/gestor): ");
                    String cargo = scanner.nextLine();
                    funcionarios.add(new Funcionario(nomeFunc, enderecoFunc, salario, cargo));
                    System.out.println("Funcionário cadastrado!");
                    break;
                case 4:
                    System.out.print("Nome do produto: ");
                    String nomeProd = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    estoque.adicionarProduto(new Produto(nomeProd, valor, desc));
                    System.out.println("Produto adicionado ao estoque.");
                    break;
                case 5:
                    for (Cliente c : clientes) {
                        System.out.println("Cliente: " + c.nome);
                        for (Pet p : c.listaPets) {
                            System.out.println("  Pet: " + p.nome + ", Raça: " + p.raca + ", Tipo: " + p.tipo);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Digite a raça a buscar: ");
                    String racaBusca = scanner.nextLine();
                    for (Cliente c : clientes) {
                        for (Pet p : c.listaPets) {
                            if (p.raca.equalsIgnoreCase(racaBusca)) {
                                System.out.println("Pet encontrado: " + p.nome + " (dono: " + c.nome + ")");
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        scanner.close();
    }
}