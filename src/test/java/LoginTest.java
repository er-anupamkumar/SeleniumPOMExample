import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.SignUp;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    Login login;
    SignUp signUp;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dbankdemo.com/");
    }

    @Test
    public void login_with_invalidCredentials()  {
        login = new Login(driver);
        login.withRememberMe("testname","pwd");
        login.verify_invalidCredentialsError();
    }

    @Test()
    public void navigateTo_signUpPage()  {
        login = new Login(driver);
        login.gotoSignupPage();
    }

    @AfterEach
    public void teardown (){
        driver.close();
        driver.quit();
    }
}

