import org.junit.Before;
import pages.HomePageScooter;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.WebDriverFactory;
import static org.junit.Assert.assertEquals;

        @RunWith(Parameterized.class)
        public class QuestionTest {
        private final int index;
        private final String expected;
        private WebDriver driver;

        public QuestionTest(int index, String expected) {
            this.index = index;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[] getData() {
            return new Object[][]{
                    {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."}

            };
        }
        @Before
        public void setup(){
            driver = WebDriverFactory.get();
        }
        @Test
        public void checkAnswerIndicator() {

            HomePageScooter objHomePage = new HomePageScooter(driver);
            String actual = objHomePage.fAQ(index);
            assertEquals(expected, actual);
        }
        @After
        public void teardown() {
            driver.quit();
        }
   }





