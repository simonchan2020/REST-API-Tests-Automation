import org.apache.http.client.methods.HttpOptions;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.io.IOException;

public class Status204 extends BaseTest {

    @Test
    public void optionsReturnCorrectMethodsList() throws IOException {

        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST, PUT, DELETE, OPTIONS";

        HttpOptions httpOptions = new HttpOptions("http://dummy.restapiexample.com/");
        httpOptions.setConfig(localConfig);
        response = httpClient.execute(httpOptions);

        String actualValue = ResponseUtilities.getHeader(response, header);
        assertEquals(actualValue, expectedReply);
    }
}
