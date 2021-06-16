package com.example.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.data.repo.local.NewsLocalDataStore;
import com.example.data.repo.local.NewsDatabase;
import com.example.data.repo.remote.HttpClientFactory;
import com.example.data.repo.remote.NewsRepository;
import com.example.data.repo.NewsRepositoryImpl;
import com.example.data.repo.remote.RemoteSource;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;
    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideNewsLocalSource());
    }

    private RemoteSource provideNewsRemoteSource() {
        return new RemoteSource(httpClientFactory.getNewsApi());
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
                            NewsDatabase.class, "News.db")
                            .build();
                }
            }
        }
        return database;
    }
}
