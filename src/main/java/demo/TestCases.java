package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.its.ITSValidityPeriod.Unit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
        ChromeDriver driver;
        wrappers action;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        public TestCases() {
                System.out.println("Constructor: TestCases");

                WebDriverManager.chromedriver().timeout(30).setup();
                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                // Set log level and type
                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);

                // Set path for log file
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

                driver = new ChromeDriver(options);
                action = new wrappers(driver);

                // Set browser to maximize and wait
                driver.manage().window().maximize();

        }

        public void endTest() {
                System.out.println("End Test: TestCases");
                driver.close();
                driver.quit();

        }

        public void testCase01() throws InterruptedException {
                System.out.println("Start Test case: testCase01");
                driver.get("https://google.com/");
                Thread.sleep(1000);
                System.out.println("completed Test case: testCase01");
        }

        public void testcase02() throws InterruptedException {
                System.out.println("Start Test case: testCase02");
                String url = "https://leetcode.com/";
                action.navigate_to_url(url);
                Thread.sleep(2000);
                Assert.isTrue(driver.getCurrentUrl().equals(url),
                                "URL not match with expected result. Actual: " + driver.getCurrentUrl());

                System.out.println("completed Test case: testCase02");

        }

        public void Testcases03() {
                System.out.println("Start Test case: testCase03");
                String url = "https://leetcode.com/";
                action.navigate_to_url(url);

                action.click(By.xpath("//p[@class='link' and contains(text(),'View Questions')]"));

                Assert.isTrue(driver.getCurrentUrl().contains("problemset"),
                                "URL not match with expected result. Actual: ");

                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                                "//div[@class='text-body text-sd-foreground max-w-full font-medium']/div[@class='ellipsis line-clamp-1']")));

                List<WebElement> quctionslist = driver.findElements(By.xpath(
                                "//div[@class='text-body text-sd-foreground max-w-full font-medium']/div[@class='ellipsis line-clamp-1']"));

                for (int i = 1; i < quctionslist.size() && i < 6; i++) {
                        WebElement item = quctionslist.get(i);
                        System.out.println(item.getText());
                }
                System.out.println("completed Test case: testCase03");
        }

        public void Testcases04() throws InterruptedException {

                System.out.println("Start Test case: testCase04");
                String url = "https://leetcode.com/";
                action.navigate_to_url(url);
                action.click(By.xpath("//p[@class='link' and contains(text(),'View Questions')]"));

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                                "//div[contains(text(),'Two Sum')]")));
                action.click(By.xpath("//div[contains(text(),'Two Sum')]"));
                Thread.sleep(2000);

                Assert.isTrue(driver.getCurrentUrl().contains("two-sum"),
                                "URL not match with expected result. Actual: ");
                System.out.println("completed Test case: testCase04");

        }

        public void Testcases05() throws InterruptedException {
                System.out.println("Start Test case: testCase05");
                String url = "https://leetcode.com/";
                action.navigate_to_url(url);
                action.click(By.xpath("//p[@class='link' and contains(text(),'View Questions')]"));

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                                "//div[contains(text(),'Two Sum')]")));
                action.click(By.xpath("//div[contains(text(),'Two Sum')]"));
                Thread.sleep(2000);

                Assert.isTrue(driver.getCurrentUrl().contains("two-sum"),
                                "URL not match with expected result. Actual: ");
                Thread.sleep(2000);

                wait.until(ExpectedConditions.elementToBeClickable(
                                By.id("submissions_tab")));
                action.click(By.id("submissions_tab"));

                wait.until(ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//a[text() = 'Register or Log in']")));

                WebElement verifying_Register = driver.findElement(By.xpath("//a[text() = 'Register or Log in']"));
                
                Assert.isTrue(verifying_Register.getText().equals("Register or Log in"),
                                "Register or Log is displaying");

                ////    verifying multipule times 'Register or Log' present or not  ///////
                Assert.isTrue(verifying_Register.isDisplayed(), "Register or Log is displaying");

                System.out.println("completed Test case: testCase05");

        }

}
