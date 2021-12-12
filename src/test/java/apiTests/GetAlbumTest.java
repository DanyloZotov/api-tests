package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import com.solvd.carina.demo.api.spotify.PostTokenMethod;
import com.solvd.carina.demo.utils.SpotifyConfig;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GetAlbumTest {

    @BeforeSuite
    public void getToken(){
        PostTokenMethod api = new PostTokenMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        Response response = api.callAPI();
        String stringResponse = response.asString();
        String code = stringResponse.substring(stringResponse.indexOf(':'), stringResponse.indexOf(','));
        code = code.substring(2, code.length()-1);
        SpotifyConfig.getInstance();
        SpotifyConfig.setProperty(code);
    }

    @Test
    public void testGetAlbum(){
        GetAlbumMethod api = new GetAlbumMethod("4aawyAB9vmqN3uQ7FjRGTy");
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_get/playlist/rs.json");
    }
}
