package com.solvd.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCreateAnIssue extends AbstractApiMethodV2 {

    public PostCreateAnIssue(){
        super("api.github/_post/issue/rq.json", null);
        replaceUrlPlaceholder("g_base_url", Configuration.getEnvArg("g_api_url"));
        request.header("Authorization", "token "+ Configuration.getEnvArg("g_token"));

    }

}
