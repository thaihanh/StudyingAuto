package exercise3;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class TestDataProvider {
    @Test(dataProvider = "getColor")
    public void TestDataProvider(String color, String value) {
        System.out.println("color: " + color);
        System.out.println("value: " + value);
    }
    
    @DataProvider(name = "getColor")
    public static Object[][] getColor() throws FileNotFoundException {
//        String colorJson = "[{color: 'red',value: '#f00'}," +
//                "{color: 'green',value: '#0f0'},{color: 'blue',value: '#00f'}," +
//                "{value: '#0ff'},{color: 'magenta',value: '#f0f'}," +
//                "{color: 'yellow',value: '#ff0'},{color: 'black',value: '#000'}]";
//        Color[] colorArray = gson.fromJson(colorJson, Color[].class);
        Gson gson = new Gson();
        JsonElement json = new JsonParser().parse(new FileReader("./data.json"));
        JsonElement dataSet = json.getAsJsonObject().get("colorList");
        List<Colors> test = gson.fromJson(dataSet, new TypeToken<List<Colors>>(){}.getType());

        Colors[] colorArray = new Colors[test.size()];
        test.toArray(colorArray);
        String[] colorArrayString = new String[test.size()];
        for(int i = 0; i < test.size(); ++i){
            colorArrayString[i] = colorArray[i].toString();
        }
        for(Colors color : colorArray){
            System.out.println(color);
        }
        return new Object[][]{colorArrayString};
    }
}
