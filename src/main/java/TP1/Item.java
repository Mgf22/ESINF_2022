package TP1;

public class Item {

    private String fruto;

    public Item(String fruto){
        if (this.isValidItem(fruto)) {
            this.fruto = fruto;
        }
    }

    public Item(){}


    public String getItem() {
        return fruto;
    }

    public void setFruto(String fruto) {
        this.fruto = fruto;
    }

    public boolean isValidItem(String fruto) {
        return fruto.length()!=0;
    }

    @Override
    public String toString() {
        return "fruto=" + fruto;
    }
}