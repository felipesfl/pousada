package modelos.serviços;

public class Quarto{
        private String andar;
        private int numero;
        private String tipo;
        private boolean disponivel;
        private String qtdeHospede;
        private double valor;
                    
       public Quarto(int numero, String tipo, boolean disponivel){
            this.numero = numero;
            this.tipo = tipo;
            this.disponivel = disponivel;
        }
                    
        public int getNumero(){
            return numero;
        }
                    
        public void setNumero(String numero2){
            this.numero = numero;
        }
                    
        public String getTipo(){
            return tipo;
        }
                    
        public void setTipo(String tipo){
            this.tipo = tipo;
        }
                    
        public boolean getDisponivel(){
             return disponivel;
        }
                    
        public void setDisponivel(boolean disponivel){
            this.disponivel = disponivel;
        }
                    
        public void mostrarQuarto(){
            System.out.println("===== Quarto =====");
            System.out.println("Número do Quarto:"+ this.numero);
            System.out.println("Tipo do Quarto:" + this.tipo);
            System.out.println("Quarto Disponivel:" + this.disponivel);
                            
        }
                    
        public String getAndar() {
            return andar;
        }
                
        public void setAndar(String andar) {
            this.andar = andar;
        }
                
        public void setQtHospede(String qtdeHospede) {
            this.qtdeHospede = qtdeHospede;
        }
        
        public void setValor(double valor) {
            this.valor = valor;
        }

  
    
}
