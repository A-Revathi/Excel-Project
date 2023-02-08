package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;

	ExcelReader excelRead = new ExcelReader(
			"C:\\Users\\revat\\Desktop\\Selenium_June2022\\Mock_Data\\TF_TestData.xlsx");
	String userName = excelRead.getCellData("LoginInfo", "UserName", 2);
	String password = excelRead.getCellData("LoginInfo", "Password", 2);
	
	String fullName = excelRead.getCellData("AddContactInfo", "FullName", 2);
	String company = excelRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = excelRead.getCellData("AddContactInfo", "Email", 2);
	String phoneNum = excelRead.getCellData("AddContactInfo", "Phone", 2);
	String address = excelRead.getCellData("AddContactInfo", "Address", 2);
	String city = excelRead.getCellData("AddContactInfo", "City", 2);
	String state = excelRead.getCellData("AddContactInfo", "State", 2);
	String zip = excelRead.getCellData("AddContactInfo", "Zip", 2);
	String country = excelRead.getCellData("AddContactInfo", "Country", 2);
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() throws Exception {

		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inserUserName(userName);
		loginPage.inserPassword(password);
		loginPage.clickSignIn();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phoneNum);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuButton();
		
		addCustomerPage.verifyInsertedName();

		// BrowserFactory.tearDown();

	}
}
