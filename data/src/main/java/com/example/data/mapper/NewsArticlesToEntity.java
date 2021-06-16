package com.example.data.mapper;

import com.example.data.model.NewsArticle;
import com.example.data.repo.local.NewsEntity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsArticlesToEntity implements Function<List<NewsArticle>, List<NewsEntity>> {
    @Override
    public List<NewsEntity> apply(@NotNull List<NewsArticle> articles) {
        List<NewsEntity> entityList = new ArrayList<>();
        for (NewsArticle article : articles) {
            NewsEntity entity = new NewsEntity();
            entity.image = article.imageUrl;
            entity.title = article.title;
            entity.newsDate = article.date;
            entity.newsContent = article.content;
            entity.newsDescription = article.description;
            entityList.add(entity);
        }
        return  entityList;
    }
}
