package steps;

import org.openqa.selenium.WebDriver;

import core.BasePage;
import cucumber.TestContext;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import manager.FileReaderManager;
import pageFactory.VehicleDataPage;

public class RepeatedSteps {

	private WebDriver driver;
	private TestContext testContext;
	private BasePage basePage;
	private VehicleDataPage vehicleDataPage;

	public RepeatedSteps(TestContext context) {
		this.testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		basePage = testContext.getPageObjectManager().getBasePage();
		vehicleDataPage = testContext.getPageObjectManager().getVehicleDataPage();

	}
	
	@Dado("^que estou na tela home$")
	public void queEstouNaTelaHome() throws Throwable {
		driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
	}
	
	@Quando("^clico em automobile$")
	public void clico_em_automobile() throws Throwable {
		basePage.clickAutomobile();
	}

}