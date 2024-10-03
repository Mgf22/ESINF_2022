package TP2;

import TP2.Utils.Utils;
import TP2.funcionalidades.Exercicio3;
import TP2.model.*;
import TP2.trees.AVL;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class Exercicio3Test {

    Utils utils = new Utils();
    HashMap<String, String> flagDescriptions = new HashMap<>();
    HashMap<String, GeoCoordinates> geoCoordinates = new HashMap<>();
    AVL<Area> areas = new AVL<>();
    String fileNameFlags = "Production_Crops_Livestock_E_Flags.csv";
    String fileNameGeoCoords = "Production_Crops_Livestock_E_AreaCoordinates_shuffled_v2.csv";
    String fileNameGlobalInfo = "Production_Crops_Livestock_EU_shuffle_large.csv";

    @Test
    void testTopNAreascomFicheiroPassa() {
        Exercicio3 ex3 = new Exercicio3();
        utils.uploadFlagsDescriptions(fileNameFlags, flagDescriptions);
        utils.uploadGeoCoordinates(fileNameGeoCoords, geoCoordinates);
        utils.uploadGlobalInfo(fileNameGlobalInfo, areas, geoCoordinates, flagDescriptions);
        TreeMap <Float, String> expected = new TreeMap<>();
        expected.put(190451F,"Austria");
        TreeMap<Float, String> actual = new TreeMap<>();
        actual = ex3.topnareas("Potatoes","Yield", areas);
        assertEquals(expected, actual);
    }

    @Test
    void testTopNAreas2comFicheiroNaoPassa() {
        Exercicio3 ex3 = new Exercicio3();
        utils.uploadFlagsDescriptions(fileNameFlags, flagDescriptions);
        utils.uploadGeoCoordinates(fileNameGeoCoords, geoCoordinates);
        utils.uploadGlobalInfo(fileNameGlobalInfo, areas, geoCoordinates, flagDescriptions);
        TreeMap <String, Float> expected = new TreeMap<>();
        expected.put("Nigéria",2000000F);
        TreeMap<Float, String> actual = new TreeMap<>();
        actual = ex3.topnareas("Potatoes","Yield", areas);
        assertNotEquals(expected, actual);
    }



    @Test
    void testTopNAreas3SemFicheiroPassa() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 451365F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Yield", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Potatoes", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgium-Luxembourg", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertEquals(mapaExpectavel,mapaRetorno);

    }


    @Test
    void testTopNAreas3SemFicheiroNaoPassa() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 45F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Harvested", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Potatoes", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgium-Luxembourg", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertNotEquals(mapaExpectavel,mapaRetorno);

    }

    @Test
    void testTopNAreas3SemFicheiroNaoPassaAreasDiferentes() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 451365F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Yield", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Potatoes", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Denmark", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertNotEquals(mapaExpectavel,mapaRetorno);

    }


    @Test
    void testTopNAreas3SemFicheiroNaoPassaQuantidadesDiferentes() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 451F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Yield", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Potatoes", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgium-Luxembourg", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertNotEquals(mapaExpectavel,mapaRetorno);

    }


    @Test
    void testTopNAreas3SemFicheiroNaoPassaItemsDiferentes() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 451365F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Yield", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Bananas", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgium-Luxembourg", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertNotEquals(mapaExpectavel,mapaRetorno);

    }

    @Test
    void testTopNAreas3SemFicheiroNaoPassaElementsDiferentes() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 451365F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Harvested", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Potatoes", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgium-Luxembourg", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertNotEquals(mapaExpectavel,mapaRetorno);

    }



    @Test
    void testTopNAreasVazia() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        Exercicio3 ex3 = new Exercicio3();
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);


        assertEquals(mapaExpectavel,mapaRetorno);

    }

    @Test
    void testTopNAreasVazia2() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        Exercicio3 ex3 = new Exercicio3();
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);
        mapaExpectavel.put(12040F,"China");


        assertNotEquals(mapaExpectavel,mapaRetorno);

    }

    @Test
    void testimprimirMapa() {
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(56.26392, 9.501785);
        Value value = new Value("unit1", 451365F, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "Yield", years);
        elements.insert(element);
        Item item = new Item(123, "321", "Potatoes", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgium-Luxembourg", g1, items);
        areas.insert(a);
        Exercicio3 ex3 = new Exercicio3();

        TreeMap <Float,String> mapaRetorno = new TreeMap<>();
        TreeMap <Float, String> mapaExpectavel = new TreeMap<>();

        mapaExpectavel.put(451365F,"Belgium-Luxembourg");
        mapaRetorno = ex3.topnareas("Potatoes","Yield",areas);

        assertNotEquals("",mapaRetorno);

    }






}
