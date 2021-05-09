package steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import core.BasePage;
import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Quando;
import pageFactory.InsurantDataPage;

public class InsurantDataSteps {

	private WebDriver driver;
	private BasePage basePage;
	private InsurantDataPage insurantDataPage;
	private cucumber.TestContext testContext;

	public InsurantDataSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		basePage = testContext.getPageObjectManager().getBasePage();
		insurantDataPage = testContext.getPageObjectManager().getInsurantDataPage();

	}

	@Quando("^clico na aba Insurant Data$")
	public void clico_na_aba_Insurant_Data() throws Throwable {
		basePage.clickAutomobile();
		insurantDataPage.clickTabInsuranceData();
	}

	@Quando("^preencho os dados do seguro$")
	public void preencho_os_dados_do_seguro(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			insurantDataPage.inputFirsName(dado.get("firstName"));
			insurantDataPage.inputLastName(dado.get("lastName"));
			insurantDataPage.inputBirthDate(dado.get("birthDate"));
			insurantDataPage.radioButtonGender();
			insurantDataPage.inputStreetAddress(dado.get("streetAddress"));
			insurantDataPage.country(dado.get("country"));
			insurantDataPage.inputZipCode(dado.get("zipCode"));
			insurantDataPage.inputCity(dado.get("city"));
			insurantDataPage.occupation(dado.get("occupation"));
			insurantDataPage.hobbie();
			insurantDataPage.inputWebSite(dado.get("webSite"));
		}
	}

	@Quando("^clico em Next$")
	public void clico_em_Next() throws Throwable {
		//Assert
		insurantDataPage.nextButton();
		
	}

}