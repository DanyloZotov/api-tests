package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.utils.SpotifyConfig;

public class PutEditPlaylistDetailsMethod extends AbstractApiMethodV2 {

    public PutEditPlaylistDetailsMethod (String playlistCode){
        super("api.spotify/_put/playlist/rq.json", null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("playlist_code", playlistCode);
        request.header("Authorization", "Bearer "+ SpotifyConfig.getProperty("spotify_token"));
        request.header("Content-Type", "application/json");
    }

}
