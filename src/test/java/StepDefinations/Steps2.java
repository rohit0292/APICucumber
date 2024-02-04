package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class Steps2 {
	
	public WebDriver driver;
	
	@Given("user navigates to the website {string}")
	public void user_navigates_to_the_website(String string) {
	    
		driver  = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user navigate to the login page")
	public void user_navigate_to_the_login_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
	}

	@When("user enter Username in login window by using {string}")
	public void user_enter_username_in_login_window_by_using(String Email)  {
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	}

	@When("User enter Password in login window by using {string}")
	public void user_enter_password_in_login_window_by_using(String password)  {
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		 
	}

	@Then("login must be successful.")
	public void login_must_be_successful() {
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).sendKeys(Keys.ENTER);
	}
	


	@And("Page Title should be {string}")
	public void page_title_should_be(String string) {
	   
		String title = driver.getTitle();
		
		if (title.equalsIgnoreCase("Amazon")) {
			
			System.out.println("Title is correct");
			
		}
		else{
			
			System.out.println("Title is not correct");
		}
	}

	@And("User click on Log out link")
	public void user_click_on_log_out_link() {
	    
		Actions action = new Actions(driver);
		WebElement link=  driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	
		action.moveToElement(link).doubleClick().build().perform();
		
		driver.findElement(By.xpath("(//div[@class='nav-left'])[3]"));
		
		
	}

	
	@Then("Clik on Menubutton")
	public void clik_on_menubutton() throws InterruptedException {
	    Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='nav-left'])[3]")).click();
		driver.navigate().refresh();
	}
	@Then("click on Echo & Alexa farward arrow")
	public void click_on_echo_alexa_farward_arrow() throws InterruptedException {
	  Thread.sleep(3000);
      driver.findElement(By.xpath("//div[normalize-space()='Echo & Alexa']")).click();
		
		
	}

	@Then("click on Alexa skills page")
	public void click_on_alexa_skills_page() {

		driver.findElement(By.xpath("//a[normalize-space()='Alexa Skills']")).click();
		driver.navigate().refresh();
		
	}

	@Then("Capture all feature with text.")
	public void capture_all_feature_with_text() {

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
	}
	@Then("Close browser")
	public void close_browser() {
	 
		driver.close();
	}

}
