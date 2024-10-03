package TP2.funcionalidades;

import TP2.model.*;
import TP2.trees.AVL;
import TP2.trees.BST;
import org.w3c.dom.Node;

import java.util.*;

public class Exercicio2 {

    public HashMap<Item, Map<Element, Float>> mediaValoresEmXAnos(String area, int yInicio, int yFim, AVL<Area> areas) {

        HashMap<Item, Map<Element, Float>> itemsReturn2 = new HashMap<>();
        Map<Element, Float> mediaValuesPerElement = new TreeMap<>(Collections.reverseOrder());
        Area areaPesquisa = new Area();
        Value valueTemp;
        int contador = 0;
        float totalValues = 0;
        try{

            areaPesquisa = areas.findArea(areas.root(), area);

        }catch (NullPointerException error){
            System.out.println("No such area found");
        }

        for(Item i : areaPesquisa.getItems().inOrder()){
            for(Element e : i.getElement().inOrder()){
                for (Year y : e.getYears().inOrder()) {
                    if(y.getYear() >= yInicio && y.getYear() <= yFim){
                        valueTemp = y.getValue();
                        totalValues += valueTemp.getValue();
                        contador++;
                    }
                }
                //Verification for notc crashing in floating exception 0/0
                if(totalValues == 0){
                    mediaValuesPerElement.put(e, totalValues);
                }else{
                    mediaValuesPerElement.put(e, totalValues/contador);
                    totalValues = 0;
                    contador = 0;
                }
            }
            itemsReturn2.put(i, mediaValuesPerElement);
        }

        return itemsReturn2;
    }

    public void printEx2Info(int yInicio, int yFim,HashMap<Item, Map<Element, Float>> ex2Return){
        Map<Element, Float> mediaValuesPerElement;
        System.out.println("Media de Valores desde " + yInicio + " até " + yFim+ "\n");
        for (Item i : ex2Return.keySet()){
            mediaValuesPerElement = ex2Return.get(i);
            for(Element e : mediaValuesPerElement.keySet()){
                float mediaValue = mediaValuesPerElement.get(e);
                System.out.println("Item: " + i.getItem() + ", Element: " + e.getElement() + ", MediaValue: " + mediaValue + "\n");
            }
        }
    }
}
