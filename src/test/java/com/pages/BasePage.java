package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (xpath = "//a[text()='Sign in']")
    public WebElement signIn;

    public void selectModule (String module){
        Driver.get().findElement(By.xpath("//a[text()='"+module+"']")).click();
    }

    public void selectSecondaryModule (String module){
        Driver.get().findElement(By.xpath("//div[text()='"+module+"']")).click();
    }

}
