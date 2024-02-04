package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	
	public WebDriver driver;
	
	@Given("User Launch Chrome browsere")
	public void user_launch_chrome_browsere() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	
	    
	}

	@When("User open URL {string}")
	public void user_open_url(String string) throws InterruptedException {
	    
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		
		
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String Email, String password) {
	    
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		
	}

	@Then("Click on Login")
	public void click_on_login() {
	    driver.findElement(By.xpath("//input[@id='signInSubmit']")).sendKeys(Keys.ENTER);
	}

	@Then("Clik on Menubutton")
	public void clik_on_menubutton() throws InterruptedException {
	    Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='nav-left'])[3]")).click();
		driver.navigate().refresh();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) {
	   
		String title = driver.getTitle();
		
		if (title.equalsIgnoreCase("Amazon")) {
			
			System.out.println("Title is correct");
			
		}
		else{
			
			System.out.println("Title is not correct");
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	    
		Actions action = new Actions(driver);
		WebElement link=  driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	
		action.moveToElement(link).doubleClick().build().perform();
		
		driver.findElement(By.xpath("(//div[@class='nav-left'])[3]"));
		
		
	}

	@Then("Close browser")
	public void close_browser() {
	 
		driver.close();
	}
	
	

}
