package TP1;

import java.util.*;

public class ParDeAnos {
    static HashMap<Item, Value> frutoInfo1 = new HashMap<>();
    static ArrayList<String> numberItems = new ArrayList<>();

    public static int fruitCounter(String pais, TreeMap<String, TreeSet<Year>> areaInfo) {
        List<Year> stringList = new ArrayList<>(areaInfo.get(pais));
        for (String pa : areaInfo.keySet()) {
            //System.out.println(pais);
            for (Year year : areaInfo.get(pais)) {
                frutoInfo1 = year.getFrutoInfo();
                for (int i = 0; i < stringList.size() - 1; i++) {
                    if (numberItems.isEmpty()){
                        numberItems.add(year.getItem().getItem());
                    }else{
                        if (numberItems.contains(year.getItem().getItem())){
                            break;
                        }else{
                            numberItems.add(year.getItem().getItem());
                        }
                    }
                }
            }
        }
        return numberItems.size();
    }

    //for each para em cada pais ir buscar todos os valores e comparar ano a ano qual tem a maior diferenca de produção
    //Math.abs--- modulo
    public static String Ex5(String pais, TreeMap<String, TreeSet<Year>> areaInfo) {
        List<Year> stringsList = new ArrayList<>(areaInfo.get(pais));
        List<Item> frutas = new ArrayList<Item>(stringsList.get(0).getFrutoInfo().keySet());
        String max = "";
        int max1 = 0;
        int counter = fruitCounter(pais, areaInfo);
        Item maxFruta = null;
        for (Item fruta : frutas) {
            for (int i = 0; i < areaInfo.size() - 1; i++) {
                Year year1 = stringsList.get(i);
                Year year2 = stringsList.get(i + counter);
                if (year1.getItem().getItem().equals(year2.getItem().getItem())) {
                    int difference = Math.abs(year1.getValue().getQuantidade() - year2.getValue().getQuantidade());
                    if (difference > max1) {
                        max1 = difference;
                        maxFruta = fruta;
                        max = year1.getYear() + "/" + year2.getYear();
                    }
                }
            }
        }

        return ("[" + max + ", " + maxFruta.getItem() + "," + max1 + "]");
    }


}











