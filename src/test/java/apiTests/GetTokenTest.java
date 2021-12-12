package apiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.PostTokenMethod;
import com.solvd.carina.demo.utils.SpotifyConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.module.Configuration;
import java.util.Properties;

public class GetTokenTest implements IAbstractTest {

    @Test
    public void testGetToken(){
        PostTokenMethod api = new PostTokenMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        Response response = api.callAPI();
        String stringResponse = response.asString();
        String code = stringResponse.substring(stringResponse.indexOf(':'), stringResponse.indexOf(','));
        code = code.substring(2, code.length()-1);
        SpotifyConfig.setProperty(code);
    }
}
