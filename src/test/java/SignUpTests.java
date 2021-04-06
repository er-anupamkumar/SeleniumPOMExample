import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.SignUp;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignUpTests {
    WebDriver driver;
    SignUp signUp;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dbankdemo.com/signup");
    }


    @Test
    public void completeSignUp()  {
        signUp = new SignUp(driver);
        signUp.selectTitle("Mr.");
        signUp.enterFirstName("TestFirstName");
        signUp.enterLastName("lastname");
        signUp.setGenderAsMale();
        signUp.enterDob("07/12/2000");
        signUp.enterSsn(""+ generateRandomDigits(9));
        String username = "test"+generateRandomDigits(9)+"@gmail.com";
        System.out.println("username:"+username);
        signUp.enterEmailAddress(username);
        signUp.enterPassword("Welcome123");
        signUp.enterConfirmPassword("Welcome123");
        signUp.clickNext();
    }

    @AfterEach
    public void teardown (){
        //driver.close();
        //driver.quit();
    }

    private int generateRandomDigits(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }
}
