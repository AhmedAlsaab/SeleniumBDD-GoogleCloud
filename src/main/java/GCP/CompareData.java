package GCP;

import GCP.Service.ResponseService;
import JSONStore.LoadJSONFromFile;
import org.json.JSONArray;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class CompareData {

    private static final String BQ_PUBLIC_AUSTIN_WASTE_DIVERSION = "SELECT TO_JSON_STRING(t, true) FROM" +
            "(SELECT load_id, load_type, report_date FROM `bigquery-public-data.austin_waste.waste_and_diversion`) as t LIMIT 10;";

    DataRequestClient dataRequestClient = new DataRequestClient();
    ResponseService bigQueryData = new BigQueryClient();
    ResponseService localData = new LoadJSONFromFile();


    /**
     * Assert both JSONArays (BQ Vs Local)
     * @throws Exception
     */
    @Test
    public void assertAll() throws Exception{
        JSONAssert.assertEquals(
                dataRequestClient.getData2(BQ_PUBLIC_AUSTIN_WASTE_DIVERSION, bigQueryData),
                dataRequestClient.getData2(BQ_PUBLIC_AUSTIN_WASTE_DIVERSION, localData),
                false);
    }
}
