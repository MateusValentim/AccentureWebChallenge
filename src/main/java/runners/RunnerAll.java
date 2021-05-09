package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/customerData.feature",
        glue = {"steps"},
        tags = {"@PreencherDadosDoCliente"},
        plugin = {"pretty"}
)
public class RunnerAll {

}