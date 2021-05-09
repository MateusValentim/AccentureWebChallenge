package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/insurantData.feature",
        glue = {"steps"},
        tags = {"@PreenchimentoDadosSeguroFeliz"},
        plugin = {"pretty"}
)
public class InsurantDataRunner {
}