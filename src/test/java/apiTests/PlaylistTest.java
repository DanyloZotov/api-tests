package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import com.solvd.carina.demo.api.spotify.PostAddItemsToPlaylistMethod;
import org.testng.annotations.Test;

public class PlaylistTest {

    @Test
    public void AddItemsTest(){
        PostAddItemsToPlaylistMethod api = new PostAddItemsToPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_post/playlist/rs.json");
    }
}
