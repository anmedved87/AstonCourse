package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlineTopUpPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Общие действия ----------

    public OnlineTopUpPage open() {
        driver.get("https://www.mts.by/");
        return this;
    }

    public OnlineTopUpPage closeCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Принять')]")
            )).click();
        } catch (Exception ignored) {
        }
        return this;
    }

    public OnlineTopUpPage scrollToForm() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,1800)");
        return this;
    }

    // ---------- Выбор типа услуги ----------

    private void openDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".select__header")
        )).click();
    }

    public OnlineTopUpPage tabServices() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Услуги связи']")
        )).click();
        return this;
    }

    public OnlineTopUpPage tabInternet() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Домашний интернет']")
        )).click();
        return this;
    }

    public OnlineTopUpPage tabInstallment() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Рассрочка']")
        )).click();
        return this;
    }

    public OnlineTopUpPage tabDebt() {
        openDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Задолженность']")
        )).click();
        return this;
    }

    // ---------- Услуги связи ----------

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

    public String servicesPhonePH() {
        return servicesPhone().getAttribute("placeholder");
    }

    public String servicesSumPH() {
        return servicesSum().getAttribute("placeholder");
    }

    public String servicesEmailPH() {
        return servicesEmail().getAttribute("placeholder");
    }

    // ---------- Домашний интернет ----------

    public String internetPhonePH() {
        return driver.findElement(By.id("internet-phone"))
                .getAttribute("placeholder");
    }

    public String internetSumPH() {
        return driver.findElement(By.id("internet-sum"))
                .getAttribute("placeholder");
    }

    public String internetEmailPH() {
        return driver.findElement(By.id("internet-email"))
                .getAttribute("placeholder");
    }

    // ---------- Рассрочка ----------

    public String installmentScorePH() {
        return driver.findElement(By.id("score-instalment"))
                .getAttribute("placeholder");
    }

    public String installmentSumPH() {
        return driver.findElement(By.id("instalment-sum"))
                .getAttribute("placeholder");
    }

    public String installmentEmailPH() {
        return driver.findElement(By.id("instalment-email"))
                .getAttribute("placeholder");
    }

    // ---------- Задолженность ----------

    public String debtScorePH() {
        return driver.findElement(By.id("score-arrears"))
                .getAttribute("placeholder");
    }

    public String debtSumPH() {
        return driver.findElement(By.id("arrears-sum"))
                .getAttribute("placeholder");
    }
}
