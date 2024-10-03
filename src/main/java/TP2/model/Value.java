package TP2.model;

import TP1.Year;

import java.util.Comparator;

public class Value implements Comparator<Value>, Comparable<Value> {

    private String unit;
    private float value;
    private String flag;
    private String description;

    public Value(String unit, float value, String flag, String description) {
        this.unit = unit;
        this.value = value;
        this.flag = flag;
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Value{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                ", flag='" + flag + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int compare(Value o1, Value o2) {
        if (o1.getValue() > o2.getValue()){
            return 1;
        }
        else{
            return -1;
        }
    }

    public int compareTo(Value o) {
        if (value == o.value){
            return 0;
        }
        else if (value > o.value){
            return 1;
        }
        else {
            return -1;
        }
    }
}

