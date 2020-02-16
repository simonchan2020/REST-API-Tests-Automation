import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class BaseTest {
    protected static final String BASE_ENDPOINT = "https://api.github.com";
    RequestConfig globalConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.DEFAULT)
            .build();
    CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(globalConfig)
            .build();
    RequestConfig localConfig = RequestConfig.copy(globalConfig)
            .setCookieSpec(CookieSpecs.STANDARD)
            .build();
    CloseableHttpResponse response;
}
