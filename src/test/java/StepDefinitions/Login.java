package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver webDriver;
    private static final String chromeDriverPath = "C:\\ChromeDriver-80\\chromedriver_80.exe";
    private static final String GCPHome = "https://cloud.google.com/";

    @Given("I launch chrome")
    public void iLaunchChrome(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        webDriver = new ChromeDriver();
    }

    @And("I navigate to the Google Cloud Platform Home Page")
    public void iNavigateToGCPHomePage(){
        webDriver.get(GCPHome);
    }

    @Then("I close the driver")
    public void iCloseTheDriver(){
        webDriver.close();
        webDriver.quit();
    }
}
