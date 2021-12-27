package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;

public class GetAuthorizationMethod extends AbstractApiMethodV2 {
    public GetAuthorizationMethod(){
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("token_spotify_url"));
        replaceUrlPlaceholder("client_id", URLEncoder.encode("0a50f7a666f4463ca4a522e0f0784ebc"));
        replaceUrlPlaceholder("scope", URLEncoder.encode("user-read-private"));
        replaceUrlPlaceholder("redirect_url", URLEncoder.encode("http://localhost:8888/callback"));
        //request.formParam("grant_type", "client_credentials");
        //request.header("Authorization", "Basic "+ Base64.getEncoder().encodeToString("0a50f7a666f4463ca4a522e0f0784ebc:bba625d406a9422eb14e081ad9b8a338".getBytes()));
        //request.header("Content-Type", "application/x-www-form-urlencoded");

    }
}
