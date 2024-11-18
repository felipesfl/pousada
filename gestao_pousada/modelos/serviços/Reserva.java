package modelos.serviços;

import modelos.pessoas.Hospede;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Reserva {
        private static List<Reserva> reservas = new ArrayList<>();
        private String reserva;
        private double valor;
        private Quarto quarto;
        private Hospede hospede;
    
        private List<Quarto> quartos = new ArrayList<>();
        private  List<Hospede> hospedes = new ArrayList<>();
        
        private Scanner sc = new Scanner(System.in);
            private int id;
            
            public void addHospede(Hospede hospede){
                this.hospedes.add(hospede);
            }
        
            public void addQuarto(Quarto quarto){
                this.quartos.add(quarto);
            }
        
            public void cadastrar() {
                System.out.println("====================");
                System.out.println("======== Reserva ======");
                System.out.println("========================");
        
                System.out.println("Classe Reserva:");
                this.reserva = sc.nextLine();
        
                System.out.println("Valor da Reserva:");
                this.valor = sc.nextDouble();
                sc.nextLine();
            }
        
        
            public void mostrarReserva(){
                System.out.println("======== Detalhes da Reserva ===========");
        
                for (Quarto q : quartos){
                    System.out.println("Número do Quarto:" + q.getNumero());
                    System.out.println("Andar do Quarto:" + q.getAndar());
                }
        
                System.out.println("======================================");
        
                for(Hospede h : hospedes){
                    System.out.println("Nome:" + h.getNome());
                    System.out.println("CPF:" + h.getCpf());
                    System.out.println("Email"+ h.getEmail());
                    System.out.println("Renda:" + h.getRenda());
                    System.out.println("====================================");
                }
            }
        
            public void atualizar(){
                Scanner sc = new Scanner(System.in);
                try {
                    System.out.println("Atualizando Reserva ID:" + this.id);
                    System.out.print("Nova Descrição da Reserva:");
                    this.reserva = sc.nextLine();
                    System.out.print("Novo valor da Reserva:");
                    while (true) {
                        try {
                            this.valor = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Por favor insira um valor numérico");
                            sc.next();
                        }
                     }
                    } finally{
                        sc.close();
                    }
                }
        
            public static Reserva buscar(int id){
                for(Reserva reserva : reservas){
                  if(reserva.getId() == id){
                   return reserva;
                  }
                }

               System.out.println("Reserva não encontrada");
               return null;
            }
    
            public static void excluir(int id){
                Iterator<Reserva> iterator = reservas.iterator();
                while (iterator.hasNext()){
                    Reserva reserva = iterator.next();
                    if(reserva.getId() == id){
                       iterator.remove();
                       System.out.println("Reserva ID" + id + "excluída com sucesso");
                       
                    }
                }
            }
    
            public String getReserva(){
               return reserva;
            }
    
            public void setReserva(String reserva){
                this.reserva = reserva;
            }
    
            public double getValor(){
               return valor;
            }
    
            public void setValor(double valor){
               this.valor = valor;
            }
    
            public Quarto getQuarto(){
               return quarto;
            }
    
            public void setQuarto(Quarto quarto){
               this.quarto = quarto;
            }
    
            public Hospede getHospede(){
               return hospede;
            }
    
            public void setHospede(Hospede hospede){
               this.hospede = hospede;
            }
    
            public int getId() {
              return id;
            }

            public void setServicoExtra(List<ServicoExtra> servicos) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'setServicoExtra'");
            }

            public String getNome() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getNome'");
            }

          
   


}