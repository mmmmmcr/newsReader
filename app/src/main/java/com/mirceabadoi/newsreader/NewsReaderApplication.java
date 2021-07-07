package com.mirceabadoi.newsreader;

import android.app.Application;

import com.example.data.di.RepoModule;

public class NewsReaderApplication extends Application {
    private static RepoModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();

        this.repoModule = new RepoModule(this);
    }

    public static RepoModule getRepoProvider() {
        return repoModule;
    }
}
