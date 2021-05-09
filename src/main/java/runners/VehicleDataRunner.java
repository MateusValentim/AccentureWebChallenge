package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/vehicleData.feature",
        glue = {"steps"},
        tags = {"@PreenchimentoFormularioFeliz"},
        plugin = {"pretty"}
        )
public class VehicleDataRunner {


}