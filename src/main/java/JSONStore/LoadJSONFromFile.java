package JSONStore;

import GCP.Service.ResponseService;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LoadJSONFromFile implements ResponseService {

private static final String wasteAndDiversionJSONFilePath = "C:\\GCPAutomation\\GCPTestAutomation\\SeleniumBDD-GoogleCloud\\src\\main\\resources\\JSONFiles\\BaseJSON.json";

    /**
     *
     * @param filePath
     * @return Loads JSON file locally based on param and assigns to JSONArray
     */
 public static JSONArray loadWasteInfo(String filePath){
    JSONArray baseJSON = null;
    JSONParser jsonParser = new JSONParser();
    try(FileReader reader = new FileReader(filePath)){
        Object obj = jsonParser.parse(reader);
        baseJSON = (JSONArray)obj;
    }catch (IOException | ParseException e){
        e.printStackTrace();
    }
    return baseJSON;
 }

    /**
     *
     * @param myQuery
     * @return Returns a JSONArray from a local file based on Dataset looked for by user.
     * @throws Exception
     */

    @Override
    public JSONArray myJSONData(String myQuery) throws Exception {
     if(myQuery.contains("bigquery-public-data.austin_waste.waste_and_diversion")){
         return loadWasteInfo(wasteAndDiversionJSONFilePath);
     } else {
         System.out.println("No such dataset");
         return null;
     }
    }
}
