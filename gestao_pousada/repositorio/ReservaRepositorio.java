package repositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import modelos.serviços.Reserva;

public class ReservaRepositorio{
    private List<Reserva> reservas = new ArrayList<>();

    public void adicionar(Reserva reserva){
        System.out.println("Reserva adicionada com sucesso");

    }

    public List<Reserva> listar(){
        if(reservas.isEmpty()){
            System.out.println("Nenhuma reserva cadastrada");
        } else {
            for(Reserva r : reservas){
                System.out.println("Reserva:" + r.getReserva());
                System.out.println("Valor" + r.getValor());
                System.out.println("====================");
            }
        }

        return reservas;
    }

    public void atualizar(int id){
        Optional<Reserva> reservOptional = reservas.stream().filter(r -> r.getId() == id).findFirst();
        if(reservOptional.isPresent()){
            Reserva reserva = reservOptional.get();
            try (Scanner sc = new Scanner (System.in)) {
                System.out.println("Informe a nova descricao da reserva");
                reserva.setReserva(sc.nextLine());

                System.out.println("Informe o novo valor da reserva");
                reserva.setValor(sc.nextDouble());
            }

            System.out.println("Reserva atualizada com sucesso");

        } else {
            System.out.println("Reserva não encontrada");
        }
    }
}