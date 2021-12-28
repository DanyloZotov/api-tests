package apiTests;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.spotify.GetMarketsMethod;
import org.testng.annotations.Test;

public class MarketsTest extends BaseTest{
    @Test
    public void testGetMarketsList(){
        GetMarketsMethod api = new GetMarketsMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api.spotify/_get/markets/rs.json");
    }
}
