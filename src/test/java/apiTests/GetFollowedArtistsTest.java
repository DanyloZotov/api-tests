package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import com.solvd.carina.demo.api.spotify.GetFollowedArtistsMethod;
import org.testng.annotations.Test;

public class GetFollowedArtistsTest extends BaseTest{

    @Test
    public void testGetFollowedArtists(){
        GetFollowedArtistsMethod api = new GetFollowedArtistsMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_get/followed-artists/rs.json");
    }

}
