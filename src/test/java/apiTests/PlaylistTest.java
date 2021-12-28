package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.DeleteItemsFromPlaylistMethod;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import com.solvd.carina.demo.api.spotify.PostAddItemsToPlaylistMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PlaylistTest extends BaseTest {

    @Test
    public void AddItemTest(){
        PostAddItemsToPlaylistMethod api = new PostAddItemsToPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_post/playlist/rs.json");
    }

    @Test
    public void DeleteExistingItemTest(){
        DeleteItemsFromPlaylistMethod api = new DeleteItemsFromPlaylistMethod("0LK33kBZy9PoLxnwlmguwf",
                "spotify:track:4rrVViTjF6RCrSKqEfqF8Z");
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/delete/playlist/rs.json");
    }

    @Test
    public void DeleteNotExistingItemTest(){
        DeleteItemsFromPlaylistMethod api = new DeleteItemsFromPlaylistMethod("0LK33kBZy9PoLxnwlmguwf",
                "spotify:track:7npsu1AKBLD5u3yw6N7Xu9");
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
    }
}
