public class Estacionamento{
    
    private Pilha<Carro> estacionamento;
    private Pilha<Carro> auxiliar;
    private int tamanho;
    private int ocupacao;

    public Estacionamento(int tamanho){
        estacionamento = new Pilha<>();
        auxiliar = new Pilha<>();
        this.tamanho = tamanho;
        ocupacao = 0;
    }

    public boolean estaVazio(){
        return estacionamento.estaVazia();
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public boolean estaCheio(){
        return estacionamento.getTamanho() == tamanho;
    }

    public boolean estacionar(Carro carro){
        if (estaCheio()) return false;
        estacionamento.push(carro);
        ocupacao++;
        return true;
    }

    // Verifica se o carro esta no estacionamento
    public String verificarCarro(String placa){
        if (estaVazio()) return "Não está no estacionamento";
        int pos = 0;
        Carro achar = null;
        while (!estacionamento.estaVazia() && achar == null) {
            pos++;
            auxiliar.push(estacionamento.pop());
            if (auxiliar.consultaTopo().getPlaca().equals(placa)){
                achar = auxiliar.consultaTopo();
            }
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.push(auxiliar.pop());
        }
        if (achar == null){
            return "Não está no estacionamento";
        }
        return "Placa: " + achar.getPlaca() + " - Entrada: " + achar.getEntrada() + " - Posiçao: " + pos;
    }

    public Carro pegarCarro(String placa){
        if (estaVazio()) return null;
        Carro achar = null;
        while (!estacionamento.estaVazia() && achar == null) {
            auxiliar.push(estacionamento.pop());
            if (auxiliar.consultaTopo().getPlaca().equals(placa)){
                achar = auxiliar.consultaTopo();
            }
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.push(auxiliar.pop());
        }
        if (achar == null){
            return null;
        }
        return achar;
    }

    // Retorna -1 se o carro nao esta no estacionamento
    public Carro sair(String placa){
        if (estaVazio()) return null;
        Carro saiu = null;
        while (!estacionamento.estaVazia() && saiu == null) {
            auxiliar.push(estacionamento.pop());
            if (auxiliar.consultaTopo().getPlaca().equals(placa)){
                saiu = auxiliar.pop();
            }
            else{
                auxiliar.consultaTopo().manobrar();
            }
        }
        if (saiu == null){ // Carro nao esta no estacionamento
            while (!auxiliar.estaVazia()) {
                estacionamento.push(auxiliar.pop());
            }
            return null;
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.push(auxiliar.pop());
            estacionamento.consultaTopo().manobrar();
        }
        ocupacao--;
        return saiu;
    }
    
    @Override
    public String toString(){
        if (estaVazio()) return "Vazio";
        String texto = "";
        int pos = 1;
        while (!estacionamento.estaVazia()) {
            auxiliar.push(estacionamento.pop());
            texto += "Posicao: " + pos++ + " - " + auxiliar.consultaTopo() + "\n";
        }
        while (!auxiliar.estaVazia()) {
            estacionamento.push(auxiliar.pop());
        }
        return texto;
    }

}