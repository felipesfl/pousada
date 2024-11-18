package repositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.serviços.Quarto;

public class QuartoRepositorio{
        private List<Quarto> quartosList =  new ArrayList<>();

        public void adicionar(Quarto quarto){
            quartosList.add(quarto);
            System.out.println("Quarto inserido com sucesso");
        }

        public List<Quarto> listar(){ 
              if(quartosList.isEmpty()){
                 System.out.println("Nenhum quarto cadastrado");
              }
              return quartosList;
        }

        public void excluir(int id){
            if(id >= 0 && id < quartosList.size()){
                quartosList.remove(id);
                System.out.println("Quarto excluído com sucesso");
            } else {
                System.out.println("Quarto não encontrado");
            }
        }

        public void atualizar(int id){
            if(id >= 0 && id < quartosList.size()){
                try (Scanner sc = new Scanner(System.in)) {
                    Quarto quarto = quartosList.get(id);

                    System.out.println("Novo número do quarto:");
                    String numero = sc.nextLine();
                    quarto.setNumero(numero);

                    System.out.println("Novo andar");
                    String andar = sc.nextLine();
                    quarto.setAndar(andar);

                    System.out.println("Nova quantidade de Hospede");
                    String qtdeHospede = sc.nextLine();
                    quarto.setQtHospede(qtdeHospede);

                    System.out.println("Novo valor do quarto:");
                    double valor = sc.nextDouble();
                    quarto.setValor(valor);
                }
                System.out.println("Quarto atualizado com sucesso");
            } else {
                System.out.println("Quarto não encontrado");
            }
        }

}