package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private final WebDriver driver;
    // поле с вопросами
    private final By questionsAboutImportant = By.className("Home_FourPart__1uthg");
    // поле "Заказать" наверху страницы
    private final By upOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    // поле "Заказать" внизу страницы
    private final By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // кнопка подтверждения куки
    private final By cookieButton = By.id("rcc-confirm-button");
    // поле сообщения о куки
    private final By cookieContainer = By.className("App_CookieText__1sbqp");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadCookieContainer() {
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(cookieContainer).isDisplayed());
    }
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void scrollQuestionIndicator(int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionsAboutImportant));
    }
    public void waitForLoadQuestionIndicator() {
        new WebDriverWait(driver, 3).until((ExpectedConditions.visibilityOfElementLocated(By.className("Home_FourPart__1uthg"))));
    }

    public String openAnswerText(int index) {
        driver.findElement(getQuestionIndicator(index)).click();
        return driver.findElement(getTextAnswerIndicator(index)).getText();
    }

    private By getQuestionIndicator(int index) {
        return By.id("accordion__heading-" + index);
    }

    private By getTextAnswerIndicator(int index) {
        return By.xpath(".//div[@id='accordion__panel-" + index + "']");
    }

    public String fAQ(int index) {
        waitForLoadCookieContainer();
        clickCookieButton();
        waitForLoadQuestionIndicator();
        scrollQuestionIndicator(index);
        openAnswerText(index);
        return driver.findElement(getTextAnswerIndicator(index)).getText();
    }

    public void clickOrderButton(String locationButton) {
        if (locationButton == "Up") {
            driver.findElement(upOrderButton).click();
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                    driver.findElement(downOrderButton));
                    driver.findElement(downOrderButton).click();
        }
    }
}




