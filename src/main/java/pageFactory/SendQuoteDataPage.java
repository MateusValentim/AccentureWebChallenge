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
import testDataType.SendQuoteData;
import util.JsScroll;

public class SendQuoteDataPage {

	private WebDriverWait wait;
	private WebDriver driver;

	public SendQuoteDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);

	}

	@FindBy(how = How.ID, using = "email")
	private static WebElement inputEmail;
	
	@FindBy(how = How.ID, using = "phone")
	private static WebElement inputPhone;
	
	@FindBy(how = How.ID, using = "username")
	private static WebElement inputUsername;
	
	@FindBy(how = How.ID, using = "password")
	private static WebElement inputPassword;
	
	@FindBy(how = How.ID, using = "confirmpassword")
	private static WebElement inputConfirmPassword;
	
	@FindBy(how = How.ID, using = "Comments")
	private static WebElement inputComments;
	
	@FindBy(how = How.ID, using = "sendemail")
	private static WebElement sendEmail;
	
	@FindBy(how = How.ID, using = "LoadingPDF")
	private static WebElement loading;
	
	
	public void inputEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(inputEmail));
		inputEmail.sendKeys(email);
	}
	
	public void inputPhone(String phoneNumber) {
		wait.until(ExpectedConditions.visibilityOf(inputPhone));
		inputPhone.sendKeys(phoneNumber);
	}
	
	public void inputUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(inputUsername));
		inputUsername.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(inputPassword));
		inputPassword.sendKeys(password);
	}
	
	public void inputConfirmPassword(String confirmPassword) {
		wait.until(ExpectedConditions.visibilityOf(inputConfirmPassword));
		inputConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void inputComments(String comments) {
		wait.until(ExpectedConditions.visibilityOf(inputComments));
		inputComments.sendKeys(comments);
	}
	
	public void sendEmail() {
		wait.until(ExpectedConditions.visibilityOf(sendEmail));
		sendEmail.click();
	}
	public boolean loading() {
		wait.until(ExpectedConditions.visibilityOf(loading));
		return loading.isDisplayed();

	}
//	public String getMessageThankYou() {
//		wait.until(ExpectedConditions.visibilityOf(messageThankYou));
//		return messageThankYou.getText();
//	}
	
	public void fill_PersonalDetails_SendQuote(SendQuoteData sendQuote) {
		inputEmail(sendQuote.inputEmail);
		inputPhone(sendQuote.inputPhone);
		inputUsername(sendQuote.inputUsername);
		inputPassword(sendQuote.inputPassword);
		inputConfirmPassword(sendQuote.inputConfirmPassword);
		inputComments(sendQuote.inputComments);
		sendEmail();
	}
	
}