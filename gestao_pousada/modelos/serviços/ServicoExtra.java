package modelos.serviços;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.pessoas.Hospede;

public class ServicoExtra implements Servico {
       private static final ServicoExtra[] serviço = null;
       private String nome;
       private String categoria;
       private double valor;
       private int id;
                       
       private static List<ServicoExtra> servicos = new ArrayList<>();
                 
       public ServicoExtra() {}
                 
       public ServicoExtra(String nome, String categoria, double valor){
            this.nome = nome;
            this.categoria = categoria;
            this.valor = valor;
        }
                 
        public String getNome(){
            return nome;
        }
                 
        public void setNome(String nome){
            this.nome = nome;
        }
                 
        public String getCategoria(){
            return categoria;
        }
                 
        public void setCategoria(String categoria){
            this.categoria = categoria;
        }
                 
        public double getValor(){
            return valor;
        }
                 
        public void setValor(double valor){
            this.valor = valor;
        }
                 
        Scanner sc = new Scanner(System.in);
                 
        public void cadastrar(){
            System.out.println("========= Registro de Serviço Extra ========");
            System.out.println("Nome:");
            this.nome = sc.nextLine();
                 
            System.out.println("Categoria:");
            this.categoria = sc.nextLine();
                 
            System.out.println("Valor");
            this.valor = sc.nextDouble();
                 
            servicos.add(this);
            System.out.println("Pedido de Serviço Extra cadastrado com sucesso");
                 
        }
                 
        public void mostrarPedido(){
            System.out.println("======= Pedido de Serviço =======");
            System.out.println("Nome:" + this.nome);
            System.out.println("Categoria:" + this.categoria);
            System.out.println("Valor:" + this.valor);
            System.out.println("==================================");
                 
        }
                 
        public void atualizar(String nome){
          for(ServicoExtra servico : serviço){
              if(((ServicoExtra) servicos).getNome().equals(nome)){
                   System.out.println("Novo nome:");
                   servico.setNome(sc.nextLine());

                   System.out.println("Nova categoria:");
                   servico.setCategoria(sc.nextLine());

                   System.out.println("Novo valor:");
                   servico.setValor(sc.nextDouble());
                     
                   sc.nextLine();
                   System.out.println("Pedido atualizado com sucesso");
                   return;
              }
          }

          System.out.println("Serviço não encontrado");
        }

        public static ServicoExtra buscar(String nome){
          for(ServicoExtra servico: serviço){
            if(servico.getNome().equals(nome)){
                return servico;
            }
          }
          System.out.println("Pedido com o nome" + nome + "não encontrado");
          return null;
        }

        public static void excluir(String nome){
            ServicoExtra servico = buscar(nome);
            if(servico != null){
                servicos.remove(servico);
                System.out.println("Pedido de Serviço excluído com sucesso");
            } else {
                System.out.println("Serviço não encontrado");
            }
        }

        public static void listar(){
          System.out.println("============ Pedidos de Serviço =========");
             for(ServicoExtra servico : serviço){
                servico.mostrarPedido();
             }
           System.out.println("======================================");
        }

        public int getId(){
          return id;
        }

        public void setId(int id){
           this.id = id;
        }

        @Override
        public void executar(){
          System.out.println("Serviços Extras" + nome + "executado");
        }

        @Override
        public double calcularCusto(){
            return valor;
        }

        public void setHospede(Hospede hospede) {

        }



   
}
