package TP2;

import TP2.Utils.Utils2;
import TP2.model.Area;
import TP2.model.Element;
import TP2.model.GeoCoordinates;
import TP2.model.Item;
import TP2.trees.AVL;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    Utils2 utils2 = new Utils2();

    @Test
    void Teste_LerCoordenadasGeograficas(){
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String testeFile = "testeGeoCoords.txt";
        boolean actual = utils2.uploadGeoCoordinates(testeFile, geoCoordinates);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void TesteFail_LerCoordenadasGeograficas(){
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String testeFile2 = "fail";
        boolean actual = utils2.uploadGeoCoordinates(testeFile2, geoCoordinates);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_QuantidadeCoordenadasGeograficas(){
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String testeFile = "testeGeoCoords.txt"; //lê 2 coordenadas geograficas iguais mas so contabiliza 1
        utils2.uploadGeoCoordinates(testeFile, geoCoordinates);
        int expected = 2;
        int actual = geoCoordinates.size();
        assertEquals(expected, actual);
    }

    @Test
    void TesteFail_QuantidadeCoordenadasGeograficas(){
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String testeFile = "testeGeoCoords.txt";
        utils2.uploadGeoCoordinates(testeFile, geoCoordinates);
        int expected = 3;
        int actual = geoCoordinates.size();
        assertNotEquals(expected, actual);
    }

    @Test
    void Teste_LerFlagsDescriptions(){
        HashMap<String, String> flagDescriptions = new HashMap<>();
        String testeFile = "testeFlags.txt";
        boolean actual = utils2.uploadFlagsDescriptions(testeFile, flagDescriptions);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void TesteFail_LerFlagsDescriptions(){
        HashMap<String, String> flagDescriptions = new HashMap<>();
        String testeFile2 = "fail";
        boolean actual = utils2.uploadFlagsDescriptions(testeFile2, flagDescriptions);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_QuantidadeLerFlagsDescriptions(){
        HashMap<String, String> flagDescriptions = new HashMap<>();
        String testeFile = "testeFlags.txt"; //lê 2 flags iguais mas so contabiliza 1
        utils2.uploadFlagsDescriptions(testeFile, flagDescriptions);
        int expected = 2;
        int actual = flagDescriptions.size();
        assertEquals(expected, actual);
    }

    @Test
    void TesteFail_QuantidadeLerFlagsDescriptions(){
        HashMap<String, String> flagDescriptions = new HashMap<>();
        String testeFile = "testeFlags.txt";
        utils2.uploadFlagsDescriptions(testeFile, flagDescriptions);
        int expected = 3;
        int actual = flagDescriptions.size();
        assertNotEquals(expected, actual);
    }

    @Test
    void Teste_LerGlobalInfo(){
        AVL<Area> areas = new AVL<>();
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String fileGeoCoordinates = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileFlags = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileGlobal = "testeGlobalInfo.txt";
        utils2.uploadFlagsDescriptions(fileFlags, flagDescriptions);
        utils2.uploadGeoCoordinates(fileGeoCoordinates, geoCoordinates);
        boolean actual = utils2.uploadGlobalInfo(fileGlobal, areas, geoCoordinates, flagDescriptions);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * Ficheiro de texto testeGlobalInfo.txt com todas as entradas possiveis para as restrições no metodo a ler a informação toda
     * 2 Areas diferentes
     * 2 Areas iguais - para ignorar uma
     * 2 Areas iguais com igual item, igual element mas years diferentes
     * 2 Areas iguais com igual item, mas elements diferentes
     * 2 Areas iguais com diferentes items
     */

    @Test
    void TesteFail_LerGlobalInfo(){
        AVL<Area> areas = new AVL<>();
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String fileGeoCoordinates = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileFlags = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileGlobal = "fail";
        utils2.uploadFlagsDescriptions(fileFlags, flagDescriptions);
        utils2.uploadGeoCoordinates(fileGeoCoordinates, geoCoordinates);
        boolean actual = utils2.uploadGlobalInfo(fileGlobal, areas, geoCoordinates, flagDescriptions);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_QuantidadeAreasLidas(){
        AVL<Area> areas = new AVL<>();
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String fileGeoCoordinates = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileFlags = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileGlobal = "testeGlobalInfo.txt";
        utils2.uploadFlagsDescriptions(fileFlags, flagDescriptions);
        utils2.uploadGeoCoordinates(fileGeoCoordinates, geoCoordinates);
        utils2.uploadGlobalInfo(fileGlobal, areas, geoCoordinates, flagDescriptions);
        int actual = areas.size();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_QuantidadeItemsLidosParaUmaArea(){
        AVL<Area> areas = new AVL<>();
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String fileGeoCoordinates = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileFlags = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileGlobal = "testeGlobalInfo.txt";
        utils2.uploadFlagsDescriptions(fileFlags, flagDescriptions);
        utils2.uploadGeoCoordinates(fileGeoCoordinates, geoCoordinates);
        utils2.uploadGlobalInfo(fileGlobal, areas, geoCoordinates, flagDescriptions);
        Area a = areas.findArea(areas.root(), "Saint Lucia");
        int actual = a.getItems().size();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_QuantidadeElementsLidosParaUmaAreaParaUmItem(){
        AVL<Area> areas = new AVL<>();
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String fileGeoCoordinates = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileFlags = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileGlobal = "testeGlobalInfo.txt";
        utils2.uploadFlagsDescriptions(fileFlags, flagDescriptions);
        utils2.uploadGeoCoordinates(fileGeoCoordinates, geoCoordinates);
        utils2.uploadGlobalInfo(fileGlobal, areas, geoCoordinates, flagDescriptions);
        Area a = areas.findArea(areas.root(), "Saint Lucia");
        Item i = a.getItems().findItem(a.getItems().root(), "Sugar cane");
        int actual = i.getElement().size();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_QuantidadeYearsLidosParaUmaAreaParaUmItemParaUmElement(){
        AVL<Area> areas = new AVL<>();
        HashMap<String, String> flagDescriptions = new HashMap<>();
        HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
        String fileGeoCoordinates = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileFlags = "Production_Crops_Livestock_E_AreaCoordinates_shuffled.csv";
        String fileGlobal = "testeGlobalInfo.txt";
        utils2.uploadFlagsDescriptions(fileFlags, flagDescriptions);
        utils2.uploadGeoCoordinates(fileGeoCoordinates, geoCoordinates);
        utils2.uploadGlobalInfo(fileGlobal, areas, geoCoordinates, flagDescriptions);
        Area a = areas.findArea(areas.root(), "Saint Lucia");
        Item i = a.getItems().findItem(a.getItems().root(), "Sugar cane");
        Element e = i.getElement().findYear(i.getElement().root(), "Yield");
        int actual = e.getYears().size();
        int expected = 2;
        assertEquals(expected, actual);
    }
}
