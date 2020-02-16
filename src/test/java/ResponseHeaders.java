import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;

public class ResponseHeaders extends BaseTest {

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
    public void contentTypeIsJSON() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpGet.setConfig(localConfig);
        response = httpClient.execute(httpGet);

        //One way to get the contentType
        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        //Another way to get the contentTye MiME
        ContentType ct = ContentType.getOrDefault(response.getEntity());
        assertEquals(ct.getMimeType(), "application/json");
        assertEquals(ct.getCharset().toString(),"UTF-8");
    }

    @Test
    public void serverIsGitHub() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpGet.setConfig(localConfig);
        response = httpClient.execute(httpGet);

        String headerValue = ResponseUtilities.getHeaderInLambdasWay(response, "Server");
        assertEquals(headerValue, "GitHub.com");
    }

    @Test
    public void eTagIsPresent() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpGet.setConfig(localConfig);
        response = httpClient.execute(httpGet);

        Boolean eTagIsPresent = ResponseUtilities.headerIsPresent(response, "ETag");
        assertTrue(eTagIsPresent);
    }
}
