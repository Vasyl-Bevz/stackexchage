package Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.time.LocalTime;

public class HttpClient {
    private final CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.STANDARD).build())
            .build();
    private ObjectMapper objectMapper = new ObjectMapper();
    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T get(String url, Class<T> clazz) {
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            T t = objectMapper.readValue(response.getEntity().getContent(), clazz);
            return t;
        } catch (IOException e) {
            throw new RuntimeException("Cant send Get request to URL " + url, e);
        }
    }
}
