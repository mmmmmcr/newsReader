package com.example.data.mapper;

import com.example.data.model.Article;
import com.example.data.repo.local.NewsEntity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsEntityToArticle implements Function<List<NewsEntity>, List<Article>>  {

    @Override
    public List<Article> apply(@NotNull List<NewsEntity> newsEntities) throws Exception {
        List<Article> articleList = new ArrayList<>();
        for (NewsEntity entity : newsEntities){
            articleList.add(new Article(entity.newsDate, entity.image, entity.title, entity.newsDescription, entity.newsDescription));
        }
        return  articleList;
    }
}
