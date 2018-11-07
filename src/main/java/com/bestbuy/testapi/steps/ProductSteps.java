package com.bestbuy.testapi.steps;

import com.bestbuy.testapi.constant.Constant;
import com.bestbuy.testapi.utils.ApiUtil;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sekarayukarindra
 */
public class ProductSteps extends ApiUtil {
    static Constant constant;
    static Response response;
    String root = "data";
    int ID;
    final static Logger LOGGER = Logger.getLogger(ProductSteps.class);

    @Step
    public void getAllProducts(){
        response = SerenityRest.given().log().all().when().
                get(constant.BASE_URL+"products");
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
    }

    @Step
    public void verifyAProduct(){
        verifyAllProductHeaderDataScheme(root,response);
        verifyAProductFromAllDataScheme(root,response);
    }

    private void verifyAProductFromAllDataScheme(String jsonRoot, Response response){
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("id[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("name[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("type[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("price[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("upc[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("shipping[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("description[0]"));
        Assert.assertNotNull(getJsonPath(jsonRoot, response).get("manufacturer[0]"));
    }

    private void verifyAllProductHeaderDataScheme(String jsonRoot, Response response){
        Assert.assertNotNull(getJsonPath(response).get("total"));
        Assert.assertNotNull(getJsonPath(response).get("limit"));
        Assert.assertNotNull(getJsonPath(response).get("skip"));
        Assert.assertNotNull(getJsonPath(response).get("total"));
    }

    private void verifyAProductDataScheme(Response response){
        Assert.assertNotNull(getJsonPath(response).get("id"));
        Assert.assertNotNull(getJsonPath(response).get("name"));
        Assert.assertNotNull(getJsonPath(response).get("type"));
        Assert.assertNotNull(getJsonPath(response).get("price"));
        Assert.assertNotNull(getJsonPath(response).get("upc"));
        Assert.assertNotNull(getJsonPath(response).get("shipping"));
        Assert.assertNotNull(getJsonPath(response).get("description"));
        Assert.assertNotNull(getJsonPath(response).get("manufacturer"));
    }

    @Step
    public void getProductById(String id){
        response = SerenityRest.given().log().all().when().
                get(constant.BASE_URL+"products/"+id);
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
    }

    @Step
    public void verifyProductById(String id){
        verifyAProductDataScheme(response);
        Assert.assertEquals("ID not equals!",id, getJsonPath(response).get("id").toString());
    }

    @Step
    public void postAProduct(String name, String type, String price, String upc, String description, String model){
        Map<String, Object> mapbody = new HashMap<>();
        mapbody.put("name",name);
        mapbody.put("type", type);
        mapbody.put("price",Integer.parseInt(price));
        mapbody.put("upc",upc);
        mapbody.put("description",description);
        mapbody.put("model",model);
        response = SerenityRest.given().header("Content-Type","application/json").header("Accept", "application/json")
                .body(mapbody)
                .log().all().when().post(constant.BASE_URL+"products");
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(201).build());
    }

    @Step
    public void verifyProductPosted(String name, String type, String price, String upc, String description, String model){
        Assert.assertNotNull(getJsonPath(response).get("id"));
        ID = getJsonPath(response).get("id");
        LOGGER.info("ID value : "+ID);
        Assert.assertEquals(name, getJsonPath(response).getString("name"));
        Assert.assertEquals(type, getJsonPath(response).getString("type"));
        Assert.assertEquals(price, getJsonPath(response).getString("price"));
        Assert.assertEquals(upc, getJsonPath(response).getString("upc"));
        Assert.assertEquals(description, getJsonPath(response).getString("description"));
        Assert.assertEquals(model, getJsonPath(response).getString("model"));
    }

    @Step
    public void deleteRecentlyCreatedProduct(){
        response = SerenityRest.given().log().all().when().delete(constant.BASE_URL+"products/"+ID);
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(200).build());
    }

    @Step
    public void verifyProductDeleted(){
        response = SerenityRest.given().log().all().when().get(constant.BASE_URL+"products/"+ID);
        response.then().assertThat().spec(new ResponseSpecBuilder().expectStatusCode(404).build());
    }
}
