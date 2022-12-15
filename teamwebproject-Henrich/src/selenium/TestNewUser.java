package selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class TestNewUser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "WebContent\\WEB-INF\\chromedriverupdated.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testSignupNew() throws Exception {
    driver.get("http://localhost:8080/teamwebproject-Henrich/accountPage.html");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Sign Up")).click();
    driver.get("http://localhost:8080/teamwebproject-Henrich/signUp.html");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("newuser");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("new");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(2000);
    //driver.get("http://localhost:8080/teamwebproject-Henrich/SignUp");
    driver.findElement(By.linkText("Login")).click();
    Thread.sleep(2000);
    //driver.get("http://localhost:8080/teamwebproject-Henrich/accountPage.html");
    Thread.sleep(2000);
    driver.findElement(By.name("keyword")).click();
    driver.findElement(By.name("keyword")).clear();
    driver.findElement(By.name("keyword")).sendKeys("newuser");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("new");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(2000);
    //driver.get("http://localhost:8080/teamwebproject-Henrich/Login");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
