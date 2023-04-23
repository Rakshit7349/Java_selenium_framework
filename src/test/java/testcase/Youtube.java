package Scenarios;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Youtube {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","./Software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.youtube.com");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Pathaan Trailer");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.findElement(By.xpath("//a[@title='Pathaan | Official Trailer | Shah Rukh Khan | Deepika Padukone | John Abraham | Siddharth Anand']")).click();
		driver.findElement(By.xpath("//div[@id='segmented-like-button']")).click();
		driver.findElement(By.xpath("//yt-formatted-string[.='Sign in to make your opinion count.']"));
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/youtube.png");
		FileHandler.copy(src, dst);
		driver.close();
		
	}
}
