import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class DeleteRequest extends BaseTest {

    @Test
    public void deleteIsSuccessful() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT + "/repos/simonchan2020/DeleteMe");
        request.setConfig(localConfig);
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);
        response = httpClient.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 204);
    }
}
