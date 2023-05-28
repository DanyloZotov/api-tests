package com.solvd.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteUnlockAnIssueMethod extends AbstractApiMethodV2 {

    public DeleteUnlockAnIssueMethod(){
        super();
        replaceUrlPlaceholder("g_base_url", Configuration.getEnvArg("g_api_url"));
        request.header("Authorization", "token "+ Configuration.getEnvArg("g_token"));
    }

}
