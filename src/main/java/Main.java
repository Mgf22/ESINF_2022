//package TP1;
//
//import java.util.*;
//
//import static TP1.Exercicio3.minCountries;
//import static TP1.Exercicio4.crescimentoConsecutivo;
//import static java.util.stream.Collectors.toMap;
//
//public class TP2.funcionalidades.Main {
//
//    public static void main(String[] args) {
//
//        Exercicio2 ex2 = new Exercicio2();
//        Exercicio3 ex3 = new Exercicio3();
//        Exercicio4 ex4 = new Exercicio4();
//        String ficheiro = "FAOSTAT_data_en_9-7-2022_BIG.csv";
//        Utils utils = new Utils();
//        TreeMap<String, TreeSet<Year>> areaInfo = new TreeMap<>();
//        utils.uploadInfo(ficheiro, areaInfo);
//        Item item2 = new Item("Cherries");
//        Value value2 = new Value("500000");
//        System.out.println("Exercício 2");
//
//        SortedMap<String,Set<Year>> paisesQuantidades= new TreeMap<>();
//
//        paisesQuantidades = ex2.exercicio2(item2, value2, areaInfo);
//
//        //ex2.printAllCountryWithQuantityHigher(paisesQuantidades);
//
//        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
//
//        sortedMap = ex2.sortedByAscendingYear(paisesQuantidades);
//
//        ex2.printCountrysQuantitiesSortedAscending(sortedMap);
//        System.out.println("---------------------------------------");
//        System.out.println("Exercício 3");
//        long quant = 1886178942;
//        System.out.println("Minimum number of countries with quantity over "+quant+" is: " + minCountries(quant, areaInfo));
//        System.out.println("---------------------------------------");
//        System.out.println("Exercício 4");
//        ex4.imprimirMapa(crescimentoConsecutivo(item2,areaInfo));
//        System.out.println("---------------------------------------");
//        System.out.println("Exercício 5");
//        System.out.println(ParDeAnos.Ex5("Spain",areaInfo));
//        System.out.println("---------------------------------------");
//    }
//}
