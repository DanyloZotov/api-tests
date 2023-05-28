package com.solvd.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCreateRepoMethod extends AbstractApiMethodV2 {

    public PostCreateRepoMethod(){
        super("api.github/_post/repos/rq.json", null);
        replaceUrlPlaceholder("g_base_url", Configuration.getEnvArg("g_api_url"));
        request.header("Authorization", "token "+Configuration.getEnvArg("g_token"));
        request.header("Accept", "application/vnd.github.v3+json");
    }

}
