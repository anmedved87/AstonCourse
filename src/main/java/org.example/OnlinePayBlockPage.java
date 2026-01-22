package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinePayBlockPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public OnlinePayBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public OnlinePayBlockPage open() {
        driver.get("https://www.mts.by/");
        return this;
    }

    public OnlinePayBlockPage closeCookie() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Принять')]")
            )).click();
        } catch (Exception ignored) {
        }
        return this;
    }

    public OnlinePayBlockPage scroll() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,1800)");
        return this;
    }


    private void openDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".select__header")
        )).click();
    }

    public OnlinePayBlockPage openServices() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Услуги связи']")
        )).click();
        return this;
    }

    public OnlinePayBlockPage openInternet() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Домашний интернет']")
        )).click();
        return this;
    }

    public OnlinePayBlockPage openInstallment() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Рассрочка']")
        )).click();
        return this;
    }

    public OnlinePayBlockPage openDuty() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Задолженность']")
        )).click();
        return this;
    }


    public WebElement servicesPhone() {
        return driver.findElement(By.id("connection-phone"));
    }

    public WebElement servicesSum() {
        return driver.findElement(By.id("connection-sum"));
    }

    public WebElement servicesEmail() {
        return driver.findElement(By.id("connection-email"));
    }

    public WebElement servicesContinue() {
        return driver.findElement(By.cssSelector("form#pay-connection button"));
    }

    public String servicesPhonePlaceholder() {
        return servicesPhone().getAttribute("placeholder");
    }

    public String servicesSumPlaceholder() {
        return servicesSum().getAttribute("placeholder");
    }

    public String servicesEmailPlaceholder() {
        return servicesEmail().getAttribute("placeholder");
    }

    public String internetPhonePlaceholder() {
        return driver.findElement(By.id("internet-phone"))
                .getAttribute("placeholder");
    }

    public String internetSumPlaceholder() {
        return driver.findElement(By.id("internet-sum"))
                .getAttribute("placeholder");
    }

    public String internetEmailPlaceholder() {
        return driver.findElement(By.id("internet-email"))
                .getAttribute("placeholder");
    }


    public String installmentScorePlaceholder() {
        return driver.findElement(By.id("score-instalment"))
                .getAttribute("placeholder");
    }

    public String installmentSumPlaceholder() {
        return driver.findElement(By.id("instalment-sum"))
                .getAttribute("placeholder");
    }

    public String installmentEmailPlaceholder() {
        return driver.findElement(By.id("instalment-email"))
                .getAttribute("placeholder");
    }


    public String dutyScorePlaceholder() {
        return driver.findElement(By.id("score-arrears"))
                .getAttribute("placeholder");
    }

    public String duutySumPlaceholder() {
        return driver.findElement(By.id("arrears-sum"))
                .getAttribute("placeholder");
    }

    public String dutyEmailPlaceholder() {
        return driver.findElement(By.id("arrears-email"))
                .getAttribute("placeholder");
    }
}