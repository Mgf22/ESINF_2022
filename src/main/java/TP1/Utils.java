package TP1;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Utils {

    private static final String SEPARATOR = ",";

    public void uploadInfo(String filename, TreeMap<String, TreeSet<Year>> areaInfo){
        String area;
        String item;
        String value;
        String year;
        File file = new File(filename);

        try{
            Scanner readFile = new Scanner(file);
            readFile.nextLine();

            while(readFile.hasNext()){
                TreeSet<Year> tempYears = new TreeSet<>(new yearCompare());
                String line = readFile.nextLine();
                String[] aux = line.split(SEPARATOR);


                area = aux[3].replaceAll("\"", "");
                item = aux[7].replaceAll("\"", "");
                year = aux[9].replaceAll("\"", "");
                value = aux[11].replaceAll("\"", "");

                if (aux[3].equals("\"China")){
                    area = aux[3].replaceAll("\"", "") + " " + aux[4].replaceAll("\"", "");
                    item = aux[8].replaceAll("\"", "");
                    year = aux[10].replaceAll("\"", "");
                    value = aux[12].replaceAll("\"", "");
                }


                //Area a1 = new Area(area);
                Item i1 = new Item(item);
                Value v1 = new Value(value);
                Year y1 = new Year(year, i1, v1);

                if(areaInfo.containsKey(area)){
                   tempYears = areaInfo.get(area);
                   tempYears.add(y1);
                   areaInfo.replace(area, areaInfo.get(area), tempYears);
                }else {
                    tempYears.add(y1);
                    areaInfo.put(area, tempYears);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        }

    }

}

class yearCompare implements Comparator<Year> {
    @Override
    public int compare(Year year1,
                       Year year2) {
        if (year1.getYear() > year2.getYear()) {
            return 1;
        } else {
            return -1;
        }
    }
}
