package GCP;

import GCP.Service.ResponseService;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.UUID;

public class BigQueryClient implements ResponseService {

    /**
     *
     * @return gets the requested BQ instance using the credentials set in the IDE Env
     */
    public BigQuery getDefaultInstance(){
        return BigQueryOptions.getDefaultInstance().getService();
    }

    /**
     *
     * @param myQuery
     * @return Constructs the query to be sent to BQ with the required config
     */
    private QueryJobConfiguration queryConfig(String myQuery){
        return QueryJobConfiguration.newBuilder(myQuery).setUseLegacySql(false).build();
    }

    /**
     *
     * @param myQuery
     * @return returns the response from BQ into a TableResult format
     * @throws Exception
     */
    public TableResult runQuery(String myQuery) throws Exception{
        TableResult result;
        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = getDefaultInstance().create(JobInfo.newBuilder(queryConfig(myQuery)).setJobId(jobId).build());
        queryJob = queryJob.waitFor();
        if (queryJob == null) {
            throw new RuntimeException("Job no longer exists");
        } else if (queryJob.getStatus().getError() != null) {
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }
        result = queryJob.getQueryResults();
        return result;
    }

    /**
     *
     * @param myQuery
     * @return JSONArray with the BigQuery response and sent to the interface
     * @throws Exception
     */


    @Override
    public JSONArray myJSONData(String myQuery) throws Exception{
        JSONArray response = new JSONArray();
        TableResult bqResponse = runQuery(myQuery);
        bqResponse.getValues().forEach(value -> {
            value.iterator().forEachRemaining(json -> {
                response.put(new JSONObject(json.getStringValue()));
            });
        });
        return response;
    }
}





