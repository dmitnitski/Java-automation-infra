package extensions;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import static jdk.nashorn.internal.objects.Global.print;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String params){
        response = request.get(params);
        response.prettyPrint();
        return response;
    }

    @Step("Extract value from Json")
    public static String extractFromJson(Response response, String path){
        jp = response.jsonPath();

        return jp.get(path).toString();
    }

    @Step("Post data to server")
    public static void post(JSONObject params, String resource){
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.post(resource);

        response.prettyPrint();
    }

    @Step("Update data to server")
    public static void put(JSONObject params, String resource){
        request.header("Content-Type", "application/json");
        request.body(params.toJSONString());
        response = request.put(resource);

        response.prettyPrint();
    }

    @Step("Delete data to server")
    public static void delete(String resource){
        response = request.delete(resource);

        response.prettyPrint();
    }
}
