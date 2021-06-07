package com.example.data.repo;

import androidx.annotation.NonNull;

import com.example.data.mapper.NewsDtoMapper;
import com.example.data.model.Article;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;

public class NewsRepositoryImpl implements NewsRepository {
    RemoteSource source;

    public NewsRepositoryImpl(RemoteSource source) {
        this.source = source;
    }

    @NonNull
    @NotNull
    @Override
    public Single<List<Article>> getNewsArticles() {
        return source.getNewsArticles().map(new NewsDtoMapper());
    }
}
