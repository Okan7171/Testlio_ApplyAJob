package com.step_defs;

import com.pages.ApplyPage;
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




}
