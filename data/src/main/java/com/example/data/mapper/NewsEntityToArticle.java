package com.example.data.mapper;

import com.example.data.model.NewsArticle;
import com.example.data.repo.local.NewsEntity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsEntityToArticle implements Function<List<NewsEntity>, List<NewsArticle>> {

    @Override
    public List<NewsArticle> apply(@NotNull List<NewsEntity> newsEntities) {
        List<NewsArticle> articleList = new ArrayList<>();
        for (NewsEntity entity : newsEntities) {
            articleList.add(new NewsArticle(entity.newsDate, entity.image, entity.title, entity.newsDescription, entity.newsDescription));
        }
        return articleList;
    }
}
