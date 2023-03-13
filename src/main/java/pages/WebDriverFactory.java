package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver get(){
        WebDriver driver;
        String browserName=System.getenv().get("browser");
        switch (browserName){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            default:throw new RuntimeException("Браузер "+browserName+" не существует");
        }

        driver.manage().timeouts().implicitlyWait (10, TimeUnit.SECONDS);
        driver.navigate().to("https://qa-scooter.praktikum-services.ru/");
        return driver;
    }
}
