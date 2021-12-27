package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.utils.SpotifyConfig;

public class GetFollowedArtistsMethod extends AbstractApiMethodV2 {

    public GetFollowedArtistsMethod(){
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.header("Authorization", "Bearer "+ SpotifyConfig.getProperty("spotify_token"));
        request.header("Content-Type", "application/json");

    }
}
