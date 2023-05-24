package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SeleniumTest {

	@Test
	public void seleniumtest() throws InterruptedException
	{
		String name="IPHONE 13 PRO";
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		WebDriver d=new ChromeDriver(c);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://rahulshettyacademy.com/client/");
		WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(30));
		d.findElement(By.id("userEmail")).sendKeys("rahulshetty@gmail.com");
		d.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		d.findElement(By.id("login")).click();
		
		List<WebElement> l=d.findElements(By.cssSelector(".mb-3"));
		WebElement e=l.stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(name))
				.findFirst().orElse(null);;
				e.findElement(By.cssSelector("button:last-child")).click();
				w.until(ExpectedConditions.invisibilityOf(d.findElement(By.cssSelector(".ng-tns-c31-1"))));
				d.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
				
			List<WebElement> l1=	d.findElements(By.cssSelector("h3"));
			Boolean b=l1.stream().anyMatch(p-> p.getText().equalsIgnoreCase(name));
			Assert.assertTrue(true);
			d.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
			d.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
			Thread.sleep(3000);
//			w.until(ExpectedConditions.visibilityOfAllElements(d.findElements(By.xpath("//section//span"))));
			List<WebElement> list=d.findElements(By.xpath("//section//span"));
			for(WebElement country:list)
			{
				System.out.println(country.getText());
				if(country.getText().equalsIgnoreCase("india"))
				{
					System.out.println(country.getText()+"===============");
					country.click();
					break;
				}
			}
			//d.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
//			//Thread.sleep(3000);
//			w.until(ExpectedConditions.visibilityOfAllElements(d.findElements(By.cssSelector(".ta-item"))));
//			
//			List<WebElement> list=d.findElements(By.cssSelector(".ta-item"));
//			
//			WebElement f=list.stream().filter(pp ->pp.getText().equalsIgnoreCase("india")).findAny().orElse(null);
//			f.click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Place Order']")));
			d.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
			
				
		
		

	}
}
