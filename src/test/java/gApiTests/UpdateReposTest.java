package gApiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.PatchUpdateRepoMethod;
import org.testng.annotations.Test;

public class UpdateReposTest implements IAbstractTest {

    @Test
    public void testUpdateRepo(){
        PatchUpdateRepoMethod api = new PatchUpdateRepoMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
    }

}
