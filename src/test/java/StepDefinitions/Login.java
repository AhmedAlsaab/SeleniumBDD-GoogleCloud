package StepDefinitions;

import GCP.BigQueryClient;
import GCP.CompareJSON;
import GCP.Service.ResponseService;
import JSONStore.LoadJSONFromFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {


    ResponseService bigQueryData = new BigQueryClient();
    ResponseService localData = new LoadJSONFromFile();


    WebDriver webDriver;
    private static final String chromeDriverPath = "C:\\ChromeDriver-80\\chromedriver_80.exe";
    private static final String GCPHome = "https://cloud.google.com/";

    @Given("I launch chrome")
    public void iLaunchChrome(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        webDriver = new ChromeDriver();
    }

    @Given("I connect to BigQuery and check for a response")
    public void checkBQResponse() throws Exception{
        CompareJSON compareJSON = new CompareJSON();
        compareJSON.setResponseService(bigQueryData);
        compareJSON.checkResult();
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
