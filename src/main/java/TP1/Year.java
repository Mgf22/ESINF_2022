package TP1;

import java.util.HashMap;
import java.util.Map;

public class Year {

    private int year;
    private Item item;
    private Value value;
    private HashMap<Item, Value> frutoInfo = new HashMap<>();


    public Year(String year,Item item, Value value){
        if(!year.equals("")){
            this.year = Integer.parseInt(year);
        }else {
            this.year = 0;
        }
        this.item = item;
        this.value = value;
        frutoInfo.put(item, value);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public HashMap<Item, Value> getFrutoInfo() {
        return frutoInfo;
    }

    public void setFrutoInfo(HashMap<Item, Value> frutoInfo) {
        this.frutoInfo = frutoInfo;
    }

    @Override
    public String toString() {
        return  "year=" + year +
                ", item=" + item +
                ", value=" + value;
    }
}
