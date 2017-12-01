package com.express.gitanalyser;

import android.app.Application;

import com.express.gitanalyser.utils.StethoUtils;
import com.facebook.stetho.Stetho;

/**
 * Created by root on 1/12/17.
 */

public class GitAnalyserApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        StethoUtils.install(this);
    }
}
