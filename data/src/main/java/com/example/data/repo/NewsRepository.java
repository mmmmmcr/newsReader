package com.example.data.repo;

import androidx.annotation.NonNull;

import com.example.data.model.Article;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();


}
