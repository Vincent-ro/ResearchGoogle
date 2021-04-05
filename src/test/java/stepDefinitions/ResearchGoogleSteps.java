package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResearchGoogleSteps {

    WebDriver driver;

    @Given("the user launch chrome browser")
    public void theUserLaunchChromeBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vince\\Driver\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @And("the user is on the research Google page")
    public void the_user_is_on_the_research_google_page() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"zV9nZe\"]/div")).click();
    }

    @And("the user enter a key word in the research field")
    public void the_user_enter_a_key_word_in_the_research_field() {
        WebElement keyword=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        keyword.sendKeys("gherkin");
    }
    @When("the user validate")
    public void the_user_validate() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.RETURN);
    }
    @Then("the first site contains the key word")
    public void theFirstSiteContainsTheKeyWord() {
        String actualString = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div[1]/div/div[1]/a/h3")).getText();
        String lowercaseActualString = actualString.toLowerCase();
        assertTrue(lowercaseActualString.contains("gherkin"));
    }
    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
