package api.requests;

import io.restassured.response.Response;
import org.json.JSONObject;

public class UserApi extends BaseApi {

    private static final String APP_ID = "63a804408eb0cb069b57e43a";

    public Response getUserById(String userId) {
        return request()
                .header("app-id", APP_ID)   // tambahkan header app-id
                .get("/user/" + userId);
    }

    public Response createUser(String firstName, String lastName, String email) {
        JSONObject body = new JSONObject();
        body.put("title", "mr"); // wajib
        body.put("firstName", firstName);
        body.put("lastName", lastName);
        body.put("email", email);
        body.put("picture", "https://randomuser.me/api/portraits/med/men/1.jpg"); // wajib

        return request()
                .header("app-id", APP_ID)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .post("/user/create");
    }

    public Response updateUser(String userId, String firstName) {
        JSONObject body = new JSONObject();
        body.put("firstName", firstName);

        return request()
                .header("app-id", APP_ID)    // tambahkan header app-id
                .header("Content-Type", "application/json")
                .body(body.toString())
                .put("/user/" + userId);
    }

    public Response deleteUser(String userId) {
        return request()
                .header("app-id", APP_ID)    // tambahkan header app-id
                .delete("/user/" + userId);
    }
}
