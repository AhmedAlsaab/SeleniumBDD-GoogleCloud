package GCP;

import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.TableResult;
import org.json.simple.JSONObject;

public class CompareJSON {


    private static String getLoadIDBase (){
        LoadJSONFromFile loadJSONFromFile = new LoadJSONFromFile();
        JSONObject jsonObject = loadJSONFromFile.loadJSON();
        return jsonObject.get("load_id").toString();
    }

    private static String getLoadIDBQ() throws Exception{
        BigQueryClient bq = new BigQueryClient();
        TableResult bqResponse = bq.bqJSON();
        String bqLoadID = null;
        System.out.println(bqResponse);

        for (FieldValueList row : bqResponse.iterateAll()){
            System.out.println(row);
            bqLoadID = row.get("load_id").getStringValue();
        }
        return bqLoadID;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getLoadIDBase());
        System.out.println(getLoadIDBQ());
    }

//              for (FieldValueList row : result.iterateAll()) {
//            String loadType = row.get("load_type").getStringValue();
//            String loadId = row.get("load_id").getStringValue();
//            String reportDate = row.get("report_date").getStringValue();
//            jsonObject.addProperty("load_id", loadId);
//            jsonObject.addProperty("load_type", loadType);
//            jsonArray.add(reportDate);
//            jsonObject.add("SubPolicy", jsonArray);
//
//        }
}
