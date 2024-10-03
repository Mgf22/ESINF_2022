package TP2.Utils;

import TP2.model.*;
import TP2.trees.AVL;
import TP2.trees.BST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Utils {

    private static final String SEPARATOR = ",";

    public void uploadGeoCoordinates(String filename, HashMap<String, GeoCoordinates> geoCoordinates) {

        String area;
        float latitude;
        float longitude;

        File file = new File(filename);

        try {
            Scanner readFile = new Scanner(file);
            readFile.nextLine();

            while (readFile.hasNext()) {
                String line = readFile.nextLine();
                String[] aux = line.split(SEPARATOR);

                latitude = Float.parseFloat(aux[1]);
                longitude = Float.parseFloat(aux[2]);
                area = aux[3];
                GeoCoordinates geoCoord = new GeoCoordinates(latitude, longitude);
                if (!geoCoordinates.containsKey(area)) {
                    geoCoordinates.put(area, geoCoord);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            ;
        }

    }

    public void uploadFlagsDescriptions(String filename, HashMap<String, String> flagDescriptions) {

        String flag;
        String description;

        File file = new File(filename);

        try {
            Scanner readFile = new Scanner(file);
            readFile.nextLine();

            while (readFile.hasNext()) {
                String line = readFile.nextLine();
                String[] aux = line.split(SEPARATOR);

                if (aux.length == 2) {
                    flag = aux[0];
                    description = aux[1];
                    if (flagDescriptions.get(flag) == null) {
                        flagDescriptions.put(flag, description);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            ;
        }

    }

    public void uploadGlobalInfo(String filename, AVL<Area> areas, HashMap<String, GeoCoordinates> geoCoordinates, HashMap<String, String> flagDescriptions) {
        int areaCode;
        int codeM49;
        String area;

        int itemCode;
        String itemCPC;
        String item;

        int elementCode;
        String element;

        int year;

        String unit;
        float value;
        String flag;

        AVL<Integer> areasCodes = new AVL<>();

        File file = new File(filename);

        try {
            Scanner readFile = new Scanner(file);
            readFile.nextLine();

            while (readFile.hasNext()) {
                String line = readFile.nextLine();
                String[] aux = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);


                areaCode = Integer.parseInt(aux[0].replaceAll("\"", ""));
                codeM49 = Integer.parseInt(aux[1].replaceAll("\"", "").substring(1));
                area = aux[2].replaceAll("\"", "");


                itemCode = Integer.parseInt(aux[3].replaceAll("\"", ""));
                itemCPC = aux[4].replaceAll("\"", "").substring(1);

                item = (aux[5].replaceAll("\"", ""));
                elementCode = Integer.parseInt(aux[6].replaceAll("\"", ""));
                element = aux[7].replaceAll("\"", "");

                year = Integer.parseInt(aux[9].replaceAll("\"", ""));

                unit = aux[10].replaceAll("\"", "");
                if (!aux[11].isEmpty()) {
                    value = Float.parseFloat(aux[11].replaceAll("\"", ""));
                } else {
                    value = 0;
                }
                flag = aux[12].replaceAll("\"", "");

                GeoCoordinates geoCoordinates1 = geoCoordinates.get(area);
                String flagDescription = flagDescriptions.get(flag);

                if (!areasCodes.exists(areaCode)) {
                    AVL<Year> years = new AVL<>();
                    AVL<Item> items = new AVL<>();
                    AVL<Element> elements = new AVL<>();
                    Value tempValue = new Value(unit, value, flag, flagDescription);
                    Year tempYear = new Year(year, tempValue);
                    years.insert(tempYear);
                    Element tempElement = new Element(elementCode, element, years);
                    elements.insert(tempElement);
                    Item tempItem = new Item(itemCode, itemCPC, item, elements);
                    items.insert(tempItem);
                    Area tempArea = new Area(areaCode, codeM49, area, geoCoordinates1, items);
                    areas.insert(tempArea);
                    areasCodes.insert(areaCode); // verificar se a areacode ja existe para nao estar a fazer new de uma are ja existente
                } else {
                    for (Area a : areas.inOrder()) {
                        if (a.getAreaCode() == areaCode) {
                            for (Item i : a.getItems().inOrder()) {
                                if (i.getItemCode() == itemCode) {
                                    for (Element e : i.getElement().inOrder()) {
                                        if (e.getElementCode() == elementCode) {
                                            for (Year y : e.getYears().inOrder()) {
                                                if (y.getYear() == year) {
                                                    break;
                                                } else {
                                                    Value tempValue = new Value(unit, value, flag, flagDescription);
                                                    Year temYear = new Year(year, tempValue);
                                                    e.getYears().insert(temYear);
                                                    break;
                                                }
                                            }
                                        } else {
                                            Value tempValue = new Value(unit, value, flag, flagDescription);
                                            Year temYear = new Year(year, tempValue);
                                            e.getYears().insert(temYear);
                                            Element tempElement = new Element(elementCode, element, e.getYears());
                                            i.getElement().insert(tempElement);
                                            break;
                                        }
                                    }
                                } else {
                                    AVL<Year> years = new AVL<>();
                                    AVL<Element> elements = new AVL<>();
                                    Value tempValue = new Value(unit, value, flag, flagDescription);
                                    Year tempYear = new Year(year, tempValue);
                                    years.insert(tempYear);
                                    Element tempElement = new Element(elementCode, element, years);
                                    elements.insert(tempElement);
                                    Item tempItem = new Item(itemCode, itemCPC, item, elements);
                                    a.getItems().insert(tempItem);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            ;
        }

    }

}

