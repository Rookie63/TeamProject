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

public class TestInsert {
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
  public void testInsert() throws Exception {
    driver.get("http://localhost:8080/teamwebproject-Henrich/accountPage.html");
    driver.findElement(By.name("keyword")).click();
    driver.findElement(By.name("keyword")).clear();
    driver.findElement(By.name("keyword")).click();
    driver.findElement(By.name("keyword")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    //driver.get("http://localhost:8080/teamwebproject-Henrich/Login");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Insert Item")).click();
    driver.get("http://localhost:8080/teamwebproject-Henrich/admin/simpleInsertHB.html");
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Desk");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("White Desk");
    driver.findElement(By.name("price")).clear();
    driver.findElement(By.name("price")).sendKeys("$45");
    driver.findElement(By.name("pickup")).clear();
    driver.findElement(By.name("pickup")).sendKeys("false");
    driver.findElement(By.name("delivery")).clear();
    driver.findElement(By.name("delivery")).sendKeys("true");
    driver.findElement(By.name("locations")).clear();
    driver.findElement(By.name("locations")).sendKeys("Omaha");
    driver.findElement(By.name("rooms")).clear();
    driver.findElement(By.name("rooms")).sendKeys("Office");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    Thread.sleep(2000);
    //driver.get("http://localhost:8080/teamwebproject-Henrich/admin/InsertItem");
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
