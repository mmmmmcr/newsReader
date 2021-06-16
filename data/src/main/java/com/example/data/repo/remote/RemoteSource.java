package com.example.data.repo.remote;

import com.example.data.mapper.NewsDtoMapper;
import com.example.data.model.NewsArticle;

import java.util.List;
import java.util.Locale;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RemoteSource {
    private static final String API_KEY = "7da6b88ba5a7463994eb22961ea43aa0";
    private final NewsAPI newsAPI;

    public RemoteSource(NewsAPI newsAPI) {
        this.newsAPI = newsAPI;
    }

    public Single<List<NewsArticle>> getNewsArticles() {
        return newsAPI.getNewsArticles(API_KEY, Locale.getDefault().getLanguage())
                .map(new NewsDtoMapper())
                .subscribeOn(Schedulers.io());
    }
}
