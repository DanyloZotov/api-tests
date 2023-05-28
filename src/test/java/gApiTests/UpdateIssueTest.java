package gApiTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.GetAnIssueMethod;
import com.solvd.carina.demo.api.github.PatchUpdateAnIssueMethod;
import com.solvd.carina.demo.utils.ResponseUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateIssueTest implements IAbstractTest {

    @Test
    public void testUpdateIssue(){
        PatchUpdateAnIssueMethod api = new PatchUpdateAnIssueMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response1 = api.callAPI().body().asString();
        String title = ResponseUtil.extractProperty(response1, "title");
        GetAnIssueMethod getIssue = new GetAnIssueMethod();
        getIssue.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response2 = getIssue.callAPI().body().asString();
        Assert.assertEquals(title, ResponseUtil.extractProperty(response2, "title"));
    }

}
