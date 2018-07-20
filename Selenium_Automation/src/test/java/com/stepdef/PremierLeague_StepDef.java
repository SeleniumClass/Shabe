package com.stepdef;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.pagefactory.PageFactory_PremierLeague;
import com.utility.Highlighter;
import com.utility.Screenshot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PremierLeague_StepDef {
	
	WebDriver driver;
	PageFactory_PremierLeague pg;
	JavascriptExecutor js;
	Actions act;
	
	
	@Given("^User is able to open the Chrome browser$")
	public void users_are_able_to_open_the_Chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/Shabe/Downloads/chromedriver");
		driver = new ChromeDriver(); 
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   
	}

	@Given("^Locate URL: https://www\\.premierleague\\.com/tables and press on Enter button$")
	public void locate_URL_https_www_premierleague_com_tables_and_press_on_Enter_button() throws Throwable {
		driver.get("https://www.premierleague.com/tables");
		pg = PageFactory.initElements(driver, PageFactory_PremierLeague.class);
	   
	}

	@When("^Users enter the table page$")
	public void users_enter_the_table_page() throws Throwable {
	    pg.getcookie().click();
	    Thread.sleep(3000);
	   
	}

	@Then("^Users are able to see the club names highlighted in red boxes$")
	public void users_are_able_to_see_the_club_names_highlighted_in_red_boxes() throws Throwable {
		for(WebElement a: pg.getclub()) {
			Highlighter.getDrawRedColor(driver, a);
		}
		//for(int i = 0; i< pg.getclub().size(); i++) {
			//Highlighter2.getDrawRedColor(driver,pg.getclub().get(i));
		//	}
		
		for(WebElement a: pg.getclub()) {
			js.executeScript("arguments[0].scrollIntoView();",a);
			Thread.sleep(500);
		}
//		for(int i = 0; i< pg.getclub().size(); i++) {
//			js.executeScript("arguments[0].scrollIntoView();",pg.getclub().get(i));
//			Thread.sleep(500);
//		}
		
	js.executeScript("window.scrollBy(0, -1000)", "");
	   
	}

	@Then("^Observe the total number of clubs$")
	public void observe_the_total_number_of_clubs() throws Throwable {
		int num = pg.getclub().size();
		System.out.println(num);
	   
	}

	@Then("^Observe all the club names$")
	public void observe_all_the_club_names() throws Throwable {
		
		for(int i =0; i < pg.getclub().size(); i++) {
			System.out.println(pg.getposition().get(i).getText() + ". "+ pg.getclub().get(i).getText());

				}
	   
	}

	@When("^Users highlight the club Chelsea$")
	public void users_highlight_the_club_Chelsea() throws Throwable {
		//act.dragAndDrop(pg.getdrag(), pg.getdrop()).build().perform();
		js.executeScript("function selectElementContents(el) {var range = document.createRange();range.selectNodeContents(el); var sel = window.getSelection(); sel.removeAllRanges(); sel.addRange(range);} var el = document.querySelector('#mainContent > div > div.mainTableTab.active > div.allTablesContainer > div > div > div > table > tbody > tr:nth-child(11) > td.team > a > span.long');selectElementContents(el);");
	   Thread.sleep(2000);
	}

	@Then("^Users are able to see Chelsea highlighted in blue box$")
	public void users_are_able_to_see_Chelsea_highlighted_in_a_blue_box() throws Throwable {
	
		for(WebElement a: pg.getclub()) {
			if(a.getText().equalsIgnoreCase("Chelsea")) {
				System.out.println("Chelsea is there");
				Highlighter.getDrawBlueColor(driver,a);
			}
		}
		
//		for(int i=0; i <pg.getclub().size(); i++) {
//			if(pg.getclub().get(i).getText().equalsIgnoreCase("Chelsea")) {
//				System.out.println("Chelsea is there");
//				Highlighter2.getDrawBlueColor(driver,pg.getclub().get(i));}
//		}
	   
	}

	@Then("^See Chelsea position is '6' highlighted in a blue box$")
	public void see_Chelsea_position_is_highlighted_in_a_blue_box() throws Throwable {
		for(WebElement b: pg.getposition()) {
			if(b.getText().equalsIgnoreCase("6")) {
				System.out.println("Chelsea's position is "+ b);
				Highlighter.getDrawBlueColor(driver, b);
			}
		}
		
//		for(int i=0; i <pg.getclub().size(); i++) {
//		if(pg.getposition().get(i).getText().equalsIgnoreCase("6")) {
//			System.out.println("Chelsea's position is " + pg.getposition().get(i).getText());
//			Highlighter2.getDrawBlueColor(driver,pg.getposition().get(i));
//		}
//	}
	}
	

	@Then("^Take a screenshot of the page$")
	public void take_a_screenshot_of_the_page() throws Throwable {
		Screenshot.captureScreenShot(driver, "Chelsea page");   
	   
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	   
	}

}