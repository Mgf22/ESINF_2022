package TP2.funcionalidades;

import TP2.model.*;
import TP2.trees.AVL;
import TP2.trees.KdTree;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Exercicio5 {
    static ArrayList<Area> listAreas = new ArrayList<>();



    public static Double exercicio5 (double logInicial, double logFinal, double latInicial, double latFinal, int itemCode, int elementCode, int year, AVL<Area> avl) {
        double valorRetangulo = 0;
        KdTree<Area> kd = new KdTree(); //o(1)
        GeoCoordinates min= new GeoCoordinates(latInicial, logInicial); //o(1)
        GeoCoordinates max= new GeoCoordinates(latFinal, logFinal); //o(1)
        for (Area a: avl.inOrder()){  //o(n)
                if (a.getGeoCoordinates()==null)
                    continue;
            //System.out.println(a.getArea());
            kd.insert(a,a.getGeoCoordinates().getLatitude(),a.getGeoCoordinates().getLongitude()); //o(log n)
        }
        for (Area ah : kd.inOrder()) { //o(n)
            if      (ah.getGeoCoordinates().getLatitude() >= min.getLatitude() &&
                    ah.getGeoCoordinates().getLatitude() <= max.getLatitude() &&
                    ah.getGeoCoordinates().getLongitude() >= min.getLongitude() &&
                    ah.getGeoCoordinates().getLongitude() <= max.getLongitude())
                listAreas.add(ah);  //o(1)
        }
        for (Area a : listAreas) {//o(n)
            for (Item ite : a.getItems().inOrder()) {//o(n)
                if (ite.getItemCode()==(itemCode)) {
                    for (Element ele : ite.getElement().inOrder()) {//o(n)
                        if (ele.getElementCode()==(elementCode)) {
                            for (Year y : ele.getYears().inOrder()) {//o(n)
                                if (y.getYear() == year) {
                                    valorRetangulo= valorRetangulo + y.getValue().getValue();
                                }
                            }
                        }
                    }
                }
            }
        }
        return valorRetangulo;
    }

    public void printEx5Info(double logInicial, double logFinal, double latInicial, double latFinal, int itemCode, int elementCode, int year, AVL<Area> avl){
        Double value = exercicio5(logInicial,logFinal,latInicial,latFinal,itemCode,elementCode,year, avl);
        System.out.printf("O acumulado de valores na area retangular %f toneladas", value);
    }


}
