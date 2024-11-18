package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;
import modelos.pessoas.Funcionario;
import modelos.pessoas.Pessoa;

public class FuncionarioRepositorio {
     private static List<Funcionario> funcionarios = new ArrayList<>();
          private Optional<Funcionario> funcionarioOptional;
     
             public static void adicionar(Funcionario funcionario) {
                 funcionarios.add(funcionario);
        }
    
        public List<Funcionario> listar() {
            return funcionarios;
        }
    
        public void excluir(int id) {
            funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        }
    }
