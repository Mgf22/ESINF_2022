package TP2.funcionalidades;

import TP2.model.*;
import TP2.trees.AVL;
import TP2.trees.KdTree;

public class Exercicio4 {
    public static Area nearestCountry(double lat, double lon, String item, String element, int year, AVL<Area> avl) {
        KdTree<Area> kd = new KdTree();
        for (Area area : avl.inOrder()) {
            if (area.getItems().existsItem(item)) {
                Item i = area.getItems().findItem(area.getItems().root(), item);
                if (i.getElement().existsElement(element)) {
                    Element e = i.getElement().findElement(i.getElement().root(), element);
                    if (e.getYears().existsYear(year)) {
                        kd.insert(area, area.getGeoCoordinates().getLatitude(), area.getGeoCoordinates().getLongitude());
                    }
                }
            }
        }
        return kd.findNearestNeighbour(lat, lon);
    }

    public static void printEx4Info(double lat, double lon, String item, String element, int year, AVL<Area> avl){
        Area nearest = nearestCountry(lat, lon, item, element, year, avl);
        System.out.println("Area code: " + nearest.getAreaCode()
                + "\nCodeM49: " + nearest.getCodeM49()
                + "\nArea: " + nearest.getArea()
                + "\nLatitude: " + nearest.getGeoCoordinates().getLatitude()
                + "\nLongitude: " + nearest.getGeoCoordinates().getLongitude());
    }
}
