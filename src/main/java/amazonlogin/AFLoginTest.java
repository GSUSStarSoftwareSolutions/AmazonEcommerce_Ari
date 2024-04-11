package amazonlogin;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AFLoginTest {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.get("https://www.amazon.in/");
	
	driver.manage().window().maximize();
	
	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	
	searchBox.sendKeys("lenovo laptops");
	
	searchBox.submit();
	
	String mainPage = driver.getWindowHandle();
	
	System.out.println("Main Page="+ mainPage);
	
	driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();

	Set<String> allPages = driver.getWindowHandles();
    for (String page : allPages) {
        if (!page.equals(mainPage)) {
            driver.switchTo().window(page);
            break;
		}
	}
	
	System.out.println(driver.getCurrentUrl());
	driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	
	}

}
