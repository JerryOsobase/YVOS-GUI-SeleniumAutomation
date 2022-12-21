package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.base;

import java.util.List;

public class AuditLog extends base {

    private By activitiesTableHeader = By.xpath("//tr/th");

    private By pageHeader = By.cssSelector("div[class*='text-xl']");

    private By filterOptions = By.cssSelector("div[class*='rounded overflow-hidden'] div[class*='bg-tinted']");


    private By filterButton = By.xpath("//button/span[contains(text(), 'Filter')]");
    private By eventField = By.xpath("//div[contains(text(), 'Select Event')]");

    private By resourceField = By.xpath("//div[contains(text(), 'Select Resource')]");
    private By dropDownList = By.cssSelector("div[class*='menu'] div[class*='cursor-pointer']");
    private By dateOption = By.cssSelector("button[class*='ring rounded shadow-none']");
    private By clearButton = By.xpath("//button/span[contains(text(), 'Clear')]");
    private By popUpFilterButton = By.cssSelector("#auditlog-table > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-5\\/6.sm\\:w-4\\/6.md\\:w-1\\/2.xl\\:w-2\\/6.rounded.overflow-hidden > " +
            "div.flex-1.flex.flex-col.overflow-hidden > div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > div > button.bg-highlight.text-white.ring-highlight.font-medium.py-3.px-8.text-base.focus\\:ring-4.rounded.shadow-none.focus\\:outline-none.flex-shrink-0.text-center.ring-opacity-50.relative");
    private By auditDetailsHeader = By.cssSelector("div[class*='text-title font-semibold']");

    private By popUpCloseButton = By.cssSelector("div[class*='rounded overflow-hidden'] div.close svg");

    private By activity = By.xpath("//tbody/tr/td[2]");

    private By emptyLogResult = By.cssSelector("div[class*='flex items-center'] div[class*='text-black-300']");




    public List<WebElement> getActivitiesTableHeader() {
        return driver.findElements(activitiesTableHeader);
    }

    public List<WebElement> getActivity() {
        return driver.findElements(activity);
    }

    public WebElement getFilterButton() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        return driver.findElement(filterButton);
    }

    public WebElement getEmptyLogResult() {
        return driver.findElement(emptyLogResult);
    }

    public WebElement getPopUpCloseButton() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpCloseButton));
        wait.until(ExpectedConditions.elementToBeClickable(popUpCloseButton));
        return driver.findElement(popUpCloseButton);
    }

    public WebElement getResourceField() {
        return driver.findElement(resourceField);
    }

    public WebElement getPageHeader() {
        return driver.findElement(pageHeader);
    }

    public WebElement getEventField() {
        return driver.findElement(eventField);
    }

    public List<WebElement> getFilterOptions() {
         wait = new WebDriverWait(driver, durationInSeconds);
         wait.until(ExpectedConditions.visibilityOfElementLocated(filterOptions));
        return driver.findElements(filterOptions);
    }

    public List<WebElement> getDropDownList() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownList));
        return driver.findElements(dropDownList);
    }

    public WebElement getDateOption() {
        return driver.findElement(dateOption);
    }

    public WebElement getClearButton() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(clearButton));
        wait.until(ExpectedConditions.elementToBeClickable(clearButton));
        return driver.findElement(clearButton);
    }

    public void getPopUpFilterButton() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(popUpFilterButton));
        driver.findElement(popUpFilterButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpFilterButton));

    }

    public WebElement getAuditDetailsHeader() {
        return driver.findElement(auditDetailsHeader);
    }

}
