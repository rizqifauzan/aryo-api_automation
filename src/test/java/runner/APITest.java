package runner;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @BeforeClass
    public void setup() {
        // Set base URI sekali saja
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void testGetListUsers() {
        given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo(6))
                .assertThat().body("page", Matchers.equalTo(2));
    }
}
