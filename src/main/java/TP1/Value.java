package TP1;

public class Value {
    private int quantidade;

    public Value(String quantidade){
        if(!quantidade.equals("") && !quantidade.equals("tonnes")){
            this.quantidade = Integer.parseInt(quantidade);
        }else {
            this.quantidade = 0;
        }
    }

    public Value(){}

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "quantidade=" + quantidade;
    }
}
