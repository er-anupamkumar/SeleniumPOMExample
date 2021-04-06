package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp {

    WebDriver driver;

    @FindBy (id = "title")
    WebElement title;

    @FindBy (id = "firstName")
    WebElement firstName;

    @FindBy (id = "lastName")
    WebElement lastName;

    @FindBy (xpath = "//*[@id=\"gender\" and @value=\"M\"]")
    WebElement genderMaleCheckBox;

    @FindBy (xpath = "//*[@id=\"gender\" and @value=\"F\"]")
    WebElement genderFemaleCheckBox;

    @FindBy (id = "dob")
    WebElement dob;

    @FindBy (id = "ssn")
    WebElement ssn;

    @FindBy (id = "emailAddress")
    WebElement emailAddress;

    @FindBy (id = "password")
    WebElement password;

    @FindBy (id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy (xpath = "/html/body/div[1]/div/div/div[2]/form/button")
    WebElement next;


    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void selectTitle(String titleValue) {
        Select titleDropDown = new Select(title);
        titleDropDown.selectByVisibleText(titleValue);
    }

    public void enterFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
    }

    public void setGenderAsMale() {
        genderMaleCheckBox.click();
    }

    public void setGenderAsFemale() {
        genderFemaleCheckBox.click();
    }

    public void enterDob(String dobValue) {
        this.dob.sendKeys(dobValue);
    }

    public void enterSsn(String ssnValue) {
        this.ssn.sendKeys(ssnValue);
    }

    public void enterEmailAddress(String emailAddressValue) {
        this.emailAddress.sendKeys(emailAddressValue);
    }

    public void enterPassword(String passwordValue) {
        this.password.sendKeys(passwordValue);
    }

    public void enterConfirmPassword(String confirmPasswordValue) {
        this.confirmPassword.sendKeys(confirmPasswordValue);
    }

    public void clickNext(){
        next.click();
    }
}
