package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test02_VisibilityLogo extends DriverTest {
    @Test
    void logo() {
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

        List<WebElement> logos = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".pay__partners img")
                ));

        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не отображаются");
        assertTrue(logos.size() >= 4, "Должны отображаться 4 логотипа платёжных систем");
    }
}
