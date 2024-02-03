package Booking;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class choice {

	
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/prata/OneDrive/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/hotels");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("hsw_search_button")).click();
		List<WebElement> price = driver.findElements(By.id("hlistpg_hotel_shown_price"));
		List<WebElement> allHotel=driver.findElements(By.xpath("//div[@class='flexOne makeFlex']//span[@class='wordBreak appendRight10']"));
		int min=Integer.MAX_VALUE;
		WebElement lowHotel = null;
		for(int i=0; i<price.size(); i++) {
			int current = Integer.parseInt(price.get(i).getText().replaceAll("[₹,]","").trim());
			if(current<min) {
				min=current;
				lowHotel=allHotel.get(i);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		lowHotel.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		String nexWindow = it.next();
		driver.switchTo().window(nexWindow);
		System.out.println(driver.getTitle());
		
		
//
//		// Iterate through handles to switch to the new window
//		for (String handle : windowHandles) {
//		    // Switch to the new window
//		    driver.switchTo().window(handle);
//		}
//		driver.findElement(By.xpath("[@class='slickReset--imgContanr']")).click();
//		String getWindowHandle=driver.getWindowHandle();
//		driver.switchTo().window(getWindowHandle);
//		System.out.println("min value is "+min);
		
	}
}