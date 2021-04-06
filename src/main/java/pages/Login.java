package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.jupiter.api.*;

public class Login {

    WebDriver driver;

    @FindBy ( id = "username")
    WebElement username;

    @FindBy ( id = "password")
    WebElement password;

    @FindBy ( id = "remember-me")
    WebElement rememberMe;

    @FindBy ( id = "submit")
    WebElement submit;

    @FindBy ( xpath = "/html/body/div[1]/div/div/div[2]/form/div[4]/p/a")
    WebElement signUp;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void withRememberMe(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        rememberMe.click();
        submit.click();
    }

    public void withoutRememberMe(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        submit.click();
    }

    public void gotoSignupPage (){
        signUp.click();
    }

    public void verify_invalidCredentialsError (){
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div")).getText().trim().contains("Invalid credentials or access not granted."));
    }

}
