import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;

public class Status404 extends BaseTest{

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
    public void nonExistingUrlReturns404() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/nonexistingurl");
        httpGet.setConfig((localConfig));
        response = httpClient.execute(httpGet);

        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 404);
    }
}
