import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static entities.User.*;
import static org.testng.Assert.assertEquals;

public class ResponseBody extends BaseTest {

    @Test
    public void returnsCorrectLogin() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig(localConfig);
        response = httpClient.execute(httpGet);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        String loginValue = (String) ResponseUtilities.getValueFor(jsonObject, LOGIN);
        assertEquals(loginValue, "simonchan2020");
    }

    @Test
    public void returnsCorrectID() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig(localConfig);
        response = httpClient.execute(httpGet);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer result = (Integer) ResponseUtilities.getValueFor(jsonObject, ID);
        assertEquals(result, Integer.valueOf(57819496));
    }

    @Test
    public void returnsCorrectType() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig(localConfig);
        response = httpClient.execute(httpGet);

        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);

        String result = (String) ResponseUtilities.getValueFor(jsonObject, TYPE);
        assertEquals(result, "User");
    }
}
