package com.example.data.repo.remote;

import androidx.annotation.NonNull;

import com.example.data.model.NewsArticle;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {

    @NonNull
    Single<List<NewsArticle>> getNewsArticles();


}
