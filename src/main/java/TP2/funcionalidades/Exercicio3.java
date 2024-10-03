package TP2.funcionalidades;

import TP2.model.*;
import TP2.trees.AVL;


import java.util.*;
import java.util.stream.Collectors;


public class Exercicio3 {

    public TreeMap<Float, String> topnareas(String item, String element, AVL<Area> areas) {
        TreeMap<Float, String> returnAreas = new TreeMap<>(Collections.reverseOrder());

        float qtd = 0;

        for (Area a : areas.preOrder()) {
            for (Item it : a.getItems().preOrder()) {
                for (Element el : it.getElement().preOrder()) {
                    if (el.getElement().equalsIgnoreCase(element) && it.getItem().equalsIgnoreCase(item)) {
                        qtd = el.getYears().biggestElement().getValue().getValue();
                        returnAreas.put(qtd,a.getArea());
                        }
                    }
                }
            }
        return returnAreas;
    }


    public void imprimirMapa(TreeMap<Float, String> topnareas, int n) {
        int contador = 0;
        for (Map.Entry<Float, String> mp : topnareas.entrySet()) {
            if (contador < n) {
            System.out.println(mp.getKey() + " " + mp.getValue());
            contador++;
            }
        }

    }


}