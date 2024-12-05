package pages;

import config.ConfigManager;
import io.restassured.response.Response;
import utils.ApiHelper;

import java.util.HashMap;
import java.util.Map;


public class CardPage {

    // Kart oluşturma metodu
    public Response createCard(String idList) {
        String endpoint = ConfigManager.BASE_URL + "/cards";
        return ApiHelper.sendPostRequestCard(endpoint, idList, ConfigManager.API_KEY, ConfigManager.TOKEN);
    }

    // Kart silme metodu
    public Response deleteCard(String cardId) {
        String endpoint = ConfigManager.BASE_URL + "/cards";
        return ApiHelper.sendDeleteCardRequest(endpoint, cardId, ConfigManager.API_KEY, ConfigManager.TOKEN);
    }

    // Kart güncelleme metodu
    public Response updateCard(String cardId) {
        String endpoint = ConfigManager.BASE_URL + "/cards";
        return ApiHelper.sendPutRequestCard(endpoint, cardId, ConfigManager.API_KEY, ConfigManager.TOKEN);
    }
}
