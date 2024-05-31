import java.util.Date;

public class Carro {
    
    private int manobras;
    private String placa;
    private Date entrada;
    private Date saida;

    public Carro(String placa){
        this.placa = placa;
        this.entrada = new Date();
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Date getEntrada() {
        return entrada;
    }
    public int getManobras() {
        return manobras;
    }
    public String getPlaca() {
        return placa;
    }
    public void manobrar(){
        this.manobras++;
    }

    @Override
    public String toString(){
        String s = "Placa: " + getPlaca() + " - Entrada: " + getEntrada();
        if (getSaida() != null){
            s += " - Saida: " + getSaida();
        }
        s += " - Manobras: " + getManobras();
        return s;
    }
    
}
