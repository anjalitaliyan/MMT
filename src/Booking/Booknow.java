package Booking;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booknow {

//	@SuppressWarnings("unlikely-arg-type")
//	@SuppressWarnings("unlikely-arg-type")
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {

//		global Variables
		String fromCity = "Kolkata";
		String toCity = "Delhi";

		System.setProperty("webdriver.chrome.driver", "C:/Users/prata/OneDrive/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		LocalDate date = LocalDate.now();
		System.out.println(date);

//		Wait for iFrame and SwitchToit and close it
		try {
			w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
					By.id("webklipper-publisher-widget-container-notification-frame")));
			w.until(ExpectedConditions
					.elementToBeClickable(By.id("webklipper-publisher-widget-container-notification-close-div")))
					.click();
//			driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();	
			driver.switchTo().defaultContent();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}

//		Giving data for flight search;
		driver.findElement(By.id("fromCity")).sendKeys(fromCity);
		Thread.sleep(2000);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='react-autowhatever-1']//p")));
		List<WebElement> from = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//p"));
		for(int i=0; i<from.size(); i++) {
			if(from.get(i).getText().contains(fromCity)) {
				from.get(i).click();
				break;
			}
		}
		w.until(ExpectedConditions.elementToBeClickable(By.id("toCity"))).sendKeys(toCity);
		Thread.sleep(2000);
		List<WebElement> to = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//p"));
		for(int i=0; i<to.size(); i++) {
			if(to.get(i).getText().contains(toCity)) {
				to.get(i).click();
			}
		}
		
		
		
		
		
	}

}
