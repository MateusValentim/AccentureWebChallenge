package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testDataType.CustomerData;


public class VehicleDataPage  {
	
	private WebDriverWait wait;
	private WebDriver driver;
	private Select select;
	
	public VehicleDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver,10);		

	}

	@FindBy(how = How.ID, using = "entervehicledata")
	private static WebElement tabEnterVehicleData;
	
	@FindBy(how = How.ID, using = "make")
	private static WebElement selectMake;
	
	@FindBy(how = How.XPATH, using = "//select[@id='model']")
	private static WebElement selectModel;
	
	@FindBy(how = How.ID, using = "cylindercapacity")
	private static WebElement inputCylinderCapacity;
	
	@FindBy(how = How.ID, using = "engineperformance")
	private static WebElement inputEnginePerformanceKw;
	
	@FindBy(how = How.XPATH, using = "//button[@id='opendateofmanufacturecalender']")
	private static WebElement buttonCalendar;
	
	@FindBy(how = How.XPATH, using = "//table[@class='ui-datepicker-calendar']//tbody")
	private static WebElement calendarStructure;
	
	@FindBy (how = How.ID, using = "dateofmanufacture")
    private static WebElement inputDataCalendar;
	
	@FindBy (how = How.ID, using = "numberofseats")
    private static WebElement selectNumberOfSeats;
	
	@FindBy (how = How.ID, using = "fuel")
    private static WebElement selectFuelType;
	
	@FindBy (how = How.ID, using = "listprice")
    private static WebElement inputListprice;
	
	@FindBy (how = How.ID, using = "licenseplatenumber")
    private static WebElement inputLicensePlateNumber;
	
	@FindBy (how = How.ID, using = "annualmileage")
    private static WebElement inputAnnualMileage;
	
	
	@FindBy (how = How.ID, using = "nextenterinsurantdata")
	private static WebElement buttonNext;
	
	public void tabEnterVehicleData() {
		wait.until(ExpectedConditions.visibilityOf(tabEnterVehicleData));
		tabEnterVehicleData.click();
	}
		
	public void make(String make) {
		wait.until(ExpectedConditions.visibilityOf(selectMake));
		select = new Select(selectMake);
		select.selectByVisibleText(make);	
	}
	
	public void enginePerformanceKw(String enginePerformanceKw) {
		wait.until(ExpectedConditions.visibilityOf(inputEnginePerformanceKw));
		wait.until(ExpectedConditions.elementToBeClickable(inputEnginePerformanceKw));
		inputEnginePerformanceKw.click();
		inputEnginePerformanceKw.sendKeys(enginePerformanceKw);
	}
	
	public void inputCalendarDate(String inputDate) {
		wait.until(ExpectedConditions.visibilityOf(inputDataCalendar));
		inputDataCalendar.sendKeys(inputDate);
	}
	
	public void numberOfSeats(String numberSeats) {
		wait.until(ExpectedConditions.visibilityOf(selectNumberOfSeats));
		select = new Select(selectNumberOfSeats);
		select.selectByVisibleText(numberSeats);	
	}
	
	public void fuelType(String fuelType) {
		wait.until(ExpectedConditions.visibilityOf(selectFuelType));
		select = new Select(selectFuelType);
		select.selectByVisibleText(fuelType);	
	}
	public void inputListPrice(String listPrice) {
		wait.until(ExpectedConditions.visibilityOf(inputListprice));
		inputListprice.sendKeys(listPrice);
	}
	
	public void inputLicensePlateNumber(String licensePlateNumber) {
		wait.until(ExpectedConditions.visibilityOf(inputLicensePlateNumber));
		inputLicensePlateNumber.sendKeys(licensePlateNumber);
	}
	
	public void inputAnnualMileage(String annualMileage) {
		wait.until(ExpectedConditions.visibilityOf(inputAnnualMileage));
		inputAnnualMileage.sendKeys(annualMileage);
	}
	
	public void buttonNext() {
		wait.until(ExpectedConditions.visibilityOf(buttonNext));
		buttonNext.click();
	}
	
	public void fill_PersonalDetails_Vehicle(CustomerData customerData) {
	make(customerData.make);
   	enginePerformanceKw(customerData.enginePerformanceKw);
   	enginePerformanceKw(customerData.enginePerformanceKw);
   	inputCalendarDate(customerData.inputCalendarDate);
   	numberOfSeats(customerData.numberOfSeats);
   	fuelType(customerData.fuelType);
   	inputListPrice(customerData.inputListPrice);
   	inputLicensePlateNumber(customerData.inputLicensePlateNumber);
   	inputAnnualMileage(customerData.inputAnnualMileage);
   	buttonNext();
	}
}