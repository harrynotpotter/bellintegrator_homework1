package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GooglePageFactory {
    private WebDriver webDriver;

    @FindBy(how = How.NAME, name = "q")
    private WebElement searchField;

    @FindBy(how = How.NAME, name = "btnK")
    private WebElement buttonField;

    @FindBy(how = How.TAG_NAME, tagName = "a")
    private List<WebElement> resultLinks;

    public GooglePageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void find(String keysFind) {
        searchField.click();
        searchField.sendKeys(keysFind);
        buttonField.click();
    }

    public List<WebElement> getResultLinks() {
        return resultLinks;
    }
}
