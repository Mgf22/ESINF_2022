package TP1;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.*;

public class Exercicio4 {

    public static Map<Integer, Set<String>> crescimentoConsecutivo(Item fruto, TreeMap<String, TreeSet<Year>> areaInfo) { // Year ou Integer? // Recebe quantidade ou só o fruto?
        Map<Integer, Set<String>> mapa = new TreeMap<>();
        int suporte = 0;
        Item item33 = new Item("Apples");
        Value valor = new Value("999999999");
        for (String pais : areaInfo.keySet()) {
            Year yearsupport = new Year("1800", item33, valor);
            int tempMax = 0;
            int temp = 0;
            Set<String> paisSet = new TreeSet<>();
            for (Year year : areaInfo.get(pais)) {
                //  for (Item item : year.getFrutoInfo().keySet()) {
                if (year.getItem().getItem().equals(fruto.getItem())) {

                    if (year.getValue().getQuantidade() > yearsupport.getValue().getQuantidade()) {
                        temp++;
                    }
                    if (year.getValue().getQuantidade() <= yearsupport.getValue().getQuantidade()) {
                        temp = 0;
                    }

                    if (temp > tempMax) {
                        tempMax = temp;
                    }
                    yearsupport = year;

                }

            }

            if (!mapa.isEmpty()) {
                if (mapa.containsKey(tempMax)) {
                    mapa.get(tempMax).add(pais);
                }
                if (!mapa.containsKey(tempMax)) {
                    paisSet.add(pais);
                    mapa.put(tempMax, paisSet);
                }
            }

            if (mapa.isEmpty()) {
                paisSet.add(pais);
                mapa.put(tempMax, paisSet);


            }

        }
        return mapa;
    }

    public static void imprimirMapa(Map<Integer, Set<String>> mapa) {
        for (Map.Entry<Integer, Set<String>> sp : mapa.entrySet()) {
            System.out.println(sp.getKey() + " " + sp.getValue());

        }


    }
}
