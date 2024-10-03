package TP1;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    Exercicio3 ex3 = new Exercicio3();
    Exercicio4 ex4 = new Exercicio4();
    Utils utils = new Utils();
    String ficheiro = "FAOSTAT_data_en_9-7-2022_BIG.csv";

    @Test
    void testminCountries() {
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        utils.uploadInfo(ficheiro, areaInfo);
        int actual = ex3.minCountries(999999999,areaInfo);
        int expected  = 1;
        assertEquals(expected,actual);
    }

    @Test
    void testminCountries2() {
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        utils.uploadInfo(ficheiro, areaInfo);
        boolean cond = true;
        int actual = 0;
        int expected = 27767800;
        Map<String, Integer> totalValue = new TreeMap<>();
        for (Map.Entry<String, TreeSet<Year>> mp : areaInfo.entrySet()) {
            int total = 0;
            for (Year year : mp.getValue()) {
                total = total + year.getValue().getQuantidade();
            }
            totalValue.put(mp.getKey(),total);
        }
        for (Map.Entry<String, Integer> s : totalValue.entrySet()) {
            if (s.getKey().equals("Afghanistan")){
                actual = s.getValue();
            }
        }
        if (expected != actual){
            cond = false;
        }
        assertFalse(cond);
    }

    @Test
    void testCrescimentoConsecutivo(){
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        utils.uploadInfo(ficheiro,areaInfo);
        Item fruto = new Item("Cherries");
        Map<Integer, Set<String>> mapa = ex4.crescimentoConsecutivo(fruto,areaInfo);
        Map<Integer, Set<String>> actual = new TreeMap<>();
        for (Map.Entry<Integer, Set<String>> sp: mapa.entrySet()){
            if (sp.getKey() == 19){
                actual.put(sp.getKey(),sp.getValue());
            }
        }
        Map<Integer, Set<String>> expected = new TreeMap<>();
        TreeSet set19 = new TreeSet<>();
        set19.add("Iran (Islamic Republic of)");
        expected.put(19,set19);
        assertEquals(expected,actual);
    }
    @Test
    void testCrescimentoConsecutivo2(){
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        utils.uploadInfo(ficheiro,areaInfo);
        Item fruto = new Item("Cherries");
        Map<Integer, Set<String>> mapa = ex4.crescimentoConsecutivo(fruto,areaInfo);
        Map<Integer, Set<String>> actual = new TreeMap<>();
        for (Map.Entry<Integer, Set<String>> sp: mapa.entrySet()){
            if (sp.getKey() == 18){
                actual.put(sp.getKey(),sp.getValue());
            }
        }
        Map<Integer, Set<String>> expected = new TreeMap<>();
        TreeSet set18 = new TreeSet<>();
        set18.add("Portugal");
        expected.put(18,set18);
        assertNotEquals(expected,actual);
    }
}