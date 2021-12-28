package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.utils.SpotifyConfig;

import java.util.ArrayList;

public class DeleteItemsFromPlaylistMethod extends AbstractApiMethodV2 {
    public DeleteItemsFromPlaylistMethod(String playlistCode, String song){
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("playlist_code", playlistCode);
        request.header("Authorization", "Bearer "+ SpotifyConfig.getProperty("spotify_token"));
        request.header("Content-Type", "application/json");
        request.body("{\"uris\": [\""+song+"\"]}");
    }
}
