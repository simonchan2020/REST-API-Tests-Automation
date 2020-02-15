import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static entities.User.*;
import static org.testng.Assert.assertEquals;

public class ResponseBody extends BaseTest {

    @Test
    public void returnsCorrectLogin() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        String loginValue = (String) getValueFor(jsonObject, LOGIN);
        assertEquals(loginValue, "simonchan2020");
    }

    @Test
    public void returnsCorrectID() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer result = (Integer) getValueFor(jsonObject, ID);
        assertEquals(result, Integer.valueOf(57819496));
    }

    @Test
    public void returnsCorrectType() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        String result = (String) getValueFor(jsonObject, TYPE);
        assertEquals(result, "User");
    }

    private Object getValueFor(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.get(key);
    }
}
