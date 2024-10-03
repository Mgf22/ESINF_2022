package TP2.model;

import TP2.trees.AVL;
import TP2.trees.BST;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Year extends AVL<Year> implements Comparator<Year>, Comparable<Year> {
    private int year;
    private Value value;

    public Year(int year, Value value) {
        this.year = year;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }

    public int compare(Year o1, Year o2) {
        if (o1.getYear() > o2.getYear()){
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year)) return false;
        Year year1 = (Year) o;
        return getYear() == year1.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear());
    }

    @Override
    public int compareTo(Year o) {
        if (getYear() > o.getYear()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
