package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPageScooter {
    private final WebDriver driver;
    public SuccessPageScooter (WebDriver driver) {
        this.driver = driver;
    }
    private final By containerSuccessOrder= By.className("Order_ModalHeader__3FDaJ");

    public boolean isContainerSuccessOrderVisible(){
        return driver.findElement(containerSuccessOrder).isDisplayed();
    }
}
