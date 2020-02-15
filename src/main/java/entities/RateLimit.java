package entities;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RateLimit {

    private int coreLimit;
    private String searchLimit;
    private int coreRemaining;

    public int getCoreLimit(){
        return coreLimit;
    }

    public String getSearchLimit(){
        return searchLimit;
    }

    public int getCoreRemaining(){
        return coreRemaining;
    }

    /**
     * Used for nested objects
     * @param resources
     */
    @JsonProperty("resources")
    private void unmarshallNested(Map<String, Object> resources){
        Map<String, Integer> core = (Map<String, Integer>)resources.get("core");
        coreLimit = core.get("limit");
        coreRemaining = core.get("remaining");

        Map<String, String> search = (Map<String, String>)resources.get("search");
        searchLimit = String.valueOf(search.get("limit"));
    }
}
