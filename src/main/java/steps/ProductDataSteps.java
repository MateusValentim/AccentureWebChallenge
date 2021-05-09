package steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Quando;
import pageFactory.ProductDataPage;

public class ProductDataSteps {

	private WebDriver driver;
	private ProductDataPage productDataPage;
	private cucumber.TestContext testContext;

	public ProductDataSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
		productDataPage = testContext.getPageObjectManager().getProductDataPage();

	}

	@Quando("^clico na aba Product Data$")
	public void clico_na_aba_Product_Data() throws Throwable {
		productDataPage.tabEnterProductData();
	}

	@Quando("^preencho os dados do produto$")
	public void preencho_os_dados_do_produto(DataTable dados) throws Throwable {
		for (Map<String, String> dado : dados.asMaps(String.class, String.class)) {
			productDataPage.startDate(dado.get("startDate"));
			productDataPage.insuranceSum(dado.get("insuranceSum"));
			productDataPage.meritRating(dado.get("meritRating"));
			productDataPage.damageInsurance(dado.get("damageInsurance"));
			productDataPage.optionalProducts();
			productDataPage.courtesyCar(dado.get("courtesyCar"));
		}
	}

	@Quando("^clico no botao next$")
	public void clico_no_botao_next() throws Throwable {
		productDataPage.nextSelectPriceOption();
		//Assert
	}

}