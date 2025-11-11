package demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wrappers {
    ChromeDriver driver;

    public wrappers(ChromeDriver driver) {
        this.driver = driver;
    }

    public void navigate_to_url(String url) {
        try {
            if (!(driver.getCurrentUrl().equals(url))) {
                driver.get(url);
            }
        } catch (Exception e) {
            System.out.println("Error occurred during navigation to URL: " + e);
        }
    }

    public void click(By locator) {
        try {
            driver.findElement(locator).click();

        } catch (Exception e) {
            System.out.println("error occers during click on element " + e);
            // TODO: handle exception
        }
    }

    public String getText(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getText();

        } catch (Exception e) {
            System.out.println("error occers during geting text of element " + e);

        }
        return null;

    }

}