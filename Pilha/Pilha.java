public class Pilha <Info>{
    private No<Info> topo;
    private int tamanho;
    //construtor padrão 
    public boolean estaVazia() {
        return topo == null;
    }
    public void push (Info info) {
        No<Info> novo = new No<Info>(info);
        if (!estaVazia())
            novo.setProximo(topo);
        topo = novo;
        tamanho++;
    }
    public Info pop() {
        if (estaVazia()) return null;
        Info info = topo.getInfo();
        topo = topo.getProximo();
        tamanho--;
        return info;
    }
    @Override
    public String toString() {
        if (estaVazia())
            return "pilha vazia";
        else {
            String s = "";
            No<Info> no = topo;
            while (no != null) {
                s += no + "\n";
                no = no.getProximo();
            }
            return s;
        }
    }
    public int tamanhoPilha () {
        int cont=0;
        No<Info> no = topo;
        while (no != null) {
            cont++;
            no = no.getProximo();
        }
        return cont;
    }
    public Info consultaTopo () {
        return topo.getInfo();
    }
    public int getTamanho() {
        return tamanho;
    }
}
