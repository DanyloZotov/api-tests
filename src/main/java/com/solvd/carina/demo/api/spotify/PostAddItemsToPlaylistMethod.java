package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.utils.SpotifyConfig;

public class PostAddItemsToPlaylistMethod extends AbstractApiMethodV2 {
    public PostAddItemsToPlaylistMethod(String playlistCode){
        super("api.spotify/_post/playlist/rq.json", "api.spotify/_post/playlist/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("playlist_code", playlistCode);
        request.header("Authorization", "Bearer "+ SpotifyConfig.getProperty("spotify_token"));
        request.header("Content-Type", "application/json");
    }
}
