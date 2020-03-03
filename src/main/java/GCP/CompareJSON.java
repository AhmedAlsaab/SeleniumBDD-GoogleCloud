package GCP;

import org.json.simple.JSONObject;

public class CompareJSON {


    private static void dryRun (){
        LoadJSONFromFile loadJSONFromFile = new LoadJSONFromFile();
        JSONObject jsonObject = loadJSONFromFile.loadJSON();
        System.out.println(jsonObject.get("load_id"));
    }

    public static void main(String[] args) throws Exception {
        CompareJSON compareJSON = new CompareJSON();
        dryRun();
    }
}
