package com.solvd.carina.demo.api.spotify;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.utils.SpotifyConfig;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

public class GetAlbumMethod extends AbstractApiMethodV2 {
    public GetAlbumMethod(String id){
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("playlist_id", id);

        request.header("Authorization", "Bearer "+ SpotifyConfig.getProperty());
        request.header("Content-Type", "application/json");

    }
}
