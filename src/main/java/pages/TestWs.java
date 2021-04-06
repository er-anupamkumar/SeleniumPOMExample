package pages;

import org.openqa.selenium.remote.http.HttpMethod;

@pages.RestAPI(resourcePath = "/testws", httpMethod = HttpMethod.POST)
public class TestWs extends  RestDto{
    @pages.ReqParam(jsonPath = "cardNumber",isOptional = true)
    private String cardNumber;

    public TestWs(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}


