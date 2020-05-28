import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WebDriverTest {
    private WebDriver driver;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver = new ChromeDriver();
        driver.get("https://skryabin.com/market/quote.html");
        
    }

    @Test
    public void verifyTitle(){
        driver.get("https://skryabin.com/market/quote.html");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo("Get a Quote");
    }

    @Test
    public void fieldsTest(){
        System.out.println("Fields Test");
        driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("jdoe");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("jdoe@example.com");
        String actualEmail = driver.findElement(By.xpath("//input[@name = 'email']")).getAttribute("value");
        assertThat(actualEmail).isEqualTo("jdoe@example.com");
    }

    @After
    public void after(){
        driver.quit();
    }

}
