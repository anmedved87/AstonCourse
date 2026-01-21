package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlineTopUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------- Общие действия ----------------

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

    public OnlineTopUpPage scroll() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1800);");
        return this;
    }

    // ---------------- Выпадающий список вкладок ----------------

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

    // ---------------- Услуги связи ----------------

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

    // ---------------- Домашний интернет ----------------

    public WebElement internetPhone() {
        return driver.findElement(By.id("internet-phone"));
    }

    public WebElement internetSum() {
        return driver.findElement(By.id("internet-sum"));
    }

    public WebElement internetEmail() {
        return driver.findElement(By.id("internet-email"));
    }

    public String internetPhonePH() {
        return internetPhone().getAttribute("placeholder");
    }

    public String internetSumPH() {
        return internetSum().getAttribute("placeholder");
    }

    public String internetEmailPH() {
        return internetEmail().getAttribute("placeholder");
    }

    // ---------------- Рассрочка ----------------

    public WebElement installmentScore() {
        return driver.findElement(By.id("score-instalment"));
    }

    public WebElement installmentSum() {
        return driver.findElement(By.id("instalment-sum"));
    }

    public WebElement installmentEmail() {
        return driver.findElement(By.id("instalment-email"));
    }

    public String installmentScorePH() {
        return installmentScore().getAttribute("placeholder");
    }

    public String installmentSumPH() {
        return installmentSum().getAttribute("placeholder");
    }

    public String installmentEmailPH() {
        return installmentEmail().getAttribute("placeholder");
    }

    // ---------------- Задолженность ----------------

    public WebElement debtScore() {
        return driver.findElement(By.id("score-arrears"));
    }

    public WebElement debtSum() {
        return driver.findElement(By.id("arrears-sum"));
    }

    public String debtScorePH() {
        return debtScore().getAttribute("placeholder");
    }

    public String debtSumPH() {
        return debtSum().getAttribute("placeholder");
    }
}
