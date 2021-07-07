package com.example.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.data.repo.NewsRepositoryImpl;
import com.example.data.repo.local.NewsDatabase;
import com.example.data.repo.local.NewsLocalDataStore;
import com.example.data.repo.remote.HttpClientFactory;
import com.example.data.repo.remote.NewsRepository;
import com.example.data.repo.remote.NewsRemoteDataStore;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    public static final String NEWS_DB = "News.db";
    @NonNull
    private final Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;
    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideNewsLocalSource());
    }

    private NewsRemoteDataStore provideNewsRemoteSource() {
        return new NewsRemoteDataStore(httpClientFactory.getNewsApi());
    }

    private NewsLocalDataStore provideNewsLocalSource() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.newsDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, NEWS_DB)
                            .build();
                }
            }
        }
        return database;
    }
}
