package TP1;

import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercicio2Test {

    Exercicio2 ex2 = new Exercicio2();
    Utils utils = new Utils();
    String ficheiro = "FAOSTAT_data_en_9-7-2022_BIG.csv";

    @Test
    void testPaisesComMaiorQuantidadepedida() {
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        SortedMap<String, Set<Year>> paisesQuantidades= new TreeMap<>();
        utils.uploadInfo(ficheiro, areaInfo);
        Item item = new Item("Apples");
        Value value = new Value("100000");
        paisesQuantidades = ex2.exercicio2(item, value, areaInfo);
        int actual = paisesQuantidades.size();
        int expected = 187;
        assertEquals(expected,actual);
    }

    @Test
    void testQuantidadeAverificarMaiorQueQualquerProducao() {
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        SortedMap<String, Set<Year>> paisesQuantidades= new TreeMap<>();
        utils.uploadInfo(ficheiro, areaInfo);
        Item item = new Item("Apples");
        Value value = new Value("10000000");
        paisesQuantidades = ex2.exercicio2(item, value, areaInfo);
        int actual = paisesQuantidades.size();
        int expected = 0;
        assertEquals(expected,actual);
    }

    @Test
    void testNaoExistirFruto() {
        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
        SortedMap<String, Set<Year>> paisesQuantidades= new TreeMap<>();
        utils.uploadInfo(ficheiro, areaInfo);
        Item item = new Item("Diogo");
        Value value = new Value("100000");
        paisesQuantidades = ex2.exercicio2(item, value, areaInfo);
        int actual = paisesQuantidades.size();
        int expected = 0;
        assertEquals(expected,actual);
    }

}
