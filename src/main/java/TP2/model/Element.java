package TP2.model;

import TP2.trees.AVL;

import java.util.Comparator;
import java.util.Objects;

public class Element extends AVL<Element> implements Comparator<Element>, Comparable<Element> {

    private int elementCode;
    private String element;
    private AVL<Year> years;

    public Element(int elementCode, String element, AVL<Year> years) {
        this.elementCode = elementCode;
        this.element = element;
        this.years = years;
    }

    public AVL<Year> getYears() {
        return years;
    }

    public void setYears(Year year) {
        this.years.insert(year);
    }

    public int getElementCode() {
        return elementCode;
    }

    public void setElementCode(int elementCode) {
        this.elementCode = elementCode;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }

    public int compare(Element o1, Element o2) {
        return o1.getElement().compareTo(o2.getElement());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return getElementCode() == element.getElementCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElementCode());
    }

    @Override
    public int compareTo(Element o) {
        return getElement().compareTo(o.getElement());
    }
}
