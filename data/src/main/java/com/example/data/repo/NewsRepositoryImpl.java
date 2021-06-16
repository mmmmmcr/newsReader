package com.example.data.repo;

import androidx.annotation.NonNull;

import com.example.data.model.NewsArticle;
import com.example.data.repo.local.NewsLocalDataStore;
import com.example.data.repo.remote.NewsRepository;
import com.example.data.repo.remote.RemoteSource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class NewsRepositoryImpl implements NewsRepository {
    private final RemoteSource remoteDataStore;
    private final NewsLocalDataStore localDataStore;

    public NewsRepositoryImpl(RemoteSource remoteDataStore, NewsLocalDataStore localDataStore) {
        this.remoteDataStore = remoteDataStore;
        this.localDataStore = localDataStore;
    }

    @NonNull
    @Override
    public Single<List<NewsArticle>> getNewsArticles() {

        return remoteDataStore.getNewsArticles()
                .doOnSuccess(localDataStore::saveArticles)
                .onErrorResumeNext(new Function<Throwable, SingleSource<? extends List<NewsArticle>>>() {
                    @Override
                    public SingleSource<? extends List<NewsArticle>> apply(@NotNull Throwable throwable) throws Exception {
                        return localDataStore.getNewsList();
                    }
                });

    }
}
