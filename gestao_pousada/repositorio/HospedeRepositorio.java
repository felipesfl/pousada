package repositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.pessoas.Hospede;

public class HospedeRepositorio {
     private List<Hospede> hospedes;

     public HospedeRepositorio(){
        this.hospedes = new ArrayList<>();
     }

     public static void adicionar(HospedeRepositorio hospede){
        HospedeRepositorio.adicionar(hospede);
        System.out.println("Hospede adicionado com sucesso");
     }

     public List<Hospede> listarHospede(){
        System.out.println("Lista de hospedes:");
        for(Hospede h : hospedes){
            System.out.println("Nome do Hospede:" + h.getNome());
            System.out.println("Email:" + h.getEmail());
            System.out.println("CPF:" + h.getCpf());
            System.out.println("Renda:" + h.getRenda());
        }

        return hospedes;
     }

     public void excluirHospede(int id){
        if(id >= 0 && id < hospedes.size()){
            hospedes.remove(id);
            System.out.println("Hospede excluido com sucesso");
        } else {
        System.out.println("ID invalido. Não foi possivel excluir");
        }
    }

     public void atualizarHospede(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Informe o ID do Hospede");
            int id = sc.nextInt();
            sc.nextLine();

            if(id >= 0 && id < hospedes.size()){
                Hospede hospede = hospedes.get(id);

                System.out.println("Informe o nome do hospede:");
                hospede.setNome(sc.nextLine());

                System.out.println("Informe o email do hospede");
                hospede.setEmail(sc.nextLine());

                System.out.println("Informe o CPF do hospede");
                hospede.setCpf(sc.nextLine());

                System.out.println("Informe a renda do hospede");
                hospede.setRenda(sc.nextDouble());

                System.out.println("Hospede atualizado com sucesso");
            } else{
                System.out.println("ID inváli8do. Não foi possível atualizar");
            }
        }
     }
    

     public Hospede buscarHospede(int id){
        if(id >= 0 && id < hospedes.size()){
            Hospede hospede = hospedes.get(id);
            System.out.println("Nome:" + hospede.getNome());
            System.out.println("Email:" + hospede.getEmail());
            System.out.println("CPF:" + hospede.getCpf());
            System.out.println("Renda:" + hospede.getRenda());
        } else {
           System.out.println("ID inválido. Hospede não encontrado");
        }
                return null;
     }

    public void mostrarHospede() {
       
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    public static void adicionar(Hospede hospede) {
        
    }

    

}

