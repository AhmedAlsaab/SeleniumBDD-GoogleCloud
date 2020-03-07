package GCP;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;


import java.util.UUID;

public class BigQueryClient {
    public BigQuery getDefaultInstance(){
        return BigQueryOptions.getDefaultInstance().getService();
    }

    public TableResult runQuery(String myQuery) throws Exception{
        TableResult result;
        QueryJobConfiguration queryJobConfiguration =
                QueryJobConfiguration.newBuilder(
                        myQuery)
                        .setUseLegacySql(false)
                        .build();
        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = getDefaultInstance().create(JobInfo.newBuilder(queryJobConfiguration).setJobId(jobId).build());
        queryJob = queryJob.waitFor();
        if (queryJob == null) {
            throw new RuntimeException("Job no longer exists");
        } else if (queryJob.getStatus().getError() != null) {
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }
        result = queryJob.getQueryResults();
        return result;
    }



//    public JsonObject bqJSON() throws Exception {
//        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
//
//        QueryJobConfiguration queryConfig =
//                QueryJobConfiguration.newBuilder(
//                        "SELECT load_id, load_type, report_date FROM `bigquery-public-data.austin_waste.waste_and_diversion` LIMIT 10;")
//                        .setUseLegacySql(false)
//                        .build();
//
//        JobId jobId = JobId.of(UUID.randomUUID().toString());
//        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
//
//
//        queryJob = queryJob.waitFor();
//
//
//        if (queryJob == null) {
//            throw new RuntimeException("Job no longer exists");
//        } else if (queryJob.getStatus().getError() != null) {
//            throw new RuntimeException(queryJob.getStatus().getError().toString());
//        }
//
//        TableResult result = queryJob.getQueryResults();
//        System.out.println(result);
//        JsonObject jsonObject = new JsonObject();
//        JsonArray jsonArray = new JsonArray();
//        for (FieldValueList row : result.iterateAll()) {
//            String loadType = row.get("load_type").getStringValue();
//            String loadId = row.get("load_id").getStringValue();
//            String reportDate = row.get("report_date").getStringValue();
//            jsonObject.addProperty("load_id", loadId);
//            jsonObject.addProperty("load_type", loadType);
//            jsonArray.add(reportDate);
//            jsonObject.add("SubPolicy", jsonArray);
//
//        }
//        System.out.print(jsonObject);
//        return jsonObject;
//
//    }

}





