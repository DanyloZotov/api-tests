package com.solvd.carina.demo.api.github;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetRepositoriesMethod extends AbstractApiMethodV2 {

    public GetRepositoriesMethod(){
        super();
        replaceUrlPlaceholder("g_base_url", Configuration.getEnvArg("g_api_url"));
        request.header("Authorization", "token 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");
    }

}
