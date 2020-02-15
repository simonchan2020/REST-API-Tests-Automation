import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;

public class Status200 extends BaseTest {

    @BeforeMethod
    public void setup(){
        httpClient = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        httpClient.close();
        response.close();
    }

    @Test
    public void baseUrlReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void searchReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void rateLimitReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        httpGet.setConfig((localConfig));
        HttpResponse response = httpClient.execute(httpGet);

        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
}
