package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GooglePageObject {
    protected WebDriver webDriver;
    private WebElement searchField;
    private WebElement buttonField;
    private List<WebElement> resultLinks;

    public List<WebElement> getResultLinks() {
        return resultLinks;
    }

    public GooglePageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        searchField = webDriver.findElement(By.name("q"));
        buttonField = webDriver.findElement(By.name("btnK"));
    }

    public void find(String keysFind) {
        searchField.click();
        searchField.sendKeys(keysFind);
        buttonField.click();
        resultLinks = webDriver.findElements(By.tagName("a"));
    }

}
