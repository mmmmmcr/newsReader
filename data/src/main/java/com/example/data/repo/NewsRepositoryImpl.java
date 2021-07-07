package com.example.data.repo;

import androidx.annotation.NonNull;

import com.example.data.model.NewsArticle;
import com.example.data.repo.local.NewsLocalDataStore;
import com.example.data.repo.remote.NewsRepository;
import com.example.data.repo.remote.NewsRemoteDataStore;

import java.util.List;

import io.reactivex.Single;

public class NewsRepositoryImpl implements NewsRepository {
    private final NewsRemoteDataStore remoteDataStore;
    private final NewsLocalDataStore localDataStore;

    public NewsRepositoryImpl(NewsRemoteDataStore remoteDataStore, NewsLocalDataStore localDataStore) {
        this.remoteDataStore = remoteDataStore;
        this.localDataStore = localDataStore;
    }

    @NonNull
    @Override
    public Single<List<NewsArticle>> getNewsArticles() {

        return remoteDataStore.getNewsArticles()
                .doOnSuccess(localDataStore::saveArticles)
                .onErrorResumeNext(throwable -> localDataStore.getNewsList());

    }
}
