package manager;

import org.openqa.selenium.WebDriver;

import core.BasePage;
import pageFactory.InsurantDataPage;
import pageFactory.ProductDataPage;
import pageFactory.SendQuoteDataPage;
import pageFactory.VehicleDataPage;

public class PageObjectManager {

    private WebDriver driver;
    private BasePage basePage;
    private VehicleDataPage vehicleDataPage;
    private InsurantDataPage insurantDataPage;
    private ProductDataPage productDataPage;
    private SendQuoteDataPage sendQuoteDataPage;

    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getBasePage () {

        return (basePage == null) ? basePage = new BasePage (driver) : basePage;

    }
    public VehicleDataPage getVehicleDataPage () {

        return (vehicleDataPage == null) ? vehicleDataPage = new VehicleDataPage (driver) : vehicleDataPage;

    }
    
    public InsurantDataPage getInsurantDataPage () {

        return (insurantDataPage == null) ? insurantDataPage = new InsurantDataPage (driver) : insurantDataPage;

    }
    
    public ProductDataPage getProductDataPage () {

        return (productDataPage == null) ? productDataPage = new ProductDataPage (driver) : productDataPage;

    }
    
    public SendQuoteDataPage getSendQuoteDataPage () {

        return (sendQuoteDataPage == null) ? sendQuoteDataPage = new SendQuoteDataPage (driver) : sendQuoteDataPage;

    }

}