package page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    private final By allowCookiesButton = By.id("rcc-confirm-button");
    private final By orderButton = By.xpath("//button[text()='Заказать']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAllowCookies() {
        driver.findElement(allowCookiesButton).click();
    }

    public void scrollToAccordionElement(String title) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                driver.findElement(getAccordionItemBy(title))
        );
    }

    public void clickAccordionComponent(String title) {
        driver.findElement(getAccordionItemBy(title)).click();
    }

    public void checkAccordionComponentContentNotHidden(String itemText) {
        Assert.assertTrue(driver.findElement(getAccordionInnerContentBy(itemText)).isDisplayed());
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    private By getAccordionItemBy(String itemText) {
        return By.xpath("//div[@data-accordion-component='AccordionItemButton' and text()='" + itemText + "']");
    }

    private By getAccordionInnerContentBy(String itemText) {
        return By.xpath("//p[text()='" + itemText + "']/parent::div");
    }
}
