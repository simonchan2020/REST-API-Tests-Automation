import entities.NotFound;
import entities.RateLimit;
import entities.User;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ResponseBodyWithJackson extends BaseTest {

    @Test
    public void returnsCorrectLogin() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        User user = ResponseUtilities.unmarshall(response, User.class);
        assertEquals(user.getLogin(), "simonchan2020");
    }

    @Test
    public void returnsCorrectID() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/users/simonchan2020");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        User user = ResponseUtilities.unmarshall(response, User.class);
        assertEquals(user.getId(), 57819496);
    }

    @Test
    public void notFoundMessageIsCorrect() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/nonexistingurl");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        NotFound notFoundMessage = ResponseUtilities.unmarshallGeneric(response, NotFound.class);
        assertEquals(notFoundMessage.getMessage(), "Not Found");
    }

    /* Sample JSON response body
      {
        "resources": {
         "core": {
            "limit": 60,
            "remaining": 60,
            "reset": 1581813352
        },
         "search": {
            "limit": 10,
            "remaining": 10,
            "reset": 1581809812
        }
      }
     */
    @Test
    public void correctRateLimitsAreSet() throws Exception {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        RateLimit rateLimits = ResponseUtilities.unmarshallGeneric(response, RateLimit.class);
        assertEquals(rateLimits.getCoreLimit(), 60, " core limit");
        assertEquals(rateLimits.getCoreRemaining(), 60, "core remaining");
        assertEquals(rateLimits.getSearchLimit(), "10", "search limit");
    }
}
