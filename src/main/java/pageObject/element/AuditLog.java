package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuditLog {

    WebDriver driver;

    public AuditLog(WebDriver driver) {
        this.driver = driver;
    }

    private By activitiesTableHeader = By.xpath("//tr/th");
    private By filterButton = By.xpath("//button/span[contains(text(), 'Filter')]");
    private By eventField = By.cssSelector("#auditlog-table > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-5\\/6.sm\\:w-4\\/6.md\\:w-1\\/2.xl\\:w-2\\/6.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > div.px-0.flex-1.overflow-auto > div > div:nth-child(2) > " +
            "div.bg-white.py-4.px-6 > div > span > div > div.z-0.w-full > div");
    private By dropDownList = By.cssSelector("div[class='absolute z-20 menu'] div[class*='cursor-pointer']");
    private By dateOption = By.cssSelector("button[class*='ring rounded shadow-none']");
    private By clearButton = By.xpath("//button/span[contains(text(), 'Clear')]");
    private By popUpFilterButton = By.cssSelector("#auditlog-table > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-5\\/6.sm\\:w-4\\/6.md\\:w-1\\/2.xl\\:w-2\\/6.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > div > button.bg-highlight.text-white.ring-highlight.font-medium.py-3.px-8.text-base.focus\\:ring-4.rounded.shadow-none.focus\\" +
            ":outline-none.flex-shrink-0.text-center.ring-opacity-50.relative");
    private By auditDetailsHeader = By.cssSelector("div[class*='text-title font-semibold']");


    public WebElement getActivitiesTableHeader() {
        return driver.findElement(activitiesTableHeader);
    }

    public WebElement getFilterButton() {
        return driver.findElement(filterButton);
    }

    public WebElement getDropDownList() {
        return driver.findElement(dropDownList);
    }

    public WebElement getDateOption() {
        return driver.findElement(dateOption);
    }

    public WebElement getClearButton() {
        return driver.findElement(clearButton);
    }

    public WebElement getPopUpFilterButton() {
        return driver.findElement(popUpFilterButton);
    }

    public WebElement getAuditDetailsHeader() {
        return driver.findElement(auditDetailsHeader);
    }

}
