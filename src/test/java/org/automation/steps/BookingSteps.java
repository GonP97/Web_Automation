package org.automation.steps;

import org.apache.commons.lang3.StringUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.automation.Browser_Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Map;


public class BookingSteps {
    private WebDriver driver;
    private Browser_Setup browserSetup;
    private WebDriverWait wait;

    @Before
        public void setup() {
            browserSetup = new Browser_Setup();
            browserSetup.setUp();
            driver = browserSetup.getDriver();

    }
    public void sleep(int seconds){
        try {
            seconds = seconds * 1000;
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String get_month(String date){
        String month;
        String month_s = null;
        month = StringUtils.substringBetween(date, "-", "-");
        if (month.equals("10") )
                month_s = "Oct";
                return month_s;
    }
    @After
    public void tearDown() {
        browserSetup.tearDown();
    }
    @Given("I am on the Ryanair website")
    public void iAmOnRyanairWebsite() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        // Initialize ChromeDriver and open the website

        driver.get("https://www.ryanair.com/gb/en");



        //Accept cookies
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='cookie-popup-with-overlay__button']"));
        searchButton.click();

        sleep(5);
    }

    @When("I search for a trip between {string} and {string}")
    public void searchTrip(String originCity, String destinationCity) {
        Actions act = new Actions(driver);
        // Locate and interact with the search input fields and search button
        WebElement fromInput = driver.findElement(By.id("input-button__departure"));
        sleep(2);
        fromInput.clear();
        sleep(2);
        fromInput.clear();
        fromInput.sendKeys(originCity);
        sleep(2);
        //Replace LIS and BVA at the end
        WebElement origin = driver.findElement(By.xpath("//span[@data-id='LIS']"));
        origin.click();
        sleep(2);
        WebElement toInput = driver.findElement(By.id("input-button__destination"));

        toInput.sendKeys(destinationCity);
        sleep(2);
        WebElement destination = driver.findElement(By.xpath("//span[@data-id='BVA']"));
        destination.click();
        sleep(2);


    }

    @When("I select the departure date as {string} and return date as {string}")
    public void selectDates(String departureDate, String returnDate) {
        departureDate = "'" + departureDate + "'";
        WebElement departure = driver.findElement(By.xpath("//div[@data-id="+departureDate+"]"));
        departure.click();
        sleep(1);
        // Implement the code to select the departure and return dates
        String month= get_month(returnDate);
        month = "'" + month + "'";
        WebElement return_month = driver.findElement(By.xpath("//div[@data-id="+month+"]"));
        return_month.click();
        sleep(2);
        returnDate = "'" + returnDate + "'";
        WebElement arrival = driver.findElement(By.xpath("//div[@data-id="+returnDate+"]"));
        arrival.click();
        sleep(2);

    }

    @When("I add {int} adults and {int} child")
    public void addPassengers(int adultCount, int childCount) {
        for (int i= 0; i<adultCount-1; i++){
            WebElement inc = driver.findElement(By.xpath("//div[contains(@data-id,'counter.counter__increment')][1]"));
            inc.click();
        }
    sleep(20);
    }

    @When("I change the departure date to {string} and return date to {string}")
    public void changeDates(String newDepartureDate, String newReturnDate) {

    }

    @And("I fill in the passenger details with the following data:")
    public void fillPassengerDetails(DataTable dataTable) {

    }

}
