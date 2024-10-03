package TP2.model;

import TP2.trees.AVL;
import TP2.trees.BST;

import java.util.Comparator;
import java.util.Objects;

public class Item implements Comparator<Item>, Comparable<Item> {

    private int itemCode;
    private String itemCPC;
    private String item;
    private AVL<Element> elements;

    public Item(int itemCode, String itemCPC, String item, AVL<Element> elements) {
        this.itemCode = itemCode;
        this.itemCPC = itemCPC;
        this.item = item;
        this.elements = elements;
    }

    public AVL<Element> getElement() {
        return elements;
    }

    public void setElement(Element element) {
        this.elements.insert(element);
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCPC() {
        return itemCPC;
    }

    public void setItemCPC(String itemCPC) {
        this.itemCPC = itemCPC;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    @Override
    public String toString() {
        return item;
    }

    public int compare(Item o1, Item o2) {
        return o1.getItem().compareTo(o2.getItem());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getItemCode() == item.getItemCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemCode());
    }

    @Override
    public int compareTo(Item o) {
        return getItem().compareTo(o.getItem());
    }
}
