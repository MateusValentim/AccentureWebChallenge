package steps;

import java.util.Map;

import cucumber.api.java.pt.Entao;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import core.BasePage;
import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Quando;
import manager.FileReaderManager;
import pageFactory.InsurantDataPage;
import pageFactory.ProductDataPage;
import pageFactory.SendQuoteDataPage;
import pageFactory.VehicleDataPage;
import testDataType.CustomerData;
import testDataType.InsurantData;
import testDataType.ProductData;
import testDataType.SendQuoteData;

public class SendQuoteSteps {
	
	private WebDriver driver;
	private BasePage basePage;
	private VehicleDataPage vehicleDataPage;
	private InsurantDataPage insurantDataPage;
	private ProductDataPage productDataPage;
	private SendQuoteDataPage sendQuoteDataPage;
	private TestContext testContext;

	public SendQuoteSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		basePage = testContext.getPageObjectManager().getBasePage();
		insurantDataPage = testContext.getPageObjectManager().getInsurantDataPage();
		vehicleDataPage = testContext.getPageObjectManager().getVehicleDataPage ();
		productDataPage = testContext.getPageObjectManager ().getProductDataPage ();
		sendQuoteDataPage = testContext.getPageObjectManager ().getSendQuoteDataPage();

	}
	@Quando("^preencho os dados do \"([^\"]*)\"$")
	public void preencho_os_dados_do(String data) throws Throwable {
			CustomerData customerData = FileReaderManager.getInstance().getJsonReader().getCustomerByVehicle(data);
			vehicleDataPage.fill_PersonalDetails_Vehicle(customerData);
			Assert.assertTrue(driver.getPageSource().toString().contains("Engine Performance [kW]"));
	}
	
	@Quando("^preencho os dados \"([^\"]*)\"$")
	public void preencho_os_dados(String data) throws Throwable {
		InsurantData insurantData = FileReaderManager.getInstance().getJsonReader().getCustomerByInsurant(data);
		insurantDataPage.fill_PersonalDetails_Insurant(insurantData);
	}

	@Quando("^preencho os dados de \"([^\"]*)\"$")
	public void preencho_os_dados_de(String data) throws Throwable {
		ProductData productData = FileReaderManager.getInstance ().getJsonReader ().getCustomerByProduct (data);
		productDataPage.fill_PersonalDetails_Product (productData);

	}

	@Quando("^seleciono a tabela de precos$")
	public void seleciono_a_tabela_de_precos() throws Throwable {
		//basePage.clickTable ("Platinum", "Price per Year ($)", "Platinum", "priceTable");
		basePage.radioButtonPlatinum();
		basePage.nextSendQuote();
	}

	@Entao ("^preencho meus dados para \"([^\"]*)\"$")
	public void preencho_meus_dados_para(String data) throws Throwable {
		SendQuoteData sendQuotedata = FileReaderManager.getInstance().getJsonReader().getCustomerBySendQuote(data);
		sendQuoteDataPage.fill_PersonalDetails_SendQuote(sendQuotedata);
		Assert.assertTrue(sendQuoteDataPage.loading());
	}
	
}