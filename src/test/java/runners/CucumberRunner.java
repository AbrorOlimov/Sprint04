package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.tracing.Tags;


@CucumberOptions (

        features = "src/test/resources/features",
        glue = "stepDefinitions",
        publish = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report/report.html"
        }
        ,stepNotifications = true
)


@RunWith(Cucumber.class)
public class CucumberRunner {
}
