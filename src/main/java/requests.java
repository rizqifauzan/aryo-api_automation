package requests;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class requests {

    private CloseableHttpClient httpClient;

    public requests() {
        httpClient = HttpClients.createDefault();
    }

    public String sendGetRequest(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    public String sendPostRequest(String url, String jsonPayload) throws IOException {
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(jsonPayload));
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    public void close() throws IOException {
        httpClient.close();
    }
}