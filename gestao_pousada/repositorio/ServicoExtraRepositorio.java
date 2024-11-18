package repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.serviços.ServicoExtra;

public class ServicoExtraRepositorio {
    private List<ServicoExtra> servicos = new ArrayList<>();
    private int nextId = 1;

    public void cadastrar(ServicoExtra servico){
        servico.setId(nextId++);
        servicos.add(servico);
        System.out.println("Pedido de Serviço cadastrado com sucesso");
    }

    public List<ServicoExtra> listar(){
        if(servicos.isEmpty()){
            System.out.println("Nenhum pedido de serviço encontrado");
        } else {
            for(ServicoExtra s : servicos){
                System.out.println("ID:" + s.getId());
                System.out.println("Nome:" + s.getNome());
                System.out.println("Categoria:" + s.getCategoria());
                System.out.println("Valor:" + s.getValor());
            }
        }
        return servicos;

    }

    public void excluir(int id){
        ServicoExtra servico = buscarPedido(id);
        if(servico != null){
            servicos.remove(servico);
            System.out.println("Pedido de Serviço excluído com suceso");
        } else {
            System.out.println("Pedido com o ID" + id + "não encontrado");
        }
    }

    public void atualizar(int id){
        ServicoExtra servico = buscarPedido(id);
        if(servico == null){
           System.out.println("Pedido com ID" + id + "não encontrado");
           return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Informe o novo nome do serviço:");
            servico.setNome(sc.nextLine());

            System.out.println("Informe a nova categoria ");
            servico.setCategoria(sc.nextLine());

            System.out.println("Informe o novo valor:");
            servico.setValor(sc.nextDouble());
        }
        System.out.println("Pedido de Serviço atualizado com sucesso");
     
    }

    public ServicoExtra buscarPedido(int id){
        for(ServicoExtra s : servicos){
            if(s.getId() == id) {
                System.out.println("Nome:" + s.getNome());
                System.out.println("Categoria" + s.getCategoria());
                System.out.println("Valor" + s.getValor());
                return s;
            }
        }
        System.out.println("Pedido com ID" + id + "não encontrado");
        return null;
    }
}
