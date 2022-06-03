import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class TestNGDemo {

    @Test(dataProvider = "getData")
    public void test1(String username, String password){
        System.out.println("username: "+ username);
        System.out.println("password: "+ password);
    }

    @DataProvider(name = "getData")
    public Object[][] getData(){
        return new Object[][]{{"admin", "1212"},{"admin 2", "233333"}};
    }

    @Test(dataProvider = "getData2")
    public void test2(String color, String value){
        System.out.println("color: "+ color);
        System.out.println("value: "+ value);
    }



}
