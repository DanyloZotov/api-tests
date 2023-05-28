package gApiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.GetAnIssueMethod;
import com.solvd.carina.demo.api.github.PutLockAnIssueMethod;
import com.solvd.carina.demo.utils.ResponseUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LockIssueTest implements IAbstractTest {

    @Test
    public void testLockIssue(){
        PutLockAnIssueMethod api = new PutLockAnIssueMethod();
        api.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        api.callAPI();
        GetAnIssueMethod getIssue = new GetAnIssueMethod();
        getIssue.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response2 = getIssue.callAPI().body().asString();
        Assert.assertEquals(ResponseUtil.extractProperty(response2, "locked"), "true,");
    }

}
