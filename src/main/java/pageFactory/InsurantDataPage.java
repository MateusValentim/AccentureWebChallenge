package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;
import testDataType.InsurantData;
import util.JsScroll;

public class InsurantDataPage {

	private WebDriverWait wait;
	private WebDriver driver;
	private Select select;
	private JsScroll js;

	public InsurantDataPage(WebDriver driver) {
		this.driver = driver;
		js = new JsScroll(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);
	}

	@FindBy(how = How.ID, using = "enterinsurantdata")
	private static WebElement tabEnterInsurantData;

	@FindBy(how = How.ID, using = "firstname")
	private static WebElement inputFirstName;

	@FindBy(how = How.ID, using = "lastname")
	private static WebElement inputLastName;

	@FindBy(how = How.ID, using = "opendateofbirthcalender")
	private static WebElement buttonOpenCalendar;

	@FindBy(how = How.ID, using = "birthdate")
	private static WebElement inputBirthDate;

	@FindBy(how = How.XPATH, using = ".//label[@class='ideal-radiocheck-label'][2]")
	private static WebElement radioButtonGenderFemale;

	@FindBy(how = How.XPATH, using = ".//label[@class='ideal-radiocheck-label'][1]")
	private static WebElement radioButtonGenderMale;

	@FindBy(how = How.ID, using = "streetaddress")
	private static WebElement inputStreetAddress;

	@FindBy(how = How.ID, using = "country")
	private static WebElement selectCountry;

	@FindBy(how = How.ID, using = "zipcode")
	private static WebElement inputZipCode;

	@FindBy(how = How.ID, using = "city")
	private static WebElement inputCity;

	@FindBy(how = How.ID, using = "occupation")
	private static WebElement selectOcupation;

	@FindBy(how = How.XPATH, using = ".//div[@class='field idealforms-field idealforms-field-checkbox'][contains(.,'Speeding')]/*/label[4]")
	private static WebElement hobbiesSpeeding;

	@FindBy(how = How.ID, using = "bungeejumping")
	private static WebElement hobbiesBungeeJumping;

	@FindBy(how = How.ID, using = "cliffdiving")
	private static WebElement hobbiesCliffDiving;

	@FindBy(how = How.ID, using = "skydiving")
	private static WebElement hobbiesSkyDiving;

	@FindBy(how = How.ID, using = "other")
	private static WebElement hobbiesOthers;

	@FindBy(how = How.ID, using = "website")
	private static WebElement inputWebsite;

	@FindBy(how = How.ID, using = "nextenterproductdata")
	private static WebElement buttonNextProductData;

	public void clickTabInsuranceData() {
		wait.until(ExpectedConditions.visibilityOf(tabEnterInsurantData));
		tabEnterInsurantData.isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(tabEnterInsurantData));
		tabEnterInsurantData.click();
	}

	public void inputFirsName(String firstName) {
		wait.until(ExpectedConditions.visibilityOf(inputFirstName));
		inputFirstName.sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOf(inputLastName));
		inputLastName.sendKeys(lastName);
	}

	public void inputBirthDate(String birthDate) {
		wait.until(ExpectedConditions.visibilityOf(inputBirthDate));
		inputBirthDate.sendKeys(birthDate);
	}

	public void buttonOpenCalendar() {
		wait.until(ExpectedConditions.visibilityOf(buttonOpenCalendar));
		buttonOpenCalendar.click();
	}

	public void radioButtonGender() {
		wait.until(ExpectedConditions.visibilityOf(radioButtonGenderMale));
		radioButtonGenderMale.click();
		radioButtonGenderMale.isSelected();
	}

	public void inputStreetAddress(String streetAddress) {
		wait.until(ExpectedConditions.visibilityOf(inputStreetAddress));
		inputStreetAddress.sendKeys(streetAddress);
	}

	public void country(String country) {
		wait.until(ExpectedConditions.visibilityOf(selectCountry));
		select = new Select(selectCountry);
		select.selectByVisibleText(country);
	}

	public void inputZipCode(String zipCode) {
		wait.until(ExpectedConditions.visibilityOf(inputZipCode));
		inputZipCode.sendKeys(zipCode);
	}

	public void inputCity(String city) {
		wait.until(ExpectedConditions.visibilityOf(inputCity));
		inputCity.sendKeys(city);
	}

	public void occupation(String occupation) {
		wait.until(ExpectedConditions.visibilityOf(selectOcupation));
		select = new Select(selectOcupation);
		select.selectByVisibleText(occupation);
	}

	public void hobbie() {
		js.scrollDown();
		wait.until(ExpectedConditions.visibilityOf(hobbiesSpeeding));
		hobbiesSpeeding.click();
	}

	public void inputWebSite(String webSite) {
		wait.until(ExpectedConditions.visibilityOf(inputWebsite));
		inputWebsite.sendKeys(webSite);
	}

	public void nextButton() {
		wait.until(ExpectedConditions.visibilityOf(buttonNextProductData));
		buttonNextProductData.click();
	}

	public void fill_PersonalDetails_Insurant(InsurantData insurant) {
		inputFirsName(insurant.inputFirstName);
		inputLastName(insurant.inputLastName);
		inputBirthDate(insurant.inputBirthDate);
		radioButtonGender();
		inputStreetAddress(insurant.inputStreetAddress);
		country(insurant.country);
		inputZipCode(insurant.inputZipCode);
		inputCity(insurant.inputCity);
		occupation(insurant.occupation);
		hobbie();
		inputWebSite(insurant.inputWebSite);
		nextButton();
	}

}