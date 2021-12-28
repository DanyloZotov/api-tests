package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.DeleteItemsFromPlaylistMethod;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import com.solvd.carina.demo.api.spotify.GetPlaylistMethod;
import com.solvd.carina.demo.api.spotify.PostAddItemsToPlaylistMethod;
import com.solvd.carina.demo.utils.ResponseUtil;
import org.testng.Assert;
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
        GetPlaylistMethod getPlaylistAPI = new GetPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        String playlistResponse = getPlaylistAPI.callAPI().body().asString();
        String code = ResponseUtil.extractProperty(playlistResponse,"snapshot_id");
        System.out.println(code);
        DeleteItemsFromPlaylistMethod deleteItemFromPlaylistAPI = new DeleteItemsFromPlaylistMethod("0LK33kBZy9PoLxnwlmguwf",
                 "spotify:track:4rrVViTjF6RCrSKqEfqF8Z");
        deleteItemFromPlaylistAPI.expectResponseStatus(HttpResponseStatusType.OK_200);
        String deleteResponse = deleteItemFromPlaylistAPI.callAPI().body().asString();
        deleteItemFromPlaylistAPI.validateResponseAgainstSchema("api.spotify/delete/playlist/rs.json");
        Assert.assertNotEquals(ResponseUtil.extractProperty(deleteResponse, "snapshot_id"), code);
    }

    @Test
    public void DeleteNotExistingItemTest(){
        GetPlaylistMethod getPlaylistAPI = new GetPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        String playlistResponse = getPlaylistAPI.callAPI().body().asString();
        String code = ResponseUtil.extractProperty(playlistResponse,"snapshot_id");
        DeleteItemsFromPlaylistMethod deleteItemFromPlaylistAPI = new DeleteItemsFromPlaylistMethod("0LK33kBZy9PoLxnwlmguwf",
                "spotify:track:7npsu1AKBLD5u3yw6N7Xu9");
        deleteItemFromPlaylistAPI.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteItemFromPlaylistAPI.callAPI();
        String deleteResponse = deleteItemFromPlaylistAPI.callAPI().body().asString();
        deleteItemFromPlaylistAPI.validateResponseAgainstSchema("api.spotify/delete/playlist/rs.json");
        Assert.assertEquals(ResponseUtil.extractProperty(deleteResponse, "snapshot_id"), code);
    }
}
