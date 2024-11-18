
import java.util.Scanner;
import modelos.pessoas.Hospede;
import modelos.serviços.ServicoExtra;
import repositorio.FuncionarioRepositorio;
import modelos.serviços.PousadaFachada;
import modelos.serviços.Reserva;
import modelos.pessoas.Funcionario;
import java.util.List;




public class Menu {
    public static void main(String[] args){
        PousadaFachada sistema = new PousadaFachada();
        try (Scanner sc = new Scanner(System.in)){
            boolean executar = true;
            while (executar){
                mostrarMenuPrincipal();
                int opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                       menuHospedes(sistema, sc);
                       break;
                    case 2:
                        menuFuncionarios(sistema, sc);
                        break;
                    case 3:
                        menuServicos(sistema, sc);
                        break;
                    case 4:
                        menuReservas(sistema,sc);
                        break;
                    case 0:
                         executar = false;
                         System.out.println("Saindo do sistema");
                         break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }
    }

    private static void mostrarMenuPrincipal(){
        System.out.println("========= Gestão da Pousada Iracema ========");
        System.out.println("=== Menu Principal ====");
        System.out.println("1. Hospedes");
        System.out.println("2. Funcionario");
        System.out.println("3. Serviço Extra");
        System.out.println("4. Reserva");
        System.out.println("0. Sair");
        System.out.println("=============================");
        System.out.println("Escolha uma opção");
    }

    private static void menuHospedes(PousadaFachada sistema, Scanner sc) {
        boolean executar = true;
        while (executar) {
            System.out.println("======== Opções de Hóspedes =============");
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Listar Hóspedes");
            System.out.println("3. Excluir Hóspede");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");
            
            int opcao = sc.nextInt(); 
            sc.nextLine();
    
            switch (opcao) {
                case 1:
                    cadastrarHospedes(sistema, sc);
                    break;
                case 2:
                    sistema.listarHospedes();
                    break;
                case 3:
                    excluirHospede(sistema, sc);
                    break;
                case 0:
                    executar = false; 
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    private static void cadastrarHospedes(PousadaFachada sistema, Scanner sc){
        Hospede hospede = new Hospede();
    
        System.out.println("Nome:");
        hospede.setNome(sc.nextLine());
        
        System.out.println("CPF:");
        hospede.setCpf(sc.nextLine());
        
        System.out.println("Email:");
        hospede.setEmail(sc.nextLine());
        
        sistema.cadastrarHospede(hospede);
        System.out.println("Hóspede cadastrado com sucesso!");
    }

    private static void excluirHospede(PousadaFachada sistema, Scanner sc) {
        System.out.print("Informe o ID do hóspede a ser excluído: ");
        int id = sc.nextInt();
        sc.nextLine();
        sistema.excluirHospede(id, null);
    }

    public void listarHospedes(List<Hospede> listaDeHospedes) {

        if (listaDeHospedes == null || listaDeHospedes.isEmpty()) {
            System.out.println("Não há hóspedes cadastrados.");
            return;
        }
    
        System.out.println("Lista de Hóspedes:");
        for (Hospede hospede : listaDeHospedes) {
            System.out.println("ID: " + hospede.getId(0) + ", Nome: " + hospede.getNome());
        }
    }

    private static void menuFuncionarios(PousadaFachada sistema, Scanner sc) {
        boolean executar = true;
        while (executar) {
            System.out.println("======== Opções de Funcionários =============");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Excluir Funcionário");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt(); 
            sc.nextLine();
            switch (opcao) {
                case 1:
                    menuFuncionarios(sistema, sc);
                    break;
                case 2:
                    sistema.listarFuncionarios();
                    break;
                case 3:
                    excluirFuncionario(sistema, sc);
                    break;
                case 0:
                    executar = false; 
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    
    public void cadastrarFuncionario(Funcionario funcionario) {
      if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
        System.out.println("Nome do funcionário não pode ser vazio");
        return;
      }
      if (funcionario.getCargo() == null || funcionario.getCargo().isEmpty()) {
        System.out.println("Cargo do funcionário não pode ser vazio");
        return;
      }
      if (funcionario.getSalario() <= 0) {
        System.out.println("Salário do funcionário deve ser maior que zero");
        return;
      }

    FuncionarioRepositorio.adicionar(funcionario);
    System.out.println("Funcionário cadastrado: " + funcionario.getNome());
}
    
    private static void excluirFuncionario(PousadaFachada sistema, Scanner sc) {
        System.out.print("Informe o ID do funcionário a ser excluído: ");
        int id = sc.nextInt();
        sc.nextLine();
        sistema.excluirFuncionario(id);
    }
    
    public void listarFuncionarios(List<Funcionario> listaDeFuncionarios) {
        if (listaDeFuncionarios == null || listaDeFuncionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
        }
    }
    
    private static void menuServicos(PousadaFachada sistema, Scanner sc) {
        boolean executar = true;
        while (executar) {
            System.out.println("========= Opções de Serviços Extras========");
            System.out.println("1. Adicionar Serviço Extra");
            System.out.println("2. Listar Serviços Extras");
            System.out.println("3. Excluir Serviço Extra");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("===============================================");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    adicionarServicoExtra(sistema, sc);
                    break;
                case 2:
                    sistema.listarServicosExtras(); 
                    break;
                case 3:
                    excluirServicoExtra(sistema, sc);
                    break;
                case 0:
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void adicionarServicoExtra(PousadaFachada sistema, Scanner sc) {
        System.out.println("Nome do Serviço:");
        String nomeServico = sc.nextLine();
        System.out.print("Categoria: ");
        String categoria = sc.nextLine();
        System.out.println("Valor:");
        double valor;
        while (true) {
            try {
                valor = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Por favor, insira um valor numérico válido");
                sc.next();
            }
        }
        ServicoExtra servico = new ServicoExtra(nomeServico, categoria, valor);
        sistema.adicionarServico(null, servico);
        System.out.println("Serviço extra adicionado com sucesso!");
    }

    private static void excluirServicoExtra(PousadaFachada sistema, Scanner sc) {
        System.out.print("Informe o ID do serviço extra a ser excluído: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        sistema.excluirServicoExtra(id, null); 
    }


    private static void menuReservas(PousadaFachada sistema, Scanner sc) {
        boolean executar = true;
        while (executar) {
            System.out.println("========= Opções de Reservas =========");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("3. Excluir Reserva");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    criarReserva(sistema, sc, null);
                    break;
                case 2:
                    sistema.listarReserva(); 
                    break;
                case 3:
                    excluirReserva(sistema, sc);
                    break;
                case 0:
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void criarReserva(PousadaFachada sistema, Scanner sc, List<Reserva> reservas) {
        System.out.print("Informe o ID da reserva: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
    
        System.out.print("Informe o nome do hóspede: ");
        String nomeHospede = sc.nextLine();
    
        System.out.print("Informe a data da reserva (formato: DD/MM/YYYY): ");
        String dataReserva = sc.nextLine();

        System.out.print("Informe a data de saída (formato: DD/MM/YYYY): ");
    String dataSaida = sc.nextLine();
    
        if (reservas == null) {
            System.out.println("Erro: A lista de reservas não foi inicializada.");
            return;
        }
    
        Reserva novaReserva = new Reserva();

        reservas.add(novaReserva);
        System.out.println("Reserva criada com sucesso!");
    }


    private static void excluirReserva(PousadaFachada sistema, Scanner sc) {
        System.out.print("Informe o ID da reserva a ser excluída: ");
        int id = sc.nextInt();
        sc.nextLine();
        sistema.excluirReserva(id); 
        System.out.println("Reserva excluída com sucesso!");
    }













}


