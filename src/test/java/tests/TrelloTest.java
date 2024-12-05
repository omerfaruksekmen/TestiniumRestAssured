package tests;

import config.ConfigManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.CardPage;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class TrelloTest {

    @Test
    public void trelloScenarioTest() {
        // Yeni bir board oluştur
        String boardName = "Testinium Board";

        BoardPage boardPage = new BoardPage();
        Response createResponse = boardPage.createBoard(boardName);

        // Responsedan board ID'sini al
        String boardId = createResponse.jsonPath().getString("id");
        System.out.println("Created Board ID: " + boardId);

        // Listeleri al
        Response listResponse = boardPage.getLists(boardId);
        String firstListId = listResponse.jsonPath().getString("[0].id");
        System.out.println("List ID: " + firstListId);

        // 2 tane kart oluştur.
        CardPage cardPage = new CardPage();
        Response createCardResponse = cardPage.createCard(firstListId);
        String cardId = createCardResponse.jsonPath().getString("id");
        System.out.println("Card1 ID: " + cardId);

        Response createCardResponse2 = cardPage.createCard(firstListId);
        String cardId2 = createCardResponse2.jsonPath().getString("id");
        System.out.println("Card2 ID: " + cardId2);

        // 1 kartı güncelle
        Response updateCardResponse = cardPage.updateCard(cardId);

        // Kartları sil
        Response deleteCardResponse = cardPage.deleteCard(cardId);
        Response deleteCardResponse2 = cardPage.deleteCard(cardId2);

        // Board'u sil
        Response deleteResponse = boardPage.deleteBoard(boardId);

    }
}

