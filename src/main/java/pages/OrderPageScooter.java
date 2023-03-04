package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageScooter {
    private final WebDriver driver;
    // поле ввода имени
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода фамилии
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле ввода номера телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка "Далее"
    private final By nextButton = By.xpath(".//button[contains(text(),'Далее')]");
    // поле ввода станции метро
    private final By subStationField= By.xpath(".//div[@class='select-search__value']");
    // поле со списком станций
    private final By SubStationList= By.className("select-search__select");

    public OrderPageScooter (WebDriver driver) {
        this.driver = driver;
    }
    public void setUsername(String username) {
        driver.findElement(nameField).sendKeys(username);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void clickSubStationField() {
        driver.findElement (subStationField).click();
            }
    public void waitForLoadSubStationList() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(SubStationList).isDisplayed());
    }
    public void scrollSubStation(int numberOfElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement (getSubStationIndicator(numberOfElement)));
    }

    public void clickSubStation(int numberOfElement) {
        driver.findElement (getSubStationIndicator(numberOfElement)).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    private By getSubStationIndicator(int numberOfElement) {
        return By.xpath(".//div[@class='select-search__select']/ul/li["+numberOfElement+"]");
    }

       public void setOrder(String username, String surname, String address,String phoneNumber,int numberOfElement) {

        setUsername(username);
        setSurname(surname);
        setAddress(address);
        clickSubStationField();
        waitForLoadSubStationList();
        scrollSubStation(numberOfElement);
        clickSubStation(numberOfElement);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }
}


