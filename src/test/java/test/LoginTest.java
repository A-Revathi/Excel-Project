package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
   
	WebDriver driver;
	
	ExcelReader excelRead = new ExcelReader("C:\\Users\\revat\\Desktop\\Selenium_June2022\\Mock_Data\\TF_TestData.xlsx");
	String userName = excelRead.getCellData("LoginInfo", "UserName", 2);
	String password = excelRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.inserUserName(userName);
		loginPage.inserPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver,DashboardPage.class );
		dashboardPage.validateDashboardPage();
		
		//BrowserFactory.tearDown();
	
	}
}
