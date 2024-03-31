import factory.DriverFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_objects.HomePage;

@RunWith(Parameterized.class)
public class SamokatAccordionTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory("firefox");

    private final String accordionItemHeader;
    private final String accordionItemContent;

    public SamokatAccordionTest(String accordionItemHeader, String accordionItemContent) {
        this.accordionItemHeader = accordionItemHeader;
        this.accordionItemContent = accordionItemContent;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][] {
                { "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}
        };
    }

    @Before
    public void init() {
        driverFactory.getDriver().get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAccordion() {

        HomePage objHomePage = new HomePage(driverFactory.getDriver());
        objHomePage.scrollToAccordionElement(accordionItemHeader);
        objHomePage.clickAccordionComponent(accordionItemHeader);
        objHomePage.checkAccordionComponentContentNotHidden(accordionItemContent);
    }
}
