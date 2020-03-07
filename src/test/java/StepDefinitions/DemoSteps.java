package StepDefinitions;

import GCP.BigQueryClient;
import GCP.DataRequestClient;
import GCP.Service.ResponseService;
import JSONStore.LoadJSONFromFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSteps {


    ResponseService bigQueryData = new BigQueryClient();
    ResponseService localData = new LoadJSONFromFile();
    DataRequestClient dataRequestClient = new DataRequestClient();


    WebDriver webDriver;
    private static final String chromeDriverPath = "C:\\ChromeDriver-80\\chromedriver_80.exe";
    private static final String GCPHome = "https://cloud.google.com/";

    @Given("I launch chrome")
    public void iLaunchChrome(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        webDriver = new ChromeDriver();
    }

    @Given("I set the GCP credentials")
    public void setGCPCredentials(){
        // TODO: 07/03/2020 Set GCP Auth in a seperate method instead of setting it before querying a BQ dataset
        System.out.println("GCP Credentials Set");
    }

    @And("I query the Waste and Diversion Dataset from {string}")
    public void queryData(String getData) throws Exception{
        switch (getData){
            case "bigquery":
                System.out.println("Loading Data from Big Query");
                dataRequestClient.setResponseService(bigQueryData);
                break;
            case "local":
                System.out.println("Loading Data from a local file");
                dataRequestClient.setResponseService(localData);
                break;
        }
        dataRequestClient.checkResult();
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
