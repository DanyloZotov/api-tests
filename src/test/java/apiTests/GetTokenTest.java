package apiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.PostTokenMethod;
import org.testng.annotations.Test;

public class GetTokenTest implements IAbstractTest {

    @Test
    public void testGetToken(){
        PostTokenMethod api = new PostTokenMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        System.out.println(api.toString());
    }
}
