package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.open.OpenPageObject;

import java.util.List;

public class Tests extends BaseTests {
    @Test
    public void firstTestPageObject() {
        webDriver.get("https://www.google.com/");
        GooglePageObject googlePageObject = new GooglePageObject(webDriver);
        googlePageObject.find("Гладиолус");
        Assertions.assertTrue(googlePageObject.getResultLinks().stream()
                .anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")), "Ссылка на вики не найдена");
    }

    @Test
    public void firstTestPageFactory() {
        webDriver.get("https://www.google.com/");
        GooglePageFactory googlePageFactory = PageFactory.initElements(webDriver, GooglePageFactory.class);
        googlePageFactory.find("Гладиолус");
        Assertions.assertTrue(googlePageFactory.getResultLinks().stream()
                .anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")), "Ссылка на вики не найдена");
    }
    @Test
    public void secondTestPageObject() {
        webDriver.get("https://www.google.com/");
        OpenPageObject openPageObject = new OpenPageObject(webDriver);
        openPageObject.find("Открытие");
        for (int i = 0; i <= openPageObject.getResultLinks().size() - 1; i += 2) {
            Assertions.assertTrue(
                    Double.parseDouble(openPageObject.getResultLinks().get(i).getText().replace(",","."))
                            < Double.parseDouble(openPageObject.getResultLinks().get(i + 1).getText().replace(",",".")));
            //System.out.println(Double.valueOf(openPageObject.getResultLinks().get(i).getText().replace(",",".")) + "<" + Double.valueOf(openPageObject.getResultLinks().get(i+1).getText().replace(",",".")));
        }
    }

}
