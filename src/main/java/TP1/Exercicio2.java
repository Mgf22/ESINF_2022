package TP1;

import java.util.*;

public class Exercicio2 {

    public SortedMap<String, Set<Year>> exercicio2(Item item, Value value, TreeMap<String, TreeSet<Year>> areaInfo){

        SortedMap<String, Set<Year>> paisesQuantidades= new TreeMap<>();
        HashMap<Item, Value> frutoInfo = new HashMap<>();
        int quantidadeTemp;

        for(String pais : areaInfo.keySet()){
            Set<Year> years = new HashSet<>();
            for(Year year : areaInfo.get(pais)){
                frutoInfo = year.getFrutoInfo();

                for(Item item2 : frutoInfo.keySet()){
                    if(item2.toString().equals(item.toString())){
                        quantidadeTemp = frutoInfo.get(item2).getQuantidade();

                        if(quantidadeTemp >= value.getQuantidade()){
                            years.add(year);
                        }
                    }
                }
            }
            paisesQuantidades.put(pais, years);
        }
        return paisesQuantidades;
    }

    public LinkedHashMap<String, Integer> sortedByAscendingYear(SortedMap<String, Set<Year>> paisesQuantidades){

        HashMap<Item, Value> frutoInfo = new HashMap<>();

        SortedMap<String, Integer> unsorted = new TreeMap<>();
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();

        for(String pais : paisesQuantidades.keySet()){

            for(Year year : paisesQuantidades.get(pais)){
                frutoInfo = year.getFrutoInfo();

                for(Item item2 : frutoInfo.keySet()){
                    int quantidade = frutoInfo.get(item2).getQuantidade();
                    unsorted.put(pais, quantidade);
                }
            }

        }

        unsorted.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

        return sorted;
    }

    public void printAllCountryWithQuantityHigher (SortedMap<String, Set<Year>> sortedMap){
        for (String pais : sortedMap.keySet()){
            for(Year ano : sortedMap.get(pais)){
                System.out.println("Pais: " + pais + " Ano: " + ano);
            }
        }
    }

    public void printCountrysQuantitiesSortedAscending (LinkedHashMap<String, Integer> sortedMap){
        for (String pais : sortedMap.keySet()){
            int quantidade = sortedMap.get(pais);
            System.out.println("Pais: " + pais + " Quantidade: " + quantidade);
        }
    }
}

