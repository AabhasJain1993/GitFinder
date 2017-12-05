package com.express.gitanalyser.utils;

import com.express.gitanalyser.api.APIClient;
import com.express.gitanalyser.api.RepositoryAPI;

/**
 * Created by Aabhas_Jain on 12/5/2017.
 */

public class ApiHelper {

    private static RepositoryAPI mRepositoryAPI = null;
    public static RepositoryAPI getAPInterface() {

        if(mRepositoryAPI == null) {
            mRepositoryAPI = APIClient.getInstance().create(RepositoryAPI.class);
        }

        return mRepositoryAPI;
    }
}
