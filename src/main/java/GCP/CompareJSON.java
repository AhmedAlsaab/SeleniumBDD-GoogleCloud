package GCP;

import GCP.Service.ResponseService;

public class CompareJSON{

    private static final String BQ_PUBLIC_AUSTIN_WASTE_DIVERSION = "SELECT TO_JSON_STRING(t, true) FROM" +
            "(SELECT load_id, load_type, report_date FROM `bigquery-public-data.austin_waste.waste_and_diversion`) as t LIMIT 10;";

    private ResponseService responseService;

//    public CompareJSON(ResponseService responseService){
//        this.responseService = responseService;
//    }
    public void setResponseService(ResponseService responseService){
        this.responseService = responseService;
    }

//    private static String localResult (){
//        LoadJSONFromFile loadJSONFromFile = new LoadJSONFromFile();
//        JSONObject jsonObject = loadJSONFromFile.loadJSON();
//        return jsonObject.get("load_id").toString();
//    }

    private void bqResultA(String myQuery) throws Exception{
        String myResult = responseService.interpretResponse(myQuery).toString();
        System.out.println(myResult);

    }

    public void checkResult() throws Exception{
        bqResultA(BQ_PUBLIC_AUSTIN_WASTE_DIVERSION);
    }

    public static void main(String[] args) throws Exception {

        ResponseService xService = new BigQueryClient();
        CompareJSON compareJSON = new CompareJSON();
        compareJSON.setResponseService(xService);
        compareJSON.checkResult();
        //new CompareJSON().setResponseService(responseService);
        //checkResult

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
