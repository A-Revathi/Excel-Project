package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	// For POM defining element -> @FindBy(how = How. , using = "")
    //WebElement list
	//type name = value
	@FindBy(how = How.ID, using = "username")
	WebElement USER_ELEMENT;
	@FindBy(how = How.ID, using = "password")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.NAME, using = "login")
	WebElement SIGNIN_BUTTON_ELEMENT;

	//corresponding methods
	public void inserUserName(String userName) {
		USER_ELEMENT.sendKeys(userName);
	}
	public void inserPassword(String passWord) {
		PASSWORD_ELEMENT.sendKeys(passWord);
	}
	public void clickSignIn() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
}
