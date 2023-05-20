package ProductsAPI.petstore.managers;

import Common.managers.TestDataFileReaderManager;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestManager {

    private String baseUri;
    RequestSpecification requestSpecification;

    public RestManager() {
        this.baseUri = TestDataFileReaderManager.getProperty("restUrl");
        this.requestSpecification = given()
                .header("accept", "application/json")
                .contentType(ContentType.JSON)
                .baseUri(baseUri);
    }

    public RequestSpecification getRequestSpecification(){
        return this.requestSpecification;
    }
}
