package utilities;


import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {

    public static List<String> ReadCSV(String path){
        List<String> lines = null;
        File file = new File(path);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    @DataProvider(name = "Users data provider")
    public static Object[][] getDataFromCSV(){
        List<String> lines = ReadCSV(getData("DDTFile"));

        if(lines == null)
            return null;

        String[] elements = lines.get(0).split(", ");
        Object[][] data = new Object[lines.size()][elements.length];

        for(int i=0; i<lines.size(); i++){
            elements = lines.get(i).split(", ");
            for(int j=0; j<elements.length; j++){
                data[i][j] = elements[j];
            }
        }
        return data;
    }
}
