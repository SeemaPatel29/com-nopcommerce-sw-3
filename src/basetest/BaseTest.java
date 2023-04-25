package basetest;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        driver= new ChromeDriver();
        // Launch Url
        driver.get(baseUrl);
        //Maximise Windoe
        driver.manage().window().maximize();
        //implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After

    public void closeBrowser(){
        driver.quit();
    }

}


