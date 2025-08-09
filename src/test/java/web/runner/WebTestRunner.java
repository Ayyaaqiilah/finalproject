package web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web/features",
        glue = "web.steps",
        tags = "@web",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/web-report.html",
                "json:target/cucumber-reports/web-report.json"
        }
)
public class WebTestRunner {
}
