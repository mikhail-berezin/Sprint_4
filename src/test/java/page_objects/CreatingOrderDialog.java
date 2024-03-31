package page_objects;

import org.openqa.selenium.*;

import static org.openqa.selenium.Keys.ARROW_DOWN;

public class CreatingOrderDialog {

    private final WebDriver driver;

    private final By firstNameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By mosmetroStationInput = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");
    private final By deliveryDateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By leasePeriodDropdownDiv = By.xpath("//span[@class='Dropdown-arrow']");
    private final By dayOptionDiv = By.xpath("//div[text()='сутки']");
    private final By colorInput = By.id("black");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath("//button[text()='Заказать']");
    private final By yesButton = By.xpath("//button[text()='Да']");

    public CreatingOrderDialog(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void inputAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void inputMosmetroStation(String mosmetroStation) {
        WebElement mosmetroStationInputElement = driver.findElement(mosmetroStationInput);
        mosmetroStationInputElement.sendKeys(mosmetroStation);
        mosmetroStationInputElement.sendKeys(ARROW_DOWN);
        mosmetroStationInputElement.sendKeys(Keys.ENTER);
    }

    public void inputPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void inputDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateInput).sendKeys(deliveryDate);
    }

    public void selectLeasePeriod() {
        driver.findElement(leasePeriodDropdownDiv).click();
        driver.findElement(dayOptionDiv).click();
    }

    public void selectBlackColor() {
        driver.findElement(colorInput).click();
    }

    public void inputComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
}
