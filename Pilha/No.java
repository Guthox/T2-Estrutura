public class No<Info> {
    private Info info;
    private No<Info> proximo;
    public No(Info info) {
        this.info = info;
        this.proximo = null;
    }
    public Info getInfo() {
        return info;
    }
    public No<Info> getProximo() {
        return proximo;
    }
    public void setInfo (Info info) {
        this.info = info;
    }
    public void setProximo (No<Info> proximo) {
        this.proximo = proximo;
    }
    @Override 
    public String toString () {
        return "|" + info + "|";
    }
}