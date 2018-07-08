package selenium_tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaignTqs {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/tqs/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:4200/tqs";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCreatecampaignTqs() throws Exception {
        driver.get("http://localhost:4200/createcampaign");
        driver.findElement(By.id("campaignName")).click();
        driver.findElement(By.id("campaignName")).clear();
        driver.findElement(By.id("campaignName")).sendKeys("Test_tqs");
        driver.findElement(By.id("goal")).clear();
        driver.findElement(By.id("goal")).sendKeys("1000");
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("Teste interface tqs");
        driver.findElement(By.xpath("//div[4]/input")).click();
        driver.findElement(By.xpath("//div[4]/input")).clear();
        driver.findElement(By.xpath("//div[4]/input")).sendKeys("http://studentsandteachersdeti.web.ua.pt/2015/wp-content/uploads/2015/04/1-CIMG3182_2.jpg");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
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
