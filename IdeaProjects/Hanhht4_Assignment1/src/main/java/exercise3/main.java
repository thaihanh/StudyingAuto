package exercise3;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        String colorJson = "[{color: 'red',value: '#f00'}," +
                "{color: 'green',value: '#0f0'},{color: 'blue',value: '#00f'}," +
                "{color: 'magenta',value: '#f0f'}," +
                "{color: 'yellow',value: '#ff0'},{color: 'black',value: '#000'}]";

        Gson gson = new Gson();

//        Color[] colorArray = gson.fromJson(colorJson, Color[].class);

        JsonElement json = new JsonParser().parse(new FileReader("./data.json"));
        JsonElement dataSet = json.getAsJsonObject().get("colorList");
        List<Colors> test = new Gson().fromJson(dataSet, new TypeToken<List<Colors>>(){}.getType());

        Colors[] colorArray = new Colors[test.size()];
        test.toArray(colorArray);
        String[] colorArrayString = new String[test.size()];
        for(int i = 0; i < test.size(); ++i){
            colorArrayString[i] = colorArray[i].toString();
        }
        for(String string : colorArrayString){
            System.out.println(string);
        }
    }
}
