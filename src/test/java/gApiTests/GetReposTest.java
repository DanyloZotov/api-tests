package gApiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.GetRepositoriesMethod;
import com.solvd.carina.demo.api.spotify.GetAlbumMethod;
import org.testng.annotations.Test;

public class GetReposTest implements IAbstractTest {

    @Test
    public void testGetRepos(){
        GetRepositoriesMethod api = new GetRepositoriesMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api.github/_get/repos/rs.json");
    }

}
