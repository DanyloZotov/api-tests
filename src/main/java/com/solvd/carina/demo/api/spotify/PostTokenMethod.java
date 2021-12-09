package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;

public class PostTokenMethod extends AbstractApiMethodV2 {
    public PostTokenMethod(){
        //super("api.spotify/_post/token/rq.json", null);
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.formParam("grant_type", "client_credentials");
        request.header("Authorization", "Basic "+ Base64.getEncoder().encodeToString("0a50f7a666f4463ca4a522e0f0784ebc:bba625d406a9422eb14e081ad9b8a338".getBytes()));
        request.header("Content-Type", "application/x-www-form-urlencoded");

    }
}
