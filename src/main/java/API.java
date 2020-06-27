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

    Storage storage = new Storage();

    public String getJSON() {
        return JSON;
    }

    public void setJSON(String JSON) {
        this.JSON = JSON;
    }

    private String JSON;

    //Get all JSON file
    public String comeback() throws IOException {


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

    //find information about an input country
    public String separate(String sum, String nameOfCountry) {
        int nameOfCityIndex = sum.indexOf(nameOfCountry);
        if (nameOfCityIndex == -1) {
            return "There is no your country";
        } else {
            int finish = sum.indexOf("calculated", nameOfCityIndex);
            storage.setCountry(nameOfCountry);

            JSON = "{\"name\":" + sum.substring(nameOfCityIndex - 1, finish - 2) + "}}";
            JSONObject object = new JSONObject();


            // storage.setCases(object.getString());
            setJSON(JSON);
            return JSON;


        }
    }

    //parcing direct information from the country
    public void directCatch() {
        String json = getJSON();
        //convert string to json
        JSONObject object = new JSONObject(json);

        //parcing today
        JSONObject daily = object.getJSONObject("today");
        storage.setCasesToday(daily.getInt("confirmed"));
        storage.setDeathsToday(daily.getInt("deaths"));

        //parcing total
        JSONObject total = object.getJSONObject("latest_data");
        storage.setCasesTotal(total.getInt("confirmed"));
        storage.setRecoveryTotal(total.getInt("recovered"));
        storage.setDeathsTotal(total.getInt("deaths"));

    }

    public void print() {
        System.out.println("In " + storage.getCountry() + ":" + "\n" +
                "Cases total: " + storage.getRecoveryTotal() + " Deaths total: " + storage.getDeathsTotal() + "\n" +
                "New cases today: " + storage.getCasesToday() + " Deaths today: " + storage.getDeathsToday() + " Recoveries today: " + storage.getRecoveredToday()
        );


    }


}




