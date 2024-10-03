package TP2.funcionalidades;

import TP2.Utils.Utils;
import TP2.Utils.Utils2;
import TP2.model.*;
import TP2.trees.AVL;
import TP2.trees.BST;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Utils2 utils2 = new Utils2();
        Exercicio2 ex2 = new Exercicio2();
        Exercicio3 ex3 = new Exercicio3();
        Exercicio4 ex4 = new Exercicio4();
        Exercicio5 ex5 = new Exercicio5();
        /**
         * Exercicio 1---------------------------------------------
         */
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        AVL<Area> areas = new AVL<>();

        String fileNameFlags = "Production_Crops_Livestock_E_Flags.csv";
        utils2.uploadFlagsDescriptions(fileNameFlags, flagDescriptions);

        String fileNameGeoCoords = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileNameGeoCoords2 = "Production_Crops_Livestock_E_AreaCoordinates_shuffled_v2.csv";
        utils2.uploadGeoCoordinates(fileNameGeoCoords, geoCoordinates);
        utils2.uploadGeoCoordinates(fileNameGeoCoords2, geoCoordinates);

        String fileNameGlobalInfo = "Production_Crops_Livestock_EU_shuffle_large.csv";
        String fileNameGlobalInfo2 = "Production_Crops_Livestock_EU_shuffle_medium.csv";
        String fileNameGlobalInfo3 = "Production_Crops_Livestock_EU_shuffle_small.csv";
        String fileNameGlobalInfo4 = "Production_Crops_Livestock_World_shuffle_medium.txt";
        String fileNameGlobalInfo5 = "Production_Crops_Livestock_World_shuffle_small.txt";
        String fileNameGlobalInfo6 = "Production_Crops_Livestock_World_shuffle_large.txt";
        String fileNameGlobalInfo7 = "Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_large.csv";
        String fileNameGlobalInfo8 = "Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_medium.csv";
        String fileNameGlobalInfo9 = "Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv";

        //utils.uploadGlobalInfo(fileNameGlobalInfo, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo2, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo3, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo4, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo5, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo6, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo7, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo8, areas, geoCoordinates, flagDescriptions);
//        utils.uploadGlobalInfo(fileNameGlobalInfo9, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo2, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo3, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo4, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo5, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo6, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo7, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo8, areas, geoCoordinates, flagDescriptions);
        utils2.uploadGlobalInfo(fileNameGlobalInfo9, areas, geoCoordinates, flagDescriptions);

        /**
         * Exercicio 2 ---------------------------------------
         */
        String area = "Finland";
        HashMap<Item, Map<Element, Float>> ex2Return = new HashMap<>();

        ex2Return = ex2.mediaValoresEmXAnos(area, 1900, 2500, areas);
        ex2.printEx2Info(1900, 2500, ex2Return);

        /**
         * Exercicio 3----------------------------------------
         */
        ex3.imprimirMapa(ex3.topnareas("Potatoes", "Yield", areas), 3);

        /**
         * Exercicio 4-----------------------------------------
         */
        HashMap<Item, Map<Element, Float>> itemsReturn2 = ex2.mediaValoresEmXAnos(area, 1961, 2005, areas);
        //System.out.println(itemsReturn2.size());
        System.out.println("---------------------------------------");
        System.out.println("Exercício 4");
        double lat = 41.14961;
        double lon = -8.61099;
        String item = "Figs";
        String element = "Production";
        int year = 2018;
        try {
            ex4.printEx4Info(lat, lon, item, element, year, areas);
        } catch (Exception e) {
            System.out.println("2D Tree is empty");
        }
        //System.out.println(findArea(aresta, areas));

        /**
         * Exercicio 5-----------------------------------------
         */
        System.out.println("---------------------------------------");
        System.out.println("Exercicio 5");
        double logInicial = -12;
        double logFinal = 45;
        double latInicial = -11;
        double latFinal = 45;
        int itemCode = 401;
        int elementCode = 5419;
        int year1 = 2009;

        ex5.printEx5Info(logInicial,logFinal,latInicial,latFinal,itemCode,elementCode,year1,areas);
    }
}
