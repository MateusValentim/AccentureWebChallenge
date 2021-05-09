package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/productData.feature",
        glue = {"steps"},
        tags = {"@PreencherDadosDoProdutoFeliz"},
        plugin = {"pretty"}
)
public class ProductDataRunner {

}