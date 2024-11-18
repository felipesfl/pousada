package modelos.serviços;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import modelos.pessoas.Funcionario;
import modelos.pessoas.Hospede;
import repositorio.FuncionarioRepositorio;
import repositorio.HospedeRepositorio;

public class PousadaFachada {
          private List<Reserva> reservas;
          private Hospede[] hospede;
          private FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
                
    public PousadaFachada(){
        this.reservas = new ArrayList<>();
    }
                
    public void cadastrarHospede(Hospede hospede){
        if (hospede.getNome() == null || hospede.getNome().isEmpty()) {
            System.out.println("Nome do hóspede não pode ser vazio");
            return;
        }
        if (hospede.getCpf() == null || hospede.getCpf().isEmpty()) {
            System.out.println("CPF do hóspede não pode ser vazio");
            return;
        }
        if (hospede.getEmail() == null || hospede.getEmail().isEmpty()) {
            System.out.println("Email do hóspede não pode ser vazio");
            return;
        }
        
        HospedeRepositorio.adicionar(hospede);
        System.out.println("Hóspede cadastrado: " + hospede.getNome());
                   
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

    public void excluirHospede(int id, List<Reserva> listaDeHospedes) {
            if (listaDeHospedes == null) {
                System.out.println("A lista de hóspedes não está inicializada.");
                return;
            }
     
            Reserva hospedeParaRemover = null;
            for (Reserva hospede : listaDeHospedes) {
                if (hospede.getId() == id) {
                    hospedeParaRemover = hospede;
                    break;
                }
            }
     
            if (hospedeParaRemover != null) {
                listaDeHospedes.remove(hospedeParaRemover);
            System.out.println("Hóspede excluído com sucesso!");
        } else {
            System.out.println("Hóspede com ID " + id + " não encontrado.");
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            System.out.println("Nome do funcionário não pode ser vazio");
            return;
        }
        funcionarioRepositorio.adicionar(funcionario);
        System.out.println("Funcionário cadastrado: " + funcionario.getNome());
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepositorio.listar();
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
            }
        }
    }

    public void excluirFuncionario(int id) {
        funcionarioRepositorio.excluir(id);
        System.out.println("Funcionário excluído com sucesso!");
    }

                
    public void adicionarServico(List<ServicoExtra> servicos, ServicoExtra servico) {
        if (servicos == null) {
            servicos = new ArrayList<>();
        }
            servicos.add(servico);
            System.out.println("Serviço adicionado: " + servico.getNome());
    }

    public void listarServicosExtras(List<ServicoExtra> listaDeServicosExtras) {
        if (listaDeServicosExtras == null || listaDeServicosExtras.isEmpty()) {
            System.out.println("Não há serviços extras cadastrados.");
            return;
        }
        
        System.out.println("Lista de Serviços Extras:");
        for (ServicoExtra servico : listaDeServicosExtras) {
            System.out.println("ID: " + servico.getId() + ", Nome: " + servico.getNome());
        }
    }

    public void excluirServicoExtra(int id, List<ServicoExtra> listaDeServicosExtras) {
        if (listaDeServicosExtras == null) {
            System.out.println("A lista de serviços extras não está inicializada.");
            return;
        }
    
        ServicoExtra servicoParaRemover = null;
        for (ServicoExtra servico : listaDeServicosExtras) {
            if (servico.getId() == id) {
                servicoParaRemover = servico;
                break;
            }
        }
    
        if (servicoParaRemover != null) {
            listaDeServicosExtras.remove(servicoParaRemover);
            System.out.println("Serviço extra excluído com sucesso!");
        } else {
            System.out.println("Serviço extra com ID " + id + " não encontrado.");
        }
    }


    public void criarReserva(Hospede hospede, String dataReserva, List<ServicoExtra> servicos){
        if(dataReserva == null || dataReserva.isEmpty()){
            System.out.println("Data da Reserva inválida");
            return;
        }
            Reserva novaReserva = new Reserva();
            novaReserva.setHospede(hospede);
            novaReserva.setReserva(dataReserva);
            novaReserva.setServicoExtra(servicos);
          
            reservas.add(novaReserva);
            System.out.println("Reserva criada com sucesso para o hospede" + hospede.getNome());
    }
          
    public void listarReserva(){
        if(reservas.isEmpty()){
            System.out.println("Nenhuma reserva encontrada");
        } else {
            System.out.println("Lista de Reservas");
        for(Reserva reserva : reservas){
           System.out.println(reserva);
           System.out.println("=====================");
        }
        }
    }
    public Hospede buscar(int id, Hospede[] listaDeHospedes) {
            for (Hospede hospede : listaDeHospedes) { 
                return hospede;
            }
        return null; 
    }

   public Hospede buscarHospedePorId(int id) {
      return  buscar(id, hospede);
   }

  

    public void listarHospedes(Hospede[] hospedes) {
           for(Hospede hospede : hospedes){
              System.out.println(hospede);
       }
    }

    public void excluirHospede(int id, Collection<Reserva> hospedes) {
       hospedes.removeIf(hospede -> hospede.getId() == id);
    }

   

    public ServicoExtra buscarServicoExtraPorId(int id, ServicoExtra[] servicoExtras) {
             for(ServicoExtra servico : servicoExtras){
               if(servico.getId() == id){
                  return servico;
                }
         }
                return null;
    }   

    public void excluirReserva(int id) {
       reservas.removeIf(reserva -> reserva.getId() == id);
       System.out.println("Reserva excluída com sucesso");
    }

    public void excluirServicoExtra(ServicoExtra servico, List<Reserva> servicosExtras) {
            if(servicosExtras.remove(servico)){
                System.out.println("Serviço Extra excluído com sucesso");
            } else {
                System.out.println("Serviço extra não encontrada");
            }
    }

    @SuppressWarnings("unchecked")
    public ServicoExtra getAlgumaCoisaNecessaria(Object servicosExtras) {
           if(!((List<Reserva>) servicosExtras).isEmpty()){
                return ((List<ServicoExtra>) servicosExtras).get(0);
           }
            return null;
    }

    public void listarHospedes() {
        
    }

    public void listarServicosExtras() {
        
    }

    

    
}