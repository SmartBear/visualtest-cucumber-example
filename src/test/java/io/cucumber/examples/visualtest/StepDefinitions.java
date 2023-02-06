package io.cucumber.examples.visualtest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private ChromeDriver browser;

    @Before
    public void openBrowser() {
        this.browser = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        this.browser.close();
    }

    @Given("a visitor has opened the homepage")
    public void aVisitorHasOpenedTheHomepage() {
        this.browser.get("https://bearstore-testsite.smartbear.com");
    }

    @When("a visitor searches for {string}")
    public void aVisitorSearchesFor(String term) {
        WebElement search = this.browser.findElement(By.name("q"));
        search.sendKeys(term);
        search.submit();
    }

    @Then("there should be {int} result(s)")
    public void thereShouldBeResult(int expectedNumberOfResults) {
        int actualNumberOfResults = this.browser.findElements(By.cssSelector(".search-results article")).size();
        assertEquals(
                expectedNumberOfResults,
                actualNumberOfResults);
    }
}
