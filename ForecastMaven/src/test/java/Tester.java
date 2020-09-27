/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yujiwon
 */
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester 
{
    WebDriver driver;
    
    @Given("^I have opened the browser$")
    public void givenStatment() throws InstantiationException, IllegalAccessException
    {
        Class<? extends WebDriver> driverClass = FirefoxDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver= driverClass.newInstance();
        driver.get("https://asd-group3.herokuapp.com/");
        
        System.out.println("Given statement executed successfully");
    }
    
    @When("^I visit website$")
    public void whenStatement()
    {
        driver.get("https://asd-group3.herokuapp.com/");
    }
    
    @Then("^website returns content$")
    public void thenStatement()
    {
        Assert.assertEquals("Home",driver.getTitle());
    }
    
    
}