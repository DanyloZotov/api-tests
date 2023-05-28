package gApiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.PostCreateRepoMethod;
import org.testng.annotations.Test;

public class CreateReposTest implements IAbstractTest {

    @Test
    public void testCreateRepos(){
        PostCreateRepoMethod api = new PostCreateRepoMethod();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
    }

}
