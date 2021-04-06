import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLession1 {

    WebDriver driver;

    @BeforeEach
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DisplayName("Verify facebook is launched")
    @Test
    public void testLaunchFacebook(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("u_0_h")).click();
        Assertions.assertEquals("Facebook – log in or sign up",driver.getTitle());
    }

    @DisplayName("Verify gmail is launched")
    @Test
    public void launchGmail(){
        driver.get("https://mail.google.com/");
        Assertions.assertEquals("Gmail",driver.getTitle());
    }

    @AfterEach
    public void tearDown (){
        driver.quit();
    }
}
