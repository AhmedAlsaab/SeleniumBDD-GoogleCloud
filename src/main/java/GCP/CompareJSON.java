package GCP;

import GCP.Service.ResponseService;

public class CompareJSON{

    private static final String BQ_PUBLIC_AUSTIN_WASTE_DIVERSION = "SELECT TO_JSON_STRING(t, true) FROM" +
            "(SELECT load_id, load_type, report_date FROM `bigquery-public-data.austin_waste.waste_and_diversion`) as t LIMIT 10;";

    private ResponseService responseService;

    public void setResponseService(ResponseService responseService){
        this.responseService = responseService;
    }

    private void bqResultA(String myQuery) throws Exception{
        String myResult = responseService.myJSONData(myQuery).toString();
        System.out.println(myResult);
    }

    public void checkResult() throws Exception{
        bqResultA(BQ_PUBLIC_AUSTIN_WASTE_DIVERSION);
    }
}
