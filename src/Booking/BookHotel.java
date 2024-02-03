package Booking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookHotel {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/prata/OneDrive/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chHotels']")).click();
//		id="hsw_search_button"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("hsw_search_button")).click();
//		driver.findElement(By.xpath("//button[@id='hsw_search_button']")).click();
		
		
	}

}
