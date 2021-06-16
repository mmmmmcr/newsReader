package com.example.data.mapper;

import com.example.data.model.Article;
import com.example.data.repo.local.NewsEntity;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsArticlesToEntity implements Function<List<Article>, List<NewsEntity>> {
    @Override
    public List<NewsEntity> apply(@NotNull List<Article> articles) throws Exception {
        List<NewsEntity> entityList = new ArrayList<>();
        for(Article article : articles){
            NewsEntity entity = new NewsEntity();
            entity.image = article.imageUrl;
            entity.title = article.title;
            entity.newsDate = article.date;
            entity.newsDescription = article.description;
            entityList.add(entity);
        }
        return  entityList;
    }
}
