package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import requests.ApiRequest;

public class tests {

    @Test(description = "Positive Test: Valid request returns correct response")
    public void testPositiveCase() throws IOException {
        ApiRequest apiRequest = new ApiRequest();
        String url = "https://api.example.com/endpoint";
        String response = apiRequest.sendGetRequest(url);

        // Validate status code (assuming 200 is expected)
        Assert.assertTrue(response.contains("expected_data"), "Response does not contain expected data");
        apiRequest.close();
    }

    @Test(description = "Negative Test: Invalid request returns error")
    public void testNegativeCase() throws IOException {
        ApiRequest apiRequest = new ApiRequest();
        String url = "https://api.example.com/endpoint";
        String invalidPayload = "{ \"invalid_key\": \"invalid_value\" }";
        String response = apiRequest.sendPostRequest(url, invalidPayload);

        // Validate error response
        Assert.assertTrue(response.contains("error"), "Expected error not found in response");
        apiRequest.close();
    }

    @Test(description = "Boundary Test: Test maximum input value")
    public void testBoundaryCase() throws IOException {
        ApiRequest apiRequest = new ApiRequest();
        String url = "https://api.example.com/endpoint";
        String maxPayload = "{ \"input\": " + Integer.MAX_VALUE + " }";
        String response = apiRequest.sendPostRequest(url, maxPayload);

        // Validate boundary response
        Assert.assertTrue(response.contains("expected_boundary_response"), "Boundary test failed");
        apiRequest.close();
    }
}