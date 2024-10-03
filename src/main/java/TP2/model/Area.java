package TP2.model;

import TP2.trees.AVL;
import TP2.trees.BST;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Area extends AVL<Area> implements Comparator<Area>, Comparable<Area> {

    private int areaCode;
    private int codeM49;
    private String area;
    private GeoCoordinates geoCoordinates;
    private AVL<Item> items;

    public Area(){

    }
    public Area(int areaCode, int codeM49, String area, GeoCoordinates geoCoordinates,AVL<Item> items) {
        this.areaCode = areaCode;
        this.codeM49 = codeM49;
        this.area = area;
        this.geoCoordinates = geoCoordinates;
        this.items = items;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getCodeM49() {
        return codeM49;
    }

    public void setCodeM49(int codeM49) {
        this.codeM49 = codeM49;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public GeoCoordinates getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public AVL<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
        this.items.insert(item);
    }

    public Set<Item> uploadInfo(Set<Item> items, Item item){
        items.add(item);
        return items;
    }

    @Override
    public String toString() {
        return area;
    }

    @Override
    public int compare(Area o1, Area o2) {
        return o1.getArea().compareTo(o2.getArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return getAreaCode() == area.getAreaCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAreaCode());
    }

    @Override
    public int compareTo(Area o) {
        return getArea().compareTo(o.getArea());
    }
}
