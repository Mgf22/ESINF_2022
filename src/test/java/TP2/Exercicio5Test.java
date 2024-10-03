package TP2;

import TP2.model.*;
import TP2.trees.AVL;
import org.junit.jupiter.api.Test;

import static TP2.funcionalidades.Exercicio4.nearestCountry;
import static TP2.funcionalidades.Exercicio5.exercicio5;
import static org.junit.jupiter.api.Assertions.*;

class Exercicio5Test {

    @Test
    void testexercicio5() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Value value = new Value("hg/ha", 180088.000000F, "E", "Estimated value");
        Year year = new Year(1981, value);
        Element element = new Element(5419, "Yield", yearAvl);
        Item item = new Item(426, "'01251", "Carrots and turnips", elementAvl);
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        elementAvl.insert(element);
        areaAvl.insert(area);
        Double expected = 180088.000000;
        Double actual = exercicio5(-12,45,-11,62,426,5419,1981, areaAvl);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testexercicio5ItemNull() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Value value = new Value("hg/ha", 180088.000000F, "E", "Estimated value");
        Year year = new Year(1981, value);
        Element element = new Element(5419, "Yield", yearAvl);
       // Item item = new Item(0, "'01251", "Carrots and turnips", elementAvl);
        Item item = null;
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        elementAvl.insert(element);
        areaAvl.insert(area);
        //Double expected = 0.0;
        //Double actual = exercicio5(-12,45,-11,62,426,5419,1981, areaAvl);
        //System.out.println(actual);
        assertThrows(NullPointerException.class, () ->{exercicio5(-12,45,-11,62,426,5419,1981, areaAvl);});
    }

    @Test
    void testexercicio5ElementNull() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Value value = new Value("hg/ha", 180088.000000F, "E", "Estimated value");
        Year year = new Year(1981, value);
        Element element = null;
        Item item = new Item(426, "'01251", "Carrots and turnips", elementAvl);
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () ->{exercicio5(-12,45,-11,62,426,5419,1981, areaAvl);});
    }

    @Test
    void testexercicio5YearNull() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Value value = new Value("hg/ha", 180088.000000F, "E", "Estimated value");
        Year year = null;
        Element element =new Element(5419, "Yield", yearAvl);
        Item item = new Item(426, "'01251", "Carrots and turnips", elementAvl);
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () ->{exercicio5(-12,45,-11,62,426,5419,1981, areaAvl);});
    }

    @Test
    void testexercicio5ValueNull() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Value value = null;
        Year year = new Year(1981, value);
        Element element =new Element(5419, "Yield", yearAvl);
        Item item = new Item(426, "'01251", "Carrots and turnips", elementAvl);
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () ->{exercicio5(-12,45,-11,62,426,5419,1981, areaAvl);});
    }

}