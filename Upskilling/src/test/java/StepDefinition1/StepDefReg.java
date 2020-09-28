package StepDefinition1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefReg {
	WebDriver driver;
	@Before
	public void beforetest()
	{
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	}
	@Given("I am able to navigate onto Signin page")
	public void i_am_able_to_navigate_onto_signin_page() {
	   driver.get("http://elearningm1.upskills.in/");
	   driver.findElement(By.xpath("//div[@class='sidebar']/div/div/ul/li[1]")).click();
	   
	}

	@Given("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	 driver.findElement(By.id("registration_firstname")).sendKeys(string); 
	 driver.findElement(By.id("registration_lastname")).sendKeys(string2);
	}

	@And("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String string, String string2, String string3) {
		driver.findElement(By.id("registration_email")).sendKeys(string); 
		 driver.findElement(By.id("username")).sendKeys(string2);
		 driver.findElement(By.id("pass1")).sendKeys(string3);
	}

	@And("User provide the {string} for confirmation")
	public void user_provide_the_for_confirmation(String string) {
		driver.findElement(By.id("pass2")).sendKeys(string);
	}

	@And("I click on the login button")
	public void i_click_on_the_login_button() {
		driver.findElement(By.id("registration_submit")).click();;
	}

	@Then("I should see the username as {string}")
	public void i_should_see_the_username_as(String string) {
	    System.out.println("signup is successful");
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.close();
	}
	@Given("click on the login_icon")
	public void click_on_the_login_icon() {
		
		driver.get("http://elearningm1.upskills.in/");
	    driver.findElement(By.id("login")).sendKeys("manisha.dey");
	    driver.findElement(By.id("password")).sendKeys("Doremon$123");
	    driver.findElement(By.id("form-login_submitAuth")).click();
	   driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/a")).click();
	}

	@Given("Click on inbox and select compose message")
	public void click_on_inbox_and_select_compose_message() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[@title='Inbox']")).click();
		driver.findElement(By.xpath("//div[@class='row']/div/a/img[@title='Compose message']")).click();
	}

	@Given("select the send to id")
	public void select_the_send_to_id() {
	   driver.findElement(By.xpath("//span[@class='selection']/span/ul/li/input")).sendKeys("manisha1dey@gmail.com");
	}

	@Given("Write the subject of the email")
	public void write_the_subject_of_the_email() {
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys("Confirmation Email");
	}

	@Given("the message needs to be sent")
	public void the_message_needs_to_be_sent() throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='Rich Text Editor, content']")));
        driver.switchTo().activeElement().sendKeys("Hello Manisha\n This is for testing");
        driver.switchTo().defaultContent();

	}

	@Then("click on send")
	public void click_on_send() {
		((JavascriptExecutor) driver).executeScript("window.scroll(0,1000)");
		driver.findElement(By.id("compose_message_compose")).click();
	    
	}
	@Then("I should see the username already exists")
	public void i_should_see_the_username_already_exists() {
	    String userMessage=driver.findElement(By.xpath("//div[@class='row']/div/div[@class='alert alert-warning']")).getText();
	    System.out.println(userMessage);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.close();
	}
	@Given("User has already the existing account")
	public void user_has_already_the_existing_account()  {
		driver.get("http://elearningm1.upskills.in/main/auth/inscription.php");
	    driver.findElement(By.xpath("//*[@id='navbar']/ul/li/a")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Given("Enter the Username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.id("login")).sendKeys("manisha.dey");
		driver.findElement(By.id("password")).sendKeys("Doremon$123");
	}

	@Given("click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.id("form-login_submitAuth")).click();
	}

	@Then("User will be moved to Home page")
	public void user_will_be_moved_to_home_page() {
	    System.out.println("User is logged in");
	}
}
