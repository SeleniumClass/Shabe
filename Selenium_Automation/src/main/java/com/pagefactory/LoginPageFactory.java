package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		//This initElements method will create all WebElements
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 200);
		//PageFactory.initElements( driver,factory);
	}
	
	//Login function xpath
}
