package workflow;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;


public class ApiFlows extends CommonOps {

    @Step("Business Flow:Get Team Property")
    public static String getTeamProperty(String jPath){;
        response = ApiActions.get("/api/teams/search");
        return ApiActions.extractFromJson(response, jPath);
    }

    @Step("Business Flow:Create new team")
    public static void createNewTeam(String name, String email){
        params.put("name", name);
        params.put("email", email);
        ApiActions.post(params, "/api/teams");
    }

    @Step("Business Flow:Update existing team")
    public static void updateTeam(String name, String email, String id){
        params.put("name", name);
        params.put("email", email);
        ApiActions.put(params, "/api/teams/" + id);
    }

    @Step("Business Flow:Delete existing team")
    public static void deleteTeam(String id){
        ApiActions.delete("/api/teams/" + id);
    }
}
