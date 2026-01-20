package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test03_AboutService extends DriverTest {
    @Test
    void aboutService() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Принять')]")
                    )
            );
            cookieButton.click();
        } catch (Exception ignored) {
        }
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800);");

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Подробнее о сервисе')]")
                )
        );

        assertTrue(link.isDisplayed(), "Ссылка (Подробнее о сервисе) не отображается");
        link.click();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"),
                "Ссылка не открыта");
    }

}
