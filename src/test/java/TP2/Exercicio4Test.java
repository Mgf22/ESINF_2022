package TP2;

import TP2.Utils.Utils;
import TP2.model.*;
import TP2.trees.AVL;
import TP2.trees.KdTree;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static TP2.funcionalidades.Exercicio4.*;
import static org.junit.jupiter.api.Assertions.*;

class Exercicio4Test {

    @Test
    void test_Exists_KDTree() {
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
        areaAvl.insert(area);
        String expected = "Finland";
        String actual = nearestCountry(20, 25, "Carrots and turnips", "Yield", 1981, areaAvl).getArea();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void test_Area_Null() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        Value value = new Value("hg/ha", 180088.000000F, "E", "Estimated value");
        Year year = new Year(1981, value);
        Element element = new Element(5419, "Yield", yearAvl);
        Item item = new Item(426, "'01251", "Carrots and turnips", elementAvl);
        Area area = null;
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () -> {
            nearestCountry(0, 0, "Dogs", "Production", 1500, areaAvl);
        });
    }

    @Test
    void test_Item_Null() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Value value = new Value("hg/ha", 180088.000000F, "E", "Estimated value");
        Year year = new Year(1981, value);
        Element element = new Element(5419, "Yield", yearAvl);
        Item item = null;
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () -> {
            nearestCountry(0, 0, "Dogs", "Production", 1500, areaAvl);
        });
    }

    @Test
    void test_Element_Null() {
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
        itemAvl.insert(item);
        elementAvl.insert(element);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () -> {
            nearestCountry(0, 0, "Dogs", "Production", 1500, areaAvl);
        });
    }

    @Test
    void test_Year_Null() {
        AVL<Area> areaAvl = new AVL<>();
        AVL<Item> itemAvl = new AVL<>();
        AVL<Element> elementAvl = new AVL<>();
        AVL<Year> yearAvl = new AVL<>();
        GeoCoordinates geoCoordinates = new GeoCoordinates(61.92411, 25.748151);
        Year year = null;
        Element element = new Element(5419, "Yield", yearAvl);
        Item item = new Item(426, "'01251", "Carrots and turnips", elementAvl);
        Area area = new Area(67, 246, "Finland", geoCoordinates, itemAvl);
        yearAvl.insert(year);
        elementAvl.insert(element);
        itemAvl.insert(item);
        areaAvl.insert(area);
        assertThrows(NullPointerException.class, () -> {
            nearestCountry(0, 0, "Dogs", "Production", 1500, areaAvl);
        });
    }
}
