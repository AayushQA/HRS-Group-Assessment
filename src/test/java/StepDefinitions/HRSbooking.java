package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HRSbooking {


	//WebDriverManager driver = null;  
	
	ChromeDriver driver = new ChromeDriver();
	
	@Given("^User navigates to the HRS booking portal$")
	public void user_navigates_to_webpage() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//driver.manage().getCookies();
		
		driver.manage().window().maximize();
		driver.get("https://www.hrs.de/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).sendKeys(Keys.ENTER);
		

		
	    
	}

	@When("^User clicks in the search textbox and enters valid destination- Barcelona$")
	public void user_enters_text() throws InterruptedException {

		driver.findElement(By.xpath("//span[@title='Ort, Hotel, Region, Adresse, PLZ']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"DestinationSearchInput\"]")).sendKeys("Barcelona");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"DestinationSearchInput\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		
	
	
	
	
	
		
        
	}

	@And("^User selects the Arrival and departure date$")
	public void User_selects_the_Arrival_and_departure_date() throws InterruptedException {
		
		WebElement D = driver.findElement(By.xpath("//div[@class='DateRangeInputField_date__IAUhI']"));
		D.click();
		driver.findElement(By.xpath("//div[@class='Calendar_monthsDesktop__5TRHv']//img[@alt='left']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='Calendar_monthsDesktop__5TRHv']//div[@class='Month_right__nAPB6']//img[@alt='left']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='Calendar_monthsDesktop__5TRHv']//div[2]//div[4]//div[4]")).click();
		driver.findElement(By.xpath("//div[@class='Calendar_monthsDesktop__5TRHv']//div[@id='selectedMonth']//div[@class='Day_container__Rx8e0'][normalize-space()='7']")).click();
		Thread.sleep(500);

		
		
		
	}

	@Then("User selects number of rooms & persons")
	public void user_selects_number_of_rooms_persons() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='1 Zimmer']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='1 Erwachsener - 1 Einzelzimmer']")).click();
		Thread.sleep(500);
	}
		

		
	
	
	@And("^User clicks on the “Search Hotels”$")
	public void clicks_on_search_button() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[@data-test='SearchHotelsButton_span']")).click();
		Thread.sleep(500);
		
	}

	
		
	@Then("user can filter the hotels by low price availability")
	public void user_can_filter_the_hotels_by_low_price_availability() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[normalize-space()='Preis']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[normalize-space()='Günstigster Preis zuerst (aufsteigend)']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@Then("^User should be able to select the hotel$")
	public void user_gets_the_search_results() throws InterruptedException {
	

		WebElement D = driver.findElement(By.xpath("//button[@id='HotelDetailsButton_757046']//span[contains(text(),'Hoteldetails')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(D).build().perform();
		driver.findElement(By.xpath("//span[normalize-space()='Bcnsporthostels']")).click();
		Thread.sleep(1000);
		driver.quit();
		
	}
	}

