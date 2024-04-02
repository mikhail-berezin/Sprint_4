import factory.DriverFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.CreatingOrderDialog;
import pageobjects.HomePage;

import static constants.SamokatTestConstants.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class SamokatCreateOrderTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory("firefox");

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String mosmetroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String comment;

    public SamokatCreateOrderTest(String firstName, String lastName, String address, String mosmetroStation, String phoneNumber, String deliveryDate, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mosmetroStation = mosmetroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { "Иван", "Петров", "Москва, проезд Соломенной Сторожки, дом 3", "Динамо", "+79999999999", "01.06.2024", "Благодарю Вас!"},
                { "Пётр", "Иванов", "Москва, Старокалужское шоссе, дом 1", "Калужская", "89876543210", "31.05.2024", "ЛУЧШИХ САМОКАТОВ НЕ БЫЛО И НЕТ ГОТОВ КАТИТЬ ДО СТАРЫХ ЛЕТ"}
        };
    }

    @Before
    public void init() {
        driverFactory.getDriver().get(MAIN_PAGE_URL);
    }

    @Test
    public void checkOrder() {

        HomePage objHomePage = new HomePage(driverFactory.getDriver());
        objHomePage.clickAllowCookies();
        objHomePage.clickOrderButton();
        CreatingOrderDialog creatingOrderDialog = new CreatingOrderDialog(driverFactory.getDriver());
        creatingOrderDialog.inputFirstName(firstName);
        creatingOrderDialog.inputLastName(lastName);
        creatingOrderDialog.inputAddress(address);
        creatingOrderDialog.inputMosmetroStation(mosmetroStation);
        creatingOrderDialog.inputPhone(phoneNumber);
        creatingOrderDialog.clickNextButton();
        creatingOrderDialog.inputDeliveryDate(deliveryDate);
        creatingOrderDialog.selectLeasePeriod();
        creatingOrderDialog.selectBlackColor();
        creatingOrderDialog.inputComment(comment);
        creatingOrderDialog.clickOrderButton();
        creatingOrderDialog.clickYesButton();
        creatingOrderDialog.checkOrderIsCreated();
    }
}
