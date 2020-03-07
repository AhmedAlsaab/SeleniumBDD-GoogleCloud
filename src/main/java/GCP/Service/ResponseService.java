package GCP.Service;

import org.json.JSONArray;


public interface ResponseService {

    /**
     * Contains methods that talks to all other instances (where this service is implemented) of this method
     * @param myQuery
     * @return
     * @throws Exception
     */
    JSONArray myJSONData(String myQuery) throws Exception;
}
