package GCP;

import GCP.Service.ResponseService;

public class DataRequestClient {

    // TODO: 07/03/2020 Create more queries, export queries to a file specific for queries and make queries dynamic so they can select any field from any table

    /**
     * Query to send to BQ, also tells our local JSON file loader which dataset to get
     */
    private static final String BQ_PUBLIC_AUSTIN_WASTE_DIVERSION = "SELECT TO_JSON_STRING(t, true) FROM" +
            "(SELECT load_id, load_type, report_date FROM `bigquery-public-data.austin_waste.waste_and_diversion`) as t LIMIT 10;";

    private ResponseService responseService;

    /**
     * Sets a service to the class
     * @param responseService
     */
    public void setResponseService(ResponseService responseService){
        this.responseService = responseService;
    }

    /**
     * Gets the object from the set service and simply prints it out
     * @param myQuery
     * @throws Exception
     */
    private void bqResultA(String myQuery) throws Exception{
        String myResult = responseService.myJSONData(myQuery).toString();
        System.out.println(myResult);
    }

    public void checkResult() throws Exception{
        bqResultA(BQ_PUBLIC_AUSTIN_WASTE_DIVERSION);
    }
}
