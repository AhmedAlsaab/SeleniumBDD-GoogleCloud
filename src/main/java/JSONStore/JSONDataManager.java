package JSONStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONDataManager {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void saveJSON(JsonObject jsonResponse){

        try{
            FileWriter writer = new FileWriter("C:\\GCPAutomation\\GCPTestAutomation\\src\\main\\resources\\JSONFiles\\JsonStorage.json");
            gson.toJson(jsonResponse, writer);
            //writer.write(jsonResponse.toString());
            writer.flush(); //flush data to file   <---
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
