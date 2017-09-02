package sam;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {
	public static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions chromeOp = new ChromeOptions();
		chromeOp.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium_drivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver(chromeOp);
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		 //driver.manage().window().maximize();
		String mainwindow = driver.getWindowHandle();
		System.out.println("Main window name : "+mainwindow);
		driver.findElement(By.xpath("//*[text()='New Message Window']"))
				.click();
		
		Set<String> windows=driver.getWindowHandles();
		for (String string : windows) {
			System.out.println(string);
			if(!mainwindow.equals(string))
			{
				driver.switchTo().window(string);
				System.out.println("Child window : "+string);
				driver.close();
			}
		}

	}

}
