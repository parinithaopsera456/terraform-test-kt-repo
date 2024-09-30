package com.microsoft.example;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@Parameters
public class UITestIT {
  private WebDriver driver = null;
  
  @BeforeMethod
  public void crankUpDriver() {
	// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
  ChromeOptions options = new ChromeOptions();
  options.addArguments("--headless");

 driver = new ChromeDriver(options);
  // driver = new ChromeDriver();
	 //driver = new HtmlUnitDriver();
  }
  
  @Test
  public void getHomePage() {
    driver.get("http://20.198.189.116:8080/myshuttledev");

  
    String title = driver.getTitle();
    System.out.print("title ----"+title);
    assertEquals("The first page should have a title of Login",
      "MyShuttle Login", title);
  }
  
  @Test
  public void loginToTheSite() {
    driver.get("http://20.198.189.116:8080/myshuttledev");
    
    WebElement username = driver.findElement(By.id("email"));
    WebElement password = driver.findElement(By.id("password"));
    username.sendKeys("fred");
    password.sendKeys("fredpassword");
    driver.findElement(By.xpath(".//input[@class='btn btn-primary']")).click();
    
    
  }
  
	/*
	 * @Test
	 * 
	 * @Parameters({ "baseUrl" }) public void viewFares(String baseUrl) {
	 * driver.get(baseUrl + "/");
	 * 
	 * // Login WebElement username = driver.findElement(By.name("email"));
	 * WebElement password = driver.findElement(By.name("password"));
	 * username.sendKeys("fred"); password.sendKeys("fredpassword");
	 * password.submit(); String title = driver.getTitle();
	 * assertEquals("After login, the dashboard page should have a title of Dashboard"
	 * , "Dashboard", title);
	 * 
	 * // Dashboard: just go to the next link driver.get(baseUrl + "/home.jsp");
	 * title = driver.getTitle();
	 * assertEquals("After the dashboard, the home page should have a title of Employee Fares"
	 * , "Employee Fares - fred", title); }
	 */
  
  @AfterMethod
  public void shutdownTheDriver() {
    driver.quit();
    driver = null;
  }
}

