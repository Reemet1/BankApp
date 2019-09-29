package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe" );
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://localhost:8443/login");
        driver.findElement(By.id("username")).sendKeys("reemet");
        driver.findElement(By.id("password")).sendKeys("parool");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        System.out.println();

    }

}
