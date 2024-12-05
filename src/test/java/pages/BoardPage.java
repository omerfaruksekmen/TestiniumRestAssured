package pages;

import config.ConfigManager;
import io.restassured.response.Response;
import utils.ApiHelper;

import java.util.HashMap;
import java.util.Map;

public class BoardPage {

    // Board oluşturma metodu
    public Response createBoard(String name) {
        String endpoint = ConfigManager.BASE_URL + "/boards";
        return ApiHelper.sendPostRequest(endpoint, name, ConfigManager.API_KEY, ConfigManager.TOKEN);
    }

    // Board silme metodu
    public Response deleteBoard(String boardId) {
        String endpoint = ConfigManager.BASE_URL + "/boards";
        return ApiHelper.sendDeleteBoardRequest(endpoint, boardId, ConfigManager.API_KEY, ConfigManager.TOKEN);
    }

    // list id listeleme
    public Response getLists(String boardId){
        String endpoint = ConfigManager.BASE_URL + "/boards";
        return ApiHelper.getListRequest(endpoint, boardId, ConfigManager.API_KEY, ConfigManager.TOKEN);
    }

}
