package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testDataType.ProductData;
import util.JsScroll;

public class ProductDataPage {

	private WebDriverWait wait;
	private WebDriver driver;
	private Select select;
	private JsScroll js;

	public ProductDataPage(WebDriver driver) {
		this.driver = driver;
		js = new JsScroll(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);

	}

	@FindBy(how = How.ID, using = "enterproductdata")
	private static WebElement tabEnterProductData;

	@FindBy(how = How.ID, using = "startdate")
	private static WebElement calendarStartDate;

	@FindBy(how = How.ID, using = "insurancesum")
	private static WebElement selectInsuranceSum;

	@FindBy(how = How.ID, using = "meritrating")
	private static WebElement selectMeritRating;

	@FindBy(how = How.ID, using = "damageinsurance")
	private static WebElement selectDamageInsurance;

	@FindBy(how = How.XPATH, using = "//div[@class='field idealforms-field idealforms-field-checkbox']//*/*[contains(.,'Euro')]")
	private static WebElement optionalProduct_EuroProtection;

	@FindBy(how = How.XPATH, using = "//div[@class='field idealforms-field idealforms-field-checkbox']//*/*[contains(.,'Legal')]")
	private static WebElement optionalProduct_LegalDefenseInsurance;

	@FindBy(how = How.ID, using = "courtesycar")
	private static WebElement selectCourtesyCar;

	@FindBy(how = How.XPATH, using = "//select[@id='courtesycar']/option[contains(.,'Yes')]")
	private static WebElement selectCourtesyCarYES;

	@FindBy(how = How.CSS, using = "	select#courtesycar")
	private static WebElement courtesyCarCss;

	@FindBy(how = How.ID, using = "nextselectpriceoption")
	private static WebElement nextSelectPriceOption;

	public void tabEnterProductData() {
		wait.until(ExpectedConditions.visibilityOf(tabEnterProductData));
		tabEnterProductData.click();
	}

	public void startDate(String startDate) {
		wait.until(ExpectedConditions.visibilityOf(calendarStartDate));
		calendarStartDate.sendKeys(startDate);
	}

	public void insuranceSum(String insuranceSum) {
		wait.until(ExpectedConditions.visibilityOf(selectInsuranceSum));
		select = new Select(selectInsuranceSum);
		select.selectByVisibleText(insuranceSum);
	}

	public void meritRating(String meritRating) {
		wait.until(ExpectedConditions.visibilityOf(selectMeritRating));
		select = new Select(selectMeritRating);
		select.selectByVisibleText(meritRating);
	}

	public void damageInsurance(String damageInsurance) {
		wait.until(ExpectedConditions.visibilityOf(selectDamageInsurance));
		select = new Select(selectDamageInsurance);
		select.selectByVisibleText(damageInsurance);
	}

	public void optionalProducts() {
		js.scrollDown();
		wait.until(ExpectedConditions.visibilityOf(optionalProduct_EuroProtection));
		optionalProduct_EuroProtection.click();
//		optionalProduct_EuroProtection.isSelected();

	}

	public void courtesyCar(String courtesyCar) {
		wait.until(ExpectedConditions.visibilityOf(selectCourtesyCar));
		selectCourtesyCar.isDisplayed();
		select = new Select(selectCourtesyCar);
		select.selectByVisibleText(courtesyCar);

	}

	public void nextSelectPriceOption() {
		wait.until(ExpectedConditions.visibilityOf(nextSelectPriceOption));
		nextSelectPriceOption.click();
	}

	public void fill_PersonalDetails_Product(ProductData product) {
		startDate(product.startDate);
		insuranceSum(product.insuranceSum);
		meritRating(product.meritRating);
		damageInsurance(product.damageInsurance);
		optionalProducts();
		courtesyCar(product.courtesyCar);
		nextSelectPriceOption();

	}
}