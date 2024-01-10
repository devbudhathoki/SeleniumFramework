package com.qa.utils.elk;

import com.qa.config.ConfigFactory;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ELKUtils {

    private ELKUtils() {}

    public static void sendResultToElk(String testName, String status) {

        if(ConfigFactory.getConfig().sendResultToELK().equalsIgnoreCase("yes")) {
            Map<String,String> map = new HashMap<>();
            map.put("testName", testName );
            map.put("status" , status);
            map.put("executionTime", LocalDateTime.now().toString());

            Response response = given().header("Content-Type","application/json")
                    .log()
                    .all()
                    .body(map)
                    .post(ConfigFactory.getConfig().elasticUrl());

            Assert.assertEquals(response.statusCode(), 201);

            response.prettyPrint();
        }
    }

}
