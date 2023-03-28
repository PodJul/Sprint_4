import pages.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
    public class SetOrderTest extends BaseTest {
    private final String username;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final int numberOfElement;
    private final String date;
    private final String comment;
    private final String locationButton;


    public SetOrderTest(String locationButton, String username, String surname, String address, String phoneNumber, int numberOfElement, String date, String comment) {
        this.locationButton = locationButton;
        this.username = username;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfElement = numberOfElement;
        this.date = date;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {"Up", "Юлия", "Подычан", "Иркутск", "89839999990", 20, "28.02.2023", "Жду с нетерпением!"},
                {"Down", "Петр", "Иванов", "Москва", "89508880012", 65, "02.03.2023", "Предварительно позвонить."}

        };
    }


    @Test
    public void checkIsOrderSuccess() {

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.waitForLoadCookieContainer();
        objHomePage.clickCookieButton();
        objHomePage.clickOrderButton(locationButton);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.setOrder(username, surname, address, phoneNumber, numberOfElement);
        RentPageScooter objRentPage = new RentPageScooter(driver);
        objRentPage.setRentalOptions(comment, date);
        SuccessPageScooter objSuccessPage = new SuccessPageScooter(driver);
        assertTrue(objSuccessPage.isContainerSuccessOrderVisible());
    }
}

