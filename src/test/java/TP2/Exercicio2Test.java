package TP2;
import TP2.funcionalidades.Exercicio2;
import TP2.model.*;
import TP2.trees.AVL;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercicio2Test {

    Exercicio2 ex2 = new Exercicio2();

    @Test
    void Teste_ParaVerificarMediaDoValorMedioEspecifico(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2000;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        float actual = return2.get(item).get(element);
        float expected = 80;
        assertEquals(expected, actual);
    }

    @Test
    void TesteFail_ParaVerificarMediaDoValorMedioEspecifico(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2000;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        float actual = return2.get(item).get(element);
        float expected = 40;
        assertNotEquals(expected, actual);
    }

    @Test
    void Teste_ParaVerificarMediaDoValorMedioEspecificoComMaisValores(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Value value2 = new Value("unit1", 20, "flag1", "description1");
        Value value3= new Value("unit1", 20, "flag1", "description1");
        Year year = new Year(2000, value);
        Year year2 = new Year(2003, value2);
        Year year3 = new Year(2005, value3);
        years.insert(year);
        years.insert(year2);
        years.insert(year3);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2005;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        float actual = return2.get(item).get(element);
        float expected = 40;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_ParaVerificarMediaDoValorMedioEspecificoComMaisValoresComAnosNaoContabilizados(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Value value2 = new Value("unit1", 20, "flag1", "description1");
        Value value3= new Value("unit1", 20, "flag1", "description1");
        Year year = new Year(2000, value);
        Year year2 = new Year(2003, value2);
        Year year3 = new Year(2005, value3);
        years.insert(year);
        years.insert(year2);
        years.insert(year3);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2003;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        float actual = return2.get(item).get(element);
        float expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_ParaVerificarMediaDoValorMedioEspecificoSemAnosComValores(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Value value2 = new Value("unit1", 20, "flag1", "description1");
        Value value3= new Value("unit1", 20, "flag1", "description1");
        Year year = new Year(2000, value);
        Year year2 = new Year(2003, value2);
        Year year3 = new Year(2005, value3);
        years.insert(year);
        years.insert(year2);
        years.insert(year3);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2006;
        int yFim = 2007;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        float actual = return2.get(item).get(element);
        float expected = 0;
        assertEquals(expected, actual);
    }
    @Test
    void Teste_SeNaoEncontrarArea(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Finland";
        int yInicio = 2000;
        int yFim = 2000;

        assertThrows(NullPointerException.class, ()->{ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);});
    }

    @Test
    void Teste_SeNaoEncontrarNenhumItem(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = null;
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2000;

        assertThrows(NullPointerException.class, ()->{ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);});
    }

    @Test
    void Teste_SeNaoEcontrarNenhumElement(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Year year = new Year(2000, value);
        years.insert(year);
        Element element = null;
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2000;

        assertThrows(NullPointerException.class, ()->{ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);});
    }

    @Test
    void Teste_SeNaoEncontrarNenhumYear(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Year year = null;
        years.insert(year);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2000;

        assertThrows(NullPointerException.class, ()->{ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);});
    }

    @Test
    void Teste_ContabilizarNumeroDeItemsLidos(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Value value2 = new Value("unit1", 20, "flag1", "description1");
        Value value3= new Value("unit1", 20, "flag1", "description1");
        Year year = new Year(2000, value);
        Year year2 = new Year(2003, value2);
        Year year3 = new Year(2005, value3);
        years.insert(year);
        years.insert(year2);
        years.insert(year3);
        Element element = new Element(123, "element1", years);
        elements.insert(element);
        Item item = new Item(123, "321", "item1", elements);
        Item item2 = new Item(234, "322", "item2", elements);
        items.insert(item);
        items.insert(item2);

        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2005;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        int actual = return2.size();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void Teste_ContabilizarNumeroDeElementsLidos(){
        AVL<Area> areas = new AVL<>();
        AVL<Item> items = new AVL<>();
        AVL<Element> elements = new AVL<>();
        AVL<Year> years = new AVL<>();
        GeoCoordinates g1 = new GeoCoordinates(12, 15);
        Value value = new Value("unit1", 80, "flag1", "description1");
        Value value2 = new Value("unit1", 20, "flag1", "description1");
        Value value3= new Value("unit1", 20, "flag1", "description1");
        Year year = new Year(2000, value);
        Year year2 = new Year(2003, value2);
        Year year3 = new Year(2005, value3);
        years.insert(year);
        years.insert(year2);
        years.insert(year3);
        Element element = new Element(123, "element1", years);
        Element element2 = new Element(234, "element2", years);
        elements.insert(element);
        elements.insert(element2);
        Item item = new Item(123, "321", "item1", elements);
        items.insert(item);
        Area a = new Area(123, 321, "Belgica", g1, items);
        areas.insert(a);


        String area = "Belgica";
        int yInicio = 2000;
        int yFim = 2005;

        HashMap<Item, Map<Element, Float>> return2;
        return2 = ex2.mediaValoresEmXAnos(area,yInicio,yFim,areas);
        int actual = return2.get(item).size();
        int expected = 2;
        assertEquals(expected, actual);
    }
}
