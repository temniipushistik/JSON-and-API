import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

public class API {


    public static String comeback() throws IOException {


        URL data = new URL("https://corona-api.com/countries");
        BufferedReader in = new BufferedReader(new InputStreamReader(data.openStream()));
        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null) {
            result += inputLine;
        }
        in.close();


        return result;
    }

    public static String separate(String sum, String nameOfCountry) {
        int nameOfCityIndex = sum.indexOf(nameOfCountry);
        if (nameOfCityIndex == -1) {
            return "There is no your country";
        } else {
            int finish = sum.indexOf("calculated", nameOfCityIndex);
            String JSON;
            JSON = "{\"name\":" + sum.substring(nameOfCityIndex - 1, finish - 2) + "}}";
            JSONObject object = new JSONObject();
            Storage storage = new Storage();
            storage.setCountry(nameOfCountry);
            // storage.setCases(object.getString());
            return JSON;


        }

    }
}




