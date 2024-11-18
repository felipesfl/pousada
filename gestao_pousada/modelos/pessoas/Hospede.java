package modelos.pessoas;
import repositorio.HospedeRepositorio;
import java.util.Scanner;

import modelos.serviços.Reserva;
import modelos.serviços.ServicoExtra;


public class Hospede extends Pessoa {
     private double renda;
     private static Scanner sc = new Scanner(System.in);

     public Hospede() {}

     @Override
     public void cadastrar(){
          System.out.println("===== Criar Hospede ======");
          super.cadastrar();

          System.out.print("Renda:");
          this.renda = sc.nextDouble();

          HospedeRepositorio hospede = new HospedeRepositorio();
          hospede.adicionar(this);

          System.out.println("Hospede cadastrado com sucesso");

     }

     public void mostrarHospede(){
          System.out.println("====== Hospede =====");
          System.out.println("Nome:" + this.nome);
          System.out.println("Email:" + this.email);
          System.out.println("CPF:" + this.cpf);
          System.out.println("Renda:" + this.renda);
          System.out.println("======================");
     }

     public void buscar(HospedeRepositorio hospede, int id){
           hospede.buscarHospede(id);
           hospede.mostrarHospede();
     }

     public void excluir(HospedeRepositorio hospede, int id){
          hospede.excluirHospede(id);
          System.out.println("Hospede excluído com sucesso");
     }

     public void add(Reserva novaReserva) {
        
     }
 

     public double getRenda(){
          return renda;
     }

     public void setRenda(double renda){
          this.renda = renda;
     }

     @Override
     public String getNome(){
          return nome;
     }

     @Override
     public void setNome(String nome){
          this.nome = nome;
     }

     @Override
     public String getEmail(){
          return email;
     }

     @Override
     public void setEmail(String email){
          this.email = email;
     }

     @Override
     public String getCpf(){
          return cpf;
     }

     @Override
     public void setCpf(String cpf){
          this.cpf = cpf;
     }

    public void adicionarServico(ServicoExtra servico) {
          
    }

    public int getId(int id) {
                return id;
    }

}



