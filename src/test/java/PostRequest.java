import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class PostRequest extends BaseTest {

    @Test
    public void createRepoReturns201() throws IOException {

        // Create an HttpPost with a valid Endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/user/repos");
        request.setConfig(localConfig);
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        // Define Json to Post and set as Entity
        String json = "{\"name\": \"DeleteMe\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send it
        response = httpClient.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 201);

    }
}
