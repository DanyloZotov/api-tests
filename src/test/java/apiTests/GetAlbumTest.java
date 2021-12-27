package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import org.testng.annotations.Test;

public class GetAlbumTest extends BaseTest{

    @Test
    public void testGetAlbum(){
        GetAlbumMethod api = new GetAlbumMethod("4aawyAB9vmqN3uQ7FjRGTy");
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_get/playlist/rs.json");
    }
}
