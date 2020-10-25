import cucumber.api.java.en.Then;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class NewSeleneseIT
{
    /*
public static void main(String[] args) throws InterruptedException {
    
	ProfilesIni profile = new ProfilesIni();
        FirefoxOptions options = new FirefoxOptions();
        File pathToBinary = new File("D:\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        
        System.setProperty("webdriver.gecko.driver", "D:\\Glassfish\\Selenium\\GeckoDriver\\geckodriver.exe");
        //Now you can Initialize marionette driver to launch firefox
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        

        
        FirefoxProfile myprofile = profile.getProfile("Selenium-JDK-11");
        options.setLegacy(true);
        options.setCapability("marionette", true);
        options.setProfile(myprofile);
        options.setBinary(ffBinary);
        
        System.out.println("Given statement executed successfully");
        
        WebDriver driver = new FirefoxDriver(options);
        
        //Connect to localhost
        driver.get("http://localhost:8080/ForecastMaven");
        Assert.assertEquals("Home",driver.getTitle());
        System.out.println("SUCCESS TO CONNECT");
        
        //Current Weather Feature
        driver.findElement(By.xpath("//a[@href='javascript:document.CurrentWeather.submit()']")).click();
        Thread.sleep(7500);
        Assert.assertEquals("Current Weather Page",driver.getTitle());
        System.out.println("CURRENT WEATHER SUCCESS");
        
        //Weather Forecast Feature
        driver.findElement(By.xpath("//a[@href='javascript:document.WeatherForecast.submit()']")).click();
        Thread.sleep(7500);
        Assert.assertEquals("Weather Forecast Page",driver.getTitle());
        System.out.println("WEATHER FORECAST SUCCESS");
        
        //Go to Home
        driver.findElement(By.xpath("//a[@href='index.jsp']")).click();
        Thread.sleep(5000);
        Assert.assertEquals("index",driver.getTitle());
        System.out.println("INDEX.JSP SUCCESS");
        
        //Go to Login
        driver.findElement(By.xpath("//form[@action='IndexLoginServlet']")).submit();
        Thread.sleep(5000);
        Assert.assertEquals("Login",driver.getTitle());
        System.out.println("LOGIN JSP SUCCESS");
//LOGIN FEATURE START
        //Get Email and Password
        WebElement email = driver.findElement(By.name("Email"));
        email.sendKeys("syong195@gmail.com");
        Thread.sleep(2000);
        WebElement userpassword = driver.findElement(By.name("Password"));
        userpassword.sendKeys("syong0827!");
        Thread.sleep(2000);
        //Click the login button
        driver.findElement(By.xpath("//form[@action='LoginMongoServlet']")).submit();
	System.out.println("LOGIN AS USER SUCCESS");
        Thread.sleep(4000);
        
        //Go to Weather History Feature
        driver.findElement(By.xpath("//a[@href='javascript:document.WeatherHistory.submit()']")).click();
        Thread.sleep(7500);
        Assert.assertEquals("Weather History",driver.getTitle());
        System.out.println("WEATHER HISTORY SUCCESS");
        
        //Go to Weather Analysis Feature
        driver.findElement(By.xpath("//a[@href='javascript:document.WeatherAnalysis.submit()']")).click();
        Thread.sleep(7500);
        Assert.assertEquals("Weather Analysis",driver.getTitle());
        System.out.println("WEATHER ANALYSIS SUCCESS");
        
        //Logout and GO to Home
        driver.findElement(By.xpath("//a[@href='main.jsp']")).click();
        Thread.sleep(5500);
        Assert.assertEquals("Edit Page",driver.getTitle());
        System.out.println("MAIN JSP SUCCESS");
        
        driver.findElement(By.xpath("//form[@action='LogoutServlet']")).submit();
        Thread.sleep(3500);
        Assert.assertEquals("index",driver.getTitle());
        System.out.println("LOGOUT SUCCESS");
//LOGIN FEATURE END
//ADMIN START        
        //Go to Administrator Login page
        driver.findElement(By.xpath("//form[@action='IndexAdminLoginServlet']")).submit();
        Thread.sleep(3500);
        Assert.assertEquals("Login",driver.getTitle());
        System.out.println("LOGIN JSP SUCCESS");

        WebElement adminemail = driver.findElement(By.name("Email"));
        adminemail.sendKeys("demonstrate@gmail.com");
        Thread.sleep(2000);
        WebElement adminpassword = driver.findElement(By.name("Password"));
        adminpassword.sendKeys("demonstrate!");
        Thread.sleep(2000);
        //Click the login button
	driver.findElement(By.xpath("//form[@action='AdminLogin_Servlet']")).submit();
        Thread.sleep(6000);
        System.out.println("LOGIN AS ADMINISTRATOR SUCCESS");
        
        driver.findElement(By.xpath("//a[@href='308_account_management_admin.jsp']")).click();
        Thread.sleep(5500);
        Assert.assertEquals("Edit Page",driver.getTitle());
        System.out.println("ACCOUNT MANAGEMENT SUCCESS");
        
        driver.findElement(By.xpath("//a[@href='adminMain.jsp']")).click();
        Thread.sleep(5500);
        System.out.println("MAIN JSP SUCCESS");
        
        //Logout and GO to Home
        driver.findElement(By.xpath("//form[@action='AdminLogoutServlet']")).click();
        Thread.sleep(7500);
        Assert.assertEquals("index",driver.getTitle());
        System.out.println("ADMIN LOGUT SUCCESS");
//ADMIN END
//CHECK MAP START
        driver.findElement(By.xpath("//a[@href='1111_WindSpeedMap.jsp']")).click();
        Thread.sleep(5500);
        Assert.assertEquals("Wind Speed Map",driver.getTitle());
        System.out.println("WINDSPEED MAP SUCCESS");
        
        driver.findElement(By.xpath("//a[@href='1112_PrecipitationMap.jsp']")).click();
        Thread.sleep(5500);
        Assert.assertEquals("Precipitation Map",driver.getTitle());
        System.out.println("PRECIPITATION MAP SUCCESS");
//CHECK MAP END
        
}    */
}