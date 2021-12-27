package apiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.PostRefreshTokenMethod;
import com.solvd.carina.demo.utils.SpotifyConfig;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

public class BaseTest implements IAbstractTest {
    @BeforeSuite
    public void getToken(){
        PostRefreshTokenMethod api = new PostRefreshTokenMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        Response response = api.callAPI();
        String stringResponse = response.asString();
        String code = stringResponse.substring(stringResponse.indexOf(':'), stringResponse.indexOf(','));
        code = code.substring(2, code.length()-1);
        SpotifyConfig.setProperty(code);
    }
}
