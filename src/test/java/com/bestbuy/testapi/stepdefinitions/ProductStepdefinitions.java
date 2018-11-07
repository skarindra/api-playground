package com.bestbuy.testapi.stepdefinitions;

import com.bestbuy.testapi.steps.ProductSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

/**
 * Created by sekarayukarindra
 */
public class ProductStepdefinitions {

    @Steps
    ProductSteps productSteps;

    @Given("^the user wants to get all products$")
    public void theUserWantsToGetAllProducts(){
        productSteps.getAllProducts();
    }

    @Then("^verify one example product$")
    public void verifyOneExampleProduct() throws Throwable {
        productSteps.verifyAProduct();
    }

    @Given("^the user wants to get product by id \"([^\"]*)\"$")
    public void theUserWantsToGetProductById(String arg0) throws Throwable {
        productSteps.getProductById(arg0);
    }

    @Then("^verify product by \"([^\"]*)\"$")
    public void verifyProductBy(String arg0) throws Throwable {
        productSteps.verifyProductById(arg0);
    }

    @Given("^the user wants to create new product with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void theUserWantsToCreateNewProductWith(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        productSteps.postAProduct(arg0,arg1,arg2,arg3,arg4,arg5);
    }

    @Then("^product will be created with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void productWillBeCreatedWith(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        productSteps.verifyProductPosted(arg0,arg1,arg2,arg3,arg4,arg5);
    }

    @Then("^product will be deleted$")
    public void productWillBeDeleted() throws Throwable {
        productSteps.verifyProductDeleted();
    }

    @Given("^the user wants to delete recently created product$")
    public void theUserWantsToDeleteRecentlyCreatedProduct() throws Throwable {
        productSteps.deleteRecentlyCreatedProduct();
    }
}
