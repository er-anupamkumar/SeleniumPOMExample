import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class APITests {

    TestWs testWs;
    CallWS callWS;
    TestWs2 testWs2;


    @BeforeEach
    public void setup() {
        testWs = new TestWs("13123123123123");
        callWS = new CallWS();
        testWs2 = new TestWs2();

    }

    @Test
    public void apicall()  {
        try {
         String jsonBody = callWS.prepareRequestBody(testWs);
            System.out.println("jsonBody:"+jsonBody);
            testWs.setRequest(jsonBody);
            callWS.sendRequest(testWs);
            System.out.println("response:"+testWs.getResponse());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void apicall2()  {
        try {
            callWS.prepareRequestBody(testWs2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void apicall3()  {
        String str = "kitten";
        System.out.println(missingChar(str,1));

    }
    public String missingChar(String str, int n) {
        return str.substring(0,n)+str.substring(n+1,str.length());
    }
}

