package com.example.data.di;

import android.app.Application;
import android.content.Context;

import com.example.data.repo.HttpClientFactory;
import com.example.data.repo.NewsRepository;
import com.example.data.repo.NewsRepositoryImpl;
import com.example.data.repo.RemoteSource;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private RemoteSource provideNewsRemoteSource() {
        return new RemoteSource(httpClientFactory.getNewsApi());
    }
}
