package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.utils.SpotifyConfig;

import java.util.Base64;

public class PostTokenMethod extends AbstractApiMethodV2 {

    public PostTokenMethod(){
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("token_spotify_url"));
        request.header("Authorization", "Basic "+ Base64.getEncoder().encodeToString("0a50f7a666f4463ca4a522e0f0784ebc:bba625d406a9422eb14e081ad9b8a338".getBytes()));
        request.header("Content-Type", "application/x-www-form-urlencoded");
        request.formParam("grant_type","authorization_code");
        request.formParam("redirect_uri","http://localhost:8888/callback");
        request.formParam("code", SpotifyConfig.getProperty("auth_code"));
    }
}
