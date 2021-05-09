package steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import core.BasePage;
import cucumber.TestContext;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageFactory.VehicleDataPage;

public class VehicleDataSteps {

	private WebDriver driver;
	private BasePage basePage;
	private VehicleDataPage vehicleDataPage;
	private cucumber.TestContext testContext;

	public VehicleDataSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		basePage = testContext.getPageObjectManager().getBasePage();
		vehicleDataPage = testContext.getPageObjectManager().getVehicleDataPage();

	}

	@Quando("^clico na aba Vehicle Data$")
	public void clico_na_aba_Vehicle_Data() throws Throwable {
		vehicleDataPage.tabEnterVehicleData();
	}

	@Dado("^informo os dados do veículo$")
	public void informo_os_dados_do_veículo(cucumber.api.DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			vehicleDataPage.make(dado.get("make"));
			vehicleDataPage.enginePerformanceKw(dado.get("enginePerformanceKw"));
			basePage.clickOpenCalendar();
			vehicleDataPage.inputCalendarDate(dado.get("inputDate"));
			vehicleDataPage.numberOfSeats(dado.get("numberOfSeats"));
			vehicleDataPage.fuelType(dado.get("fuelType"));
			vehicleDataPage.inputListPrice(dado.get("listPrice"));
			vehicleDataPage.inputLicensePlateNumber(dado.get("licensePlateNumber"));
			vehicleDataPage.inputAnnualMileage(dado.get("annualMileage"));

		}
	}

	@Entao("^clico em next$")
	public void clico_em_next() throws Throwable {
		vehicleDataPage.buttonNext();
		//Assert.assertT

	}
}