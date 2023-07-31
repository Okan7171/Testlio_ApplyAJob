package com.pages;

import com.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApplyPage extends BasePage{

    public void validateSecPageText (String text, String fullText){
        text=text.substring(0, 1) + text.substring(1).toLowerCase();
        WebElement element = Driver.get().findElement
                (By.xpath("//h1[text()='" + text + " work at Testlio']"));
        Assert.assertEquals(fullText, element.getText());
    }
}
