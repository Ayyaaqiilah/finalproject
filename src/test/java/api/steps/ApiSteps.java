package api.steps;

import api.requests.UserApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiSteps {

    private UserApi userApi = new UserApi();
    private Response response;

    @Given("I send a request to get user by id {string}")
    public void iSendRequestToGetUserById(String userId) {
        response = userApi.getUserById(userId);
        System.out.println("GET /user/" + userId + " Response body: " + response.getBody().asString());
    }

    @Given("I create a new user with firstName {string}, lastName {string}, and email {string}")
    public void iCreateANewUser(String firstName, String lastName, String email) {
        if (email == null || email.isEmpty() || email.equalsIgnoreCase("unique")) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + System.currentTimeMillis() + "@example.com";
        }
        response = userApi.createUser(firstName, lastName, email);
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Expected Status: " + expectedStatusCode + ", Actual Status: " + actualStatusCode);
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}
