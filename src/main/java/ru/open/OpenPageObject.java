package ru.open;

import com.google.GooglePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenPageObject extends GooglePageObject {

    private List<WebElement> resultLinks;

    public List<WebElement> getResultLinks() {
        return resultLinks;
    }

    public OpenPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    public void find(String keysFind) {
        super.find(keysFind);
        resultLinks = super.getResultLinks();

        if (resultLinks.stream().anyMatch(x -> x.getText().contains("https://www.open.ru"))) {
            webDriver.get("https://www.open.ru");
            resultLinks = webDriver.findElements(By.className("main-page-exchange__rate"));
        }
    }

}
