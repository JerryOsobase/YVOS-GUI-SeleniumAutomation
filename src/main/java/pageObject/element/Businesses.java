package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Businesses {

    WebDriver driver;

    public Businesses(WebDriver driver){
        this.driver=driver;
    }

    private By businessesHeader = By.xpath("//tr/th");
    private By searchBar = By.cssSelector("input[placeholder='Search for Business']");
    private By createButton = By.xpath("//button/span[contains(text(), 'Create Business')]");
    private By filterButton = By.xpath("//button/span[contains(text(), 'Filter')]");
    private By businessName = By.cssSelector("td a[href*='/businesses']");

    private By dateOption = By.cssSelector("button[class*='ring rounded shadow-none']");

    public WebElement getBusinessesHeader() {
        return driver.findElement(businessesHeader);
    }
    public WebElement getSearchBar() {
        return driver.findElement(searchBar);
    }
    public WebElement getCreateButton() {
        return driver.findElement(createButton);
    }
    public WebElement getFilterButton() {
        return driver.findElement(filterButton);
    }
    public WebElement getBusinessName() {
        return driver.findElement(businessName);
    }


}
