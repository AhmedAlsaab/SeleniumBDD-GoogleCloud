package JSONStore;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class LoadJSONFromFile {

 public JSONObject loadJSON(){
     JSONParser parser = new JSONParser();
     JSONObject jsonObject = null;
     try {
         Object obj = parser.parse(new FileReader("C:\\GCPAutomation\\GCPTestAutomation\\SeleniumBDD-GoogleCloud\\src\\main\\resources\\JSONFiles\\BaseJSON.json"));
          jsonObject = (JSONObject) obj;
     } catch (Exception e) {
         e.printStackTrace();
     }
     return jsonObject;
 }


    // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
    // A JSON array. JSONObject supports java.util.List interface.
    //JSONArray companyList = (JSONArray) jsonObject.get("Company List");

    // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
    // Iterators differ from enumerations in two ways:
    // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
    // 2. Method names have been improved.
//         Iterator<JSONObject> iterator = companyList.iterator();
//         while (iterator.hasNext()) {
//             System.out.println(iterator.next());
//         }

}
