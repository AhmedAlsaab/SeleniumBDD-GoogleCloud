package GCP;

import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.TableResult;

import org.json.JSONArray;
import org.json.JSONObject;

public class CompareJSON{

    private static final String BQ_PUBLIC_AUSTIN_WASTE_DIVERSION = "SELECT TO_JSON_STRING(t, true) FROM" +
            "(SELECT load_id, load_type, report_date FROM `bigquery-public-data.austin_waste.waste_and_diversion`) as t LIMIT 10;";

//    private static String localResult (){
//        LoadJSONFromFile loadJSONFromFile = new LoadJSONFromFile();
//        JSONObject jsonObject = loadJSONFromFile.loadJSON();
//        return jsonObject.get("load_id").toString();
//    }

    private static JSONArray bqResult() throws Exception{
        JSONArray results = new JSONArray();
        BigQueryClient bq = new BigQueryClient();
        TableResult bqResponse = bq.runQuery(BQ_PUBLIC_AUSTIN_WASTE_DIVERSION);
        bqResponse.getValues().forEach(value -> {
            value.iterator().forEachRemaining(json -> {
                results.put(new JSONObject(json.getStringValue()));
            });
        });
        System.out.println(results);
        return results;
    }

    public static void main(String[] args) throws Exception {
       // System.out.println(getLoadIDBase());
        System.out.println(bqResult());
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
