package selenium_tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTqs {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/tqs/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:4200/tqs";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRegisterTqs() throws Exception {
        driver.get("http://localhost:4200/signup");
        driver.findElement(By.xpath("//input[@id='']")).click();
        driver.findElement(By.xpath("//input[@id='']")).clear();
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("Manuel");
        driver.findElement(By.xpath("(//input[@id=''])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id=''])[2]")).sendKeys("manuel@ua.pt");
        driver.findElement(By.xpath("(//input[@id=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@id=''])[3]")).sendKeys("123");
        driver.findElement(By.xpath("(//input[@id=''])[4]")).clear();
        driver.findElement(By.xpath("(//input[@id=''])[4]")).sendKeys("123");
        driver.findElement(By.linkText("Register")).click();
        assertEquals("Success", closeAlertAndGetItsText());
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
