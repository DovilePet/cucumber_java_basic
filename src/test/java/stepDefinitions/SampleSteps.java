package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^I am on the locators page$")
    public void IAmOnTheLocatorsPage() throws Throwable { driver.get("https://kristinek.github.io/site/examples/locators");}

    @Then("^I should see both locators page headers$")
    public void IShouldSeeBothLocatorsPageHeaders() throws Throwable {
        assertTrue(driver.findElement(By.id("heading_1")).isDisplayed());
        assertTrue(driver.findElement(By.id("heading_2")).isDisplayed());
    }

    @And("^Buttons in Locators page are clickable$")
    public void ButtonsInLocatorsPageAreClickable() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }

    @Then("^I see error: \"([^\"]*)\"$")
    public void iSeeError(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("error")).getText());
    }

    @And("^I am not navigated to age message page$")
    public void IAmNotNavigatedToAgeMessagePage() throws Throwable {
        assertEquals("https://kristinek.github.io/site/examples/age", driver.getCurrentUrl());
    }

    @Given("^I am on feedback page$")
    public void IAmOnFeedbackPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I enter feedback name: \"([^\"]*)\"$")
    public void iEnterFeedbackName(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @And("^I enter feedback age: \"([^\"]*)\"$")
    public void iEnterFeedbackAge(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }

    @And("^I click send$")
    public void iClickSend() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("^I can see name \"([^\"]*)\" in feedback$")
    public void ICanSeeNameInFeedback(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
    }

    @And("^I can see age \"([^\"]*)\" in feedback$")
    public void ICanSeeAgeInFeedback(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("age")).getText());
    }

    @Given("^I am on Enter Number page$")
    public void IAmOnEnterNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter string \"([^\"]*)\"$")
    public void iEnterString(String string) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(string);
    }

    @And("^I click submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("^I get error message: \"([^\"]*)\"$")
    public void IGetErrorMessage(String error) throws Throwable {
        assertEquals(error, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter number 64$")
    public void IEnterNumber64() throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys("64");
    }

    @Then("^result is displayed in alert window$")
    public void resultIsDisplayedInAlertWindow() throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
        //alert.accept();
    }

    @When("^I enter input in feedback page$")
    public void IEnterInputInFeedbackPage(Map<String, String> feedbackInput) throws Throwable {
        if (feedbackInput.containsKey("name")) {
            iEnterFeedbackName(feedbackInput.get("name"));
        }
        iEnterFeedbackAge(feedbackInput.get("age"));
        driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
    }

    @And("^I can see genre \"([^\"]*)\" in feedback$")
    public void ICanSeeGenreInFeedback(String genre) throws Throwable {
        assertEquals(genre, driver.findElement(By.id("gender")).getText());
    }

    @When("^I select feedback languages$")
    public void ISelectFeedbackLanguages(List <String> languages) throws Throwable {
        for (String language : languages) {
            driver.findElement(By.xpath("//input[@value='" + language + "']")).click();
        }
    }

    @Then("^I can see languages \"([^\"]*)\" in feedback$")
    public void ICanSeeLanguagesInFeedback(String languages) throws Throwable {
        assertEquals(languages, driver.findElement(By.id("language")).getText());
    }
}
