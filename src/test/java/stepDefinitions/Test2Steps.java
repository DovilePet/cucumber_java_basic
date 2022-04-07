package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.xalan.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Test2Steps {
    private WebDriver driver;


    public Test2Steps() { this.driver = Hooks.driver; }

    @Given("^I am on people list page$")
    public void IAmOnPeopleListPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @Given("^I have original list$")
    public List<WebElement> IHaveOriginalList(){
        List <WebElement> originalList = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        return originalList;
    }

    @When("^I click Add person button$")
    public void IClickAddPersonButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn' and contains(text(),'Add')]")).click();
    }

    @When("^I click Reset List button$")
    public void IClickResetListButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn' and contains(text(),'Reset')]")).click();
    }

    @When("^I click Clear all fields button$")
    public void IClickClearAllFieldsButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn' and contains(text(),'Clear')]")).click();
    }

    @When("^I click Add button$")
    public void IClickAddButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='modal_button' and contains(text(), 'Add')]")).click();
    }

    @When("^I click Edit button$")
    public void IClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='modal_button' and contains(text(), 'Edit')]")).click();
    }

    @When("^I click on the first pencil icon$")
    public void IClickOnTheFirstPencilIcon() throws Throwable {
        driver.findElements(By.className("fa-pencil")).get(0).click();
    }

    @When("^I click on the second x sign$")
    public void IClickOnTheSecondXSign() throws Throwable {
        driver.findElements(By.xpath("//*[contains(@class,'closebtn') and contains(@onclick, 'delete')]")).get(1).click();
    }

    @And("^I enter input of a new person$")
    public void IEnterInputOfaNewPerson(Map<String, String> nameTitle) throws Throwable {
        if (nameTitle.containsKey("name")) {
            iEnterPersonsName(nameTitle.get("name"));
        }
        iEnterJobTitle(nameTitle.get("job"));
    }

    @And("^I enter persons name \"([^\"]*)\"$")
    public void iEnterPersonsName(String name) throws Throwable{
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job title \"([^\"]*)\"$")
    public void iEnterJobTitle(String job) throws Throwable{
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Then("^I can see name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void ICanSeeNewPersonAdded(String name, String title) throws Throwable {
        List <WebElement> persons = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        List <String> namesTitles = new ArrayList<>();
        for (WebElement person : persons) {
            String name1 = person.findElement(By.className("name")).getText();
            String title1 = person.findElement(By.className("job")).getText();
            //System.out.println(name1 + title1);
            namesTitles.add(name1 + title1);
        }
        //System.out.println(namesTitles);
        assertTrue(namesTitles.contains(name + title));
    }

    @Then("^I cannot see the second person anymore$")
    public void ICannotSeeTheSecondPersonAnymore() throws Throwable {
        List <WebElement> persons = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        WebElement person2 = persons.get(1);
        IClickOnTheSecondXSign();
        List <WebElement> newListPersons = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        assertFalse(newListPersons.contains(person2));
    }

    @Then("^I cannot see name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void ICannotSeeNewPersonAdded(String name, String title) throws Throwable {
        List <WebElement> persons = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        List <String> namesTitles = new ArrayList<>();
        for (WebElement person : persons) {
            String name1 = person.findElement(By.className("name")).getText();
            String title1 = person.findElement(By.className("job")).getText();
            //System.out.println(name1 + title1);
            namesTitles.add(name1 + title1);
        }
        //System.out.println(namesTitles);
        assertFalse(namesTitles.contains(name + title));
    }

    @Then("^I can see the second person$")
    public void ICanSeeTheSecondPerson() throws Throwable {
        List <WebElement> persons = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        WebElement person2 = persons.get(1);
        List <WebElement> newListPersons = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        assertTrue(newListPersons.contains(person2));
    }

    @Then("^name and job fields are empty$")
    public void nameAndJobFieldsAreEmpty() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("", driver.findElement(By.id("job")).getAttribute("value"));
    }

}
