public class Estacionamento {
    
    private Fila<Carro> estacionamento;
    private Fila<Carro> auxiliar;
    private int capacidade;
    private int ocupacao;

    public Estacionamento(int capacidade){
        estacionamento = new Fila<>();
        auxiliar = new Fila<>();
        this.capacidade = capacidade;
        ocupacao = 0;
    }

    public boolean estaVazio(){
        return estacionamento.estaVazia();
    }

    public boolean estaCheio(){
        return ocupacao == capacidade;
    }

    public boolean estacionar(String placa){
        if (estaCheio()) return false;
        estacionamento.enfileira(new Carro(placa));
        ocupacao++;
        return true;
    }

    public Carro sair(String placa){
        if (estaVazio()) return null;
        Carro carro = pegarCarro(placa);
        Carro aux;
        if (carro == null){
            return null;
        }
        while ( (aux = estacionamento.desenfileira() ) != carro) {
            auxiliar.enfileira(aux);
            aux.manobrar();
        }
        while (!auxiliar.estaVazia()) {
            aux = auxiliar.desenfileira();
            aux.manobrar();
            estacionamento.enfileira(aux);
        }
        return carro;
    }

    // Verifica se o carro esta no estacionamento
    public String verificarCarro(String placa){
        if (estaVazio()) return "Não está no estacionamento";
        int pos = 0;
        Carro achar = null;
        Carro aux = null;
        while (!estacionamento.estaVazia() && achar == null) {
            pos++;
            aux = estacionamento.desenfileira();
            auxiliar.enfileira(aux);
            if (aux.getPlaca().equals(placa)){
                achar = aux;
            }
        }
        while (!estacionamento.estaVazia()) {
            auxiliar.enfileira(estacionamento.desenfileira());
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.enfileira(auxiliar.desenfileira());
        }
        if (achar == null){
            return "Não está no estacionamento";
        }
        return "Placa: " + achar.getPlaca() + " - Entrada: " + achar.getEntrada() + " - Posiçao: " + pos;
    }


    public Carro pegarCarro(String placa){
        if (estaVazio()) return null;
        Carro carro = null;
        Carro aux;
        while (!estacionamento.estaVazia()) {
            aux = estacionamento.desenfileira();
            if (aux.getPlaca().equals(placa)){
                carro = aux;
                auxiliar.enfileira(aux);
                while (!estacionamento.estaVazia()) {
                    auxiliar.enfileira(estacionamento.desenfileira());
                }
            }
            else{
                auxiliar.enfileira(aux);
            }
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.enfileira(auxiliar.desenfileira());
        }
        return carro;
    }

    @Override
    public String toString(){
        if (estaVazio()) return "Vazio";
        String texto = "";
        int pos = 1;
        Carro aux = null;
        while (!estacionamento.estaVazia()) {
            aux = estacionamento.desenfileira();
            auxiliar.enfileira(aux);
            texto += "Posicao: " + pos++ + " - " + aux + "\n";
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.enfileira(auxiliar.desenfileira());
        }
        return texto;
    }

}
