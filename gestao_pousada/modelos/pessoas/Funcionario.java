package modelos.pessoas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcionario extends Pessoa {
        private double salario;
        private String cargo;
        private static List<Funcionario> funcionarios = new ArrayList<>();
        public int id;

        public double getSalario(){
            return salario;
        }

        public void setSalario(double salario){
            this.salario = salario;
        }

        public String getCargo(){
            return cargo;
        }

        public void setCargo(String cargo){
            this.cargo = cargo;
        }

        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        

        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void cadastrar(){
            System.out.println("======== Criar Funcionario ========");

            super.cadastrar();

            System.out.println("Salario:");
            this.salario = sc.nextDouble();
            sc.nextLine();

            System.out.println("Cargo:");
            try{
                this.cargo = br.readLine();
            } catch (IOException ex){
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);

            }

            System.out.println("Funcionário atualizado com sucesso");
        }

        public static Funcionario buscar(String cpf){
            for(Funcionario funcionario : funcionarios){
                if(funcionario.getCpf().equals(cpf)){
                    return funcionario;
                }
            }
               System.out.println("Funcionário com CPF" + cpf + "não encontrado");
               return null;
        }

        public static void excluir(String cpf){
            Funcionario funcionario = buscar(cpf);
            if(funcionario != null){
                funcionarios.remove(funcionario);
                System.out.println("Funcionário excluído com sucesso");
            }
        }

           

     
}
