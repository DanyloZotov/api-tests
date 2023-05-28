package gApiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.DeleteRepoMethod;
import org.testng.annotations.Test;

public class DeleteRepoTest implements IAbstractTest {

    @Test
    public void testDeleteRepo(){
        DeleteRepoMethod api = new DeleteRepoMethod();
        api.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        api.callAPI();
    }

}
