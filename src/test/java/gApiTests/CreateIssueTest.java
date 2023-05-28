package gApiTests;

import com.microsoft.schemas.office.office.STInsetMode;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.carina.demo.api.github.GetAnIssueMethod;
import com.solvd.carina.demo.api.github.PostCreateAnIssue;
import com.solvd.carina.demo.utils.ResponseUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class CreateIssueTest implements IAbstractTest {

    @Test
    public void testCreateIssue(){
        PostCreateAnIssue api = new PostCreateAnIssue();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        String response1 = api.callAPI().body().asString();
        String title = ResponseUtil.extractProperty(response1, "title");
        GetAnIssueMethod getIssue = new GetAnIssueMethod();
        getIssue.expectResponseStatus(HttpResponseStatusType.OK_200);
        String response2 = getIssue.callAPI().body().asString();
        Assert.assertEquals(title, ResponseUtil.extractProperty(response2, "title"));
    }

}
