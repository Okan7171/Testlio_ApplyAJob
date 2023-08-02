package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ApplyPage extends BasePage{


@FindBy (xpath = "//div[@class='wp-block-button']//a")
public WebElement seeOpenPositions;

@FindBy (xpath = "//a[text()='Apply now']")
public WebElement applyNowButton;

@FindBy (id= "first_name")
public WebElement inputFirstName;

@FindBy (id = "last_name")
public WebElement inputlastName;

@FindBy (id = "email")
public WebElement inputEMail;

@FindBy (id = "phone")
public WebElement inputPhone;

@FindBy (css = "#resume")
public WebElement inputResume;

@FindBy (css = "#cover_letter")
public WebElement inputCoverLetter;

@FindBy (css = "#question_34179742")
public WebElement inputLinkedin;

    @FindBy (id = "demographic-answers-179807")
    public WebElement age;

@FindBy (id = "demographic-answers-179812")
public WebElement gender;

@FindBy (id = "demographic-answers-179817")
public WebElement transgender;

@FindBy (id = "demographic-answers-179823")
public WebElement hetero;

@FindBy (id = "demographic-answers-179831")
public WebElement race;

@FindBy (id = "demographic-answers-179836")
public WebElement disability;

@FindBy (xpath = "//button[text()='Submit']")
public WebElement submitButton;

@FindBy (xpath = "//h4[text()='Thank you for your interest!']")
public WebElement confirmationMessage;








    public void validateSecPageText (String text, String fullText){
        text=text.substring(0, 1) + text.substring(1).toLowerCase();
        WebElement element = Driver.get().findElement
                (By.xpath("//h1[text()='" + text + " work at Testlio']"));
        Assert.assertEquals(fullText, element.getText());
    }

    public void jobTitle (String module){
        WebElement element = Driver.get().findElement
                (By.xpath("//h4[text()='" + module + "']"));
        BrowserUtils.clickWithJS(element);
    }

    public void fillOutFirstNameLastName (String firstName, String lastName, String email, String phone){
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("arguments[0].setAttribute('value', '" + firstName +"')", inputFirstName);
        jse.executeScript("arguments[0].setAttribute('value', '" + lastName +"')", inputlastName);
        jse.executeScript("arguments[0].setAttribute('value', '" + email +"')", inputEMail);
        jse.executeScript("arguments[0].setAttribute('value', '" + phone +"')", inputPhone);

    }

    public void addResumeAndCoverLettter(){
        String projectPath= System.getProperty("user.dir");
        String fileResume= "src/test/resources/OlcayERResume.pdf";
        String resumePath= projectPath + "/" + fileResume;

        String fileCover= "src/test/resources/OlcayERCover_Letter.pdf";
        String coverLetterPath= projectPath + "/" + fileCover;

        inputResume.sendKeys(resumePath);
        inputCoverLetter.sendKeys(coverLetterPath);
    }

    public void fillOutOtherPlaces(String linkedin, String description, String year,
                                   String place, String money){

        BrowserUtils.waitFor(2);
        Actions actions= new Actions(Driver.get());
        actions.click(inputLinkedin)
                .sendKeys(linkedin + Keys.TAB)
                .sendKeys(description+ Keys.TAB)
                .sendKeys(year + Keys.TAB)
                .sendKeys(place + Keys.TAB)
                .sendKeys((money+ Keys.TAB)).perform();

    }

    public void selectMultipleChoice (){
        age.click();
        gender.click();
        transgender.click();
        hetero.click();
        race.click();
        disability.click();
    }


}
