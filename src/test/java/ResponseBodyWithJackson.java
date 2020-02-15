import entities.NotFound;
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


}
