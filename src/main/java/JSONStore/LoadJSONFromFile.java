package JSONStore;

import GCP.Service.ResponseService;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LoadJSONFromFile implements ResponseService {

private static final String wasteAndDiversionJSONFilePath = "C:\\GCPAutomation\\GCPTestAutomation\\SeleniumBDD-GoogleCloud\\src\\main\\resources\\JSONFiles\\WasteAndDiversion.json";

    /**
     *
     * @param filePath
     * @return Loads JSON file locally based on param and assigns to JSONArray
     */
 public static JSONArray loadLocalData(String filePath) throws Exception{
     File file = new File(filePath);
     String myJSONContent = FileUtils.readFileToString(file, "utf-8");
     return new JSONArray(myJSONContent);
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
         return loadLocalData(wasteAndDiversionJSONFilePath);
     } else {
         System.out.println("No such dataset");
         return null;
     }
    }
}
