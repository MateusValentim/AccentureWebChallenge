package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import manager.FileReaderManager;
import testDataType.CustomerData;
import testDataType.InsurantData;
import testDataType.ProductData;
import testDataType.SendQuoteData;

public class JsonDataReader {

	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Customer.json";
	private final String insurantFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Insurant.json";
	private final String productFilePath  = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Product.json";
	private final String sendQuoteFilePath  = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "SendQuote.json";


	private List<CustomerData> customerList;
	private List<InsurantData> insurantList;
	private List<ProductData>  productList;
	private List<SendQuoteData> sendQuoteList;

	
	public JsonDataReader(){
		customerList = getCustomerData();
		insurantList = getInsurantData();
		productList  = getProductData();
		sendQuoteList = getSendQuoteData();
	}
	
	

	private List<CustomerData> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			CustomerData[] customers = gson.fromJson(bufferReader, CustomerData[].class);
			return Arrays.asList(customers);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo Json não encontrado em : " + customerFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {

			}
		}
	}
	
	private List<InsurantData> getInsurantData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(insurantFilePath));
			InsurantData[] insurant = gson.fromJson(bufferReader, InsurantData[].class);
			return Arrays.asList(insurant);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo Json não encontrado em : " + insurantFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {

			}
		}
	}
	
	private List<ProductData> getProductData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(productFilePath));
			ProductData[] product = gson.fromJson(bufferReader, ProductData[].class);
			return Arrays.asList(product);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo Json não encontrado em : " + productFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {

			}
		}
	}
	
	private List<SendQuoteData> getSendQuoteData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(sendQuoteFilePath));
			SendQuoteData[] sendQuote = gson.fromJson(bufferReader, SendQuoteData[].class);
			return Arrays.asList(sendQuote);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo Json não encontrado em : " + sendQuoteFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {

			}
		}
	}

	public final CustomerData getCustomerByVehicle(String customer){
		for(CustomerData customerData : customerList) {
			if(customerData.inputLicensePlateNumber.equalsIgnoreCase(customer)) return customerData;
		}
		return null;
	}
	
	public final InsurantData getCustomerByInsurant(String insurant){
		for(InsurantData insurantData : insurantList) {
			if(insurantData.inputFirstName.equalsIgnoreCase(insurant)) return insurantData;
		}
		return null;
	}
	
	public final ProductData getCustomerByProduct(String product){
		for(ProductData productData : productList) {
			if(productData.startDate.equalsIgnoreCase(product)) return productData;
		}
		return null;
	}
	
	public final SendQuoteData getCustomerBySendQuote(String sendQuote){
		for(SendQuoteData sendQuoteData : sendQuoteList) {
			if(sendQuoteData.inputUsername.equalsIgnoreCase(sendQuote)) return sendQuoteData;
		}
		return null;
	}
}