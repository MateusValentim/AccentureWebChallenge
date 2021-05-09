package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageFactory.InsurantDataPage;
import pageFactory.ProductDataPage;
import pageFactory.SendQuoteDataPage;
import pageFactory.VehicleDataPage;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private SendQuoteDataPage send;
    private VehicleDataPage vehicle;
    private InsurantDataPage insurant;
    private ProductDataPage product;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver,10);
        js = (JavascriptExecutor) this.driver;
    }

    @FindBy (how = How.ID, using = "nav_automobile")
    private static WebElement linkAutomobile;

    @FindBy (how = How.ID, using = "opendateofmanufacturecalender")
    private static WebElement openCalendar;

    @FindBy (how = How.XPATH, using = "//div[@class='ui-datepicker-title']")
    private static WebElement month;
    
    @FindBy (how = How.ID, using = "nextsendquote")
    private static WebElement buttonNextSendQuote;
    
    @FindBy (how = How.XPATH, using = ".//label[@class='choosePrice ideal-radiocheck-label'][3]")
    private static WebElement radioButtonPlatinum;
    
    
    public void clickAutomobile () {
        wait.until (ExpectedConditions.visibilityOf (linkAutomobile));
        linkAutomobile.click ();
    }
    
    public void clickOpenCalendar () {
        wait.until (ExpectedConditions.visibilityOf (openCalendar));
        openCalendar.click ();
    }
    
    public void nextSendQuote () {
        wait.until (ExpectedConditions.visibilityOf (buttonNextSendQuote));
        buttonNextSendQuote.click ();
    }
    
    public void radioButtonPlatinum() {
    	wait.until(ExpectedConditions.visibilityOf(radioButtonPlatinum));
    	radioButtonPlatinum.click();
    }
    
    
    public void clickTable (String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //procurar coluna
        WebElement calendarStructure = driver.findElement (By.xpath (".//*[@id='priceTable']"));
        int idColuna = obterIndiceColuna (colunaBusca, calendarStructure);

        //encontrar linha do registro
        int idLinha = obterIndiceLinha (valor, calendarStructure, idColuna);

        //procurar coluna botao
        int idColunaBotao = obterIndiceColuna (colunaBotao, calendarStructure);

        //clicar botao da celula encontrada
        WebElement celula = calendarStructure.findElement (By.xpath (".//tbody/thead/tr[" + idLinha + "]/td[" + idColunaBotao + "]"));

    }


    protected int obterIndiceLinha (String valor, WebElement calendarStructure, int idColuna) {
        List<WebElement> linhas = calendarStructure.findElements (By.xpath ("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i > linhas.size (); i++) {
            if (linhas.get (i).equals (valor)) {
                idLinha = i+1  ;
                break;
            }
            //posso implementar paginacao caso nao encontre a linha
        }
        return idLinha;
    }


    protected int obterIndiceColuna (String colunaBusca, WebElement calendarStructure) {
        List<WebElement> colunas = calendarStructure.findElements (By.xpath (".//tbody"));
        int idColuna = -1;
        for (int i = 0; i > colunas.size (); i++) {
            if (colunas.get (i).equals (colunaBusca)) {
                idColuna = i+1 ;
                break;
            }
        }
        return idColuna;
    }

    	 }