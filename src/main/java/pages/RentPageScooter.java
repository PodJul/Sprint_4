package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RentPageScooter {
    private final WebDriver driver;
    // Заголовок
    private final By rentHeader = By.className("Order_Header__BZXOb");
    // поле ввода даты
    private final By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // поле ввода периода аренды
    private final By rentalPeriodField = By.className("Dropdown-control");
    // поле списка количества суток аренды
    private final By rentalList=By.className("Dropdown-menu");
    // чек-бокс цвета самоката
    private final By colorCheckBox = By.id("black");
    // поле ввода комментария
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка "Заказать"
    private final By okButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");;
    // кнопка "Да"
    private final By yesButton = By.xpath(".//button[contains(text(),'Да')]");
    // выбор периода "сутки"
    private final By rentalPeriod=By.xpath(".//div[@class='Dropdown-menu']/div[1]");


    public RentPageScooter (WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadRentHeader() {
        new WebDriverWait (driver, 3).until(driver -> driver.findElement(rentHeader).isDisplayed());
    }
    public void clickDataField() {
        driver.findElement(dataField).click();
    }

    public void setRentalDay(String date){
        driver.findElement(dataField).sendKeys(date, Keys.ENTER);
    }
    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }
    public void waitForLoadRentalList() {
        new WebDriverWait(driver, 5).until(driver -> driver.findElement(rentalList).isDisplayed());
    }
    public void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();

    }
    public void chooseColor() {
        driver.findElement(colorCheckBox).click();
    }

    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOKButton() {
        driver.findElement(okButton).click();

        }
    public void waitForConfirmContainer() {
        new WebDriverWait(driver, 3).until((ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3"))));
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public void setRentalOptions(String comment,String date) {
        waitForLoadRentHeader();
        clickDataField ();
        setRentalDay(date);
        clickRentalPeriodField();
        waitForLoadRentalList();
        clickRentalPeriod();
        chooseColor();
        setCommentField(comment);
        clickOKButton();
        waitForConfirmContainer();
        clickYesButton();

    }
}





