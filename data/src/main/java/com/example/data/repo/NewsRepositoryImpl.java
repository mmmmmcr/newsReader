package com.example.data.repo;

import androidx.annotation.NonNull;

import com.example.data.R;
import com.example.data.mapper.NewsDtoMapper;
import com.example.data.mapper.NewsEntityToArticle;
import com.example.data.model.Article;
import com.example.data.repo.local.NewsLocalDataStore;
import com.example.data.repo.remote.NewsRepository;
import com.example.data.repo.remote.RemoteSource;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsRepositoryImpl implements NewsRepository {
    RemoteSource source;
    NewsLocalDataStore localDataStore;

    public NewsRepositoryImpl(RemoteSource source, NewsLocalDataStore localDataStore) {
        this.source = source;
        this.localDataStore = localDataStore;
    }
    @NonNull
    @NotNull
    @Override
    public Single<List<Article>> getNewsArticles() {

        return source.getNewsArticles().map(new NewsDtoMapper())
                .doOnSuccess(localDataStore::saveArticles)
                .onErrorResumeNext(localDataStore.getNewsList().map(new NewsEntityToArticle()));

    }
}
