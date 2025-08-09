package web.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import web.pages.LoginPage;
import web.utils.WebDriverFactory;

import static org.junit.Assert.*;

public class WebSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    private boolean isHeadless() {
        String env = System.getenv("CI_HEADLESS");
        return env != null && env.equalsIgnoreCase("true");
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.createChrome(isHeadless());
        loginPage = new LoginPage(driver);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open Saucedemo login page")
    public void i_open_saucedemo_login_page() {
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        assertTrue("Not on Products page", loginPage.isOnProductsPage());
    }
}
