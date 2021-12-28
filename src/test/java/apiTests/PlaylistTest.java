package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.DeleteItemsFromPlaylistMethod;
import com.solvd.carina.demo.api.spotify.GetPlaylistMethod;
import com.solvd.carina.demo.api.spotify.PostAddItemsToPlaylistMethod;
import com.solvd.carina.demo.api.spotify.PutEditPlaylistDetailsMethod;
import com.solvd.carina.demo.utils.ResponseUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest {

    @Test
    public void testAddItem(){
        PostAddItemsToPlaylistMethod api = new PostAddItemsToPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_post/playlist/rs.json");
    }

    @Test
    public void testDeleteExistingItem(){
        GetPlaylistMethod getPlaylistAPI = new GetPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        String playlistResponse = getPlaylistAPI.callAPI().body().asString();
        String code = ResponseUtil.extractProperty(playlistResponse,"snapshot_id");
        System.out.println(code);
        DeleteItemsFromPlaylistMethod deleteItemFromPlaylistAPI = new DeleteItemsFromPlaylistMethod("0LK33kBZy9PoLxnwlmguwf",
                 "spotify:track:4rrVViTjF6RCrSKqEfqF8Z");
        deleteItemFromPlaylistAPI.expectResponseStatus(HttpResponseStatusType.OK_200);
        String deleteResponse = deleteItemFromPlaylistAPI.callAPI().body().asString();
        deleteItemFromPlaylistAPI.validateResponseAgainstSchema("api.spotify/_delete/playlist/rs.json");
        Assert.assertNotEquals(ResponseUtil.extractProperty(deleteResponse, "snapshot_id"), code);
    }

    @Test
    public void testDeleteNotExistingItem(){
        GetPlaylistMethod getPlaylistAPI = new GetPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        String playlistResponse = getPlaylistAPI.callAPI().body().asString();
        String code = ResponseUtil.extractProperty(playlistResponse,"snapshot_id");
        DeleteItemsFromPlaylistMethod deleteItemFromPlaylistAPI = new DeleteItemsFromPlaylistMethod("0LK33kBZy9PoLxnwlmguwf",
                "spotify:track:7npsu1AKBLD5u3yw6N7Xu9");
        deleteItemFromPlaylistAPI.expectResponseStatus(HttpResponseStatusType.OK_200);
        String deleteResponse = deleteItemFromPlaylistAPI.callAPI().body().asString();
        deleteItemFromPlaylistAPI.validateResponseAgainstSchema("api.spotify/_delete/playlist/rs.json");
        Assert.assertEquals(ResponseUtil.extractProperty(deleteResponse, "snapshot_id"), code);
    }

    @Test
    public void testChangePlaylistName(){
        GetPlaylistMethod getPlaylistAPI = new GetPlaylistMethod("0LK33kBZy9PoLxnwlmguwf");
        String playlistResponse = getPlaylistAPI.callAPI().body().asString();
        String oldName = ResponseUtil.extractProperty(playlistResponse,"name");
        PutEditPlaylistDetailsMethod editPlaylistDetails = new PutEditPlaylistDetailsMethod("0LK33kBZy9PoLxnwlmguwf");
        editPlaylistDetails.expectResponseStatus(HttpResponseStatusType.OK_200);
        editPlaylistDetails.callAPI();
        String editResponse = getPlaylistAPI.callAPI().body().asString();
        Assert.assertNotEquals(ResponseUtil.extractProperty(editResponse, "name"), oldName);
    }
}
