import java.util.Date;

public class Carro {
    
    private String placa;
    private Date entrada;
    private Date saida;
    private int manobras;

    public Carro(String placa){
        this.placa = placa;
        this.entrada = new Date();
        manobras = 0;
    }

    public String getPlaca() {
        return placa;
    }
    public void setSaida(Date saida) {
        this.saida = saida;
    }
    public Date getSaida() {
        return saida;
    }
    public int getManobras() {
        return manobras;
    }
    public void manobrar(){
        manobras++;
    }

    public Date getEntrada() {
        return entrada;
    }

    @Override
    public String toString(){
        return "Placa: " + getPlaca() + " - Entrada: " + getEntrada();
    }
    

}
