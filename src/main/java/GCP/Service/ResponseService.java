package GCP.Service;

import org.json.JSONArray;

public interface ResponseService {
    JSONArray interpretResponse(String myQuery) throws Exception;
}
