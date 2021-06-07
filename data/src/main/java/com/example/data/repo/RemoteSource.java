package com.example.data.repo;

import com.example.data.dtos.ArticleListDto;

import java.util.Locale;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RemoteSource {
    private static final String API_KEY = "7da6b88ba5a7463994eb22961ea43aa0";
    NewsAPI newsAPI;

    public RemoteSource(NewsAPI newsAPI) {
        this.newsAPI = newsAPI;
    }

    public Single<ArticleListDto> getNewsArticles() {
        return newsAPI.getNewsArticles(API_KEY, Locale.getDefault().getLanguage())
                .subscribeOn(Schedulers.io());
    }
}
