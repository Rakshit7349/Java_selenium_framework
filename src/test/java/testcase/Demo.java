package TestNG;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Demo extends Generic 
{
	@Test
	public void Test1() throws IOException
	{
		driver.get("Https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 14");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//div[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div/h2/a/span")).click();
		Set<String> id = driver.getWindowHandles();
		for(String ids:id)
		{
			driver.switchTo().window(ids);
		}
	
		driver.findElement(By.id("add-to-cart-button")).click();
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/amazon1.png");
		FileHandler.copy(src, dst);
	}
}
