package requests;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class ApiRequest {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public String sendGetRequest(String url) throws IOException {
        return sendRequest(new HttpGet(url));
    }

    public String sendPostRequest(String url, String payload) throws IOException {
        HttpPost request = new HttpPost(url);
        request.setEntity(new StringEntity(payload));
        request.setHeader("Content-Type", "application/json");
        return sendRequest(request);
    }

    private String sendRequest(HttpUriRequestBase request) throws IOException {
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return EntityUtils.toString(response.getEntity());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws IOException {
        httpClient.close();
    }
}