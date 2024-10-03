package TP1;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Exercicio3 {

    public static int minCountries(long quant, TreeMap<String, TreeSet<Year>> areaInfo) {
        int count = 0;
        long minQuant = 0;
        Map<String, Integer> totalValue = new TreeMap<>();
        for (Map.Entry<String, TreeSet<Year>> mp : areaInfo.entrySet()) {
            int total = 0;
            for (Year year : mp.getValue()) {
                total = total + year.getValue().getQuantidade();
            }
            totalValue.put(mp.getKey(), total);
        }
        Map<String, Integer> sorted;
        sorted = totalValue.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<String, Integer> s : sorted.entrySet()) {
            if (s.getValue() > quant) {
                count = 1;
                break;
            } else if (minQuant > quant) {
                break;
            } else {
                minQuant += s.getValue();
                count++;
            }
        }
        return count;
    }
}
