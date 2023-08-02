package com.step_defs;

import com.pages.ApplyPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class ApplyStepDefs {

    ApplyPage applyPage=new ApplyPage();

    static String secondaryModule;

    @Given("the user should go to testlio page")
    public void the_user_should_go_to_testlio_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Then("the user should validate the correct page")
    public void the_user_should_validate_the_correct_page() {
        Assert.assertEquals(applyPage.signIn.getText(), "Sign in");
    }
    @Given("the user should go to the {string} module")
    public void the_user_should_go_to_the_module(String module) {
    applyPage.selectModule(module);
    }

    @When("the user should go to the {string} secondary module")
    public void the_user_should_go_to_the_secondary_module(String module) {
        applyPage.selectSecondaryModule(module);
        secondaryModule=module;
    }

    @Then("the user should see {string} text")
    public void the_user_should_see_text(String fullText) {
    applyPage.validateSecPageText(secondaryModule, fullText);
    }


    @Then("the user should go to the See open positions page")
    public void the_user_should_go_to_the_see_open_positions_page() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(applyPage.seeOpenPositions);
    }
    @Then("the user should choose {string} page")
    public void the_user_should_choose_page(String module) {
    applyPage.jobTitle(module);
    }
    @Then("the user should choose Apply now text")
    public void the_user_should_choose_apply_now_text() {
    applyPage.applyNowButton.click();
    }
    @Then("the user should fill out the form {string}, {string}, {string}, {string}")
    public void the_user_should_fill_out_the_form(String string, String string2, String string3, String string4) {
    applyPage.fillOutFirstNameLastName(string, string2, string3, string4);
    }
    @Then("the user should add Resume and Cover Letter")
    public void the_user_should_add_resume_and_cover_letter() {
        applyPage.addResumeAndCoverLettter();
    }
    @Then("the user should fill out the related areas {string}, {string}, {string}, {string}, {string}")
    public void the_user_should_fill_out_the_related_areas(String string, String string2, String string3, String string4, String string5) {
    applyPage.fillOutOtherPlaces(string, string2, string3, string4, string5);
    }
    @Then("the user should select the multiplechoice questions' answers")
    public void the_user_should_select_the_multiplechoice_questions_answers() {
        applyPage.selectMultipleChoice();
    }

    @Then("the user click submit button")
    public void the_user_click_submit_button() {
      applyPage.submitButton.click();
    }
    @Then("the user should validate {string} the message")
    public void the_user_should_validate_the_message(String string) {
        BrowserUtils.waitForVisibility(applyPage.confirmationMessage, 5);
        String confirmationMessageText = applyPage.confirmationMessage.getText();
        Assert.assertEquals(string, confirmationMessageText);
    }

}
