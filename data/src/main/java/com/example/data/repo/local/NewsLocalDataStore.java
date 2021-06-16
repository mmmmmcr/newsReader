package com.example.data.repo.local;

import com.example.data.mapper.NewsArticlesToEntity;
import com.example.data.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class NewsLocalDataStore {

    private NewsDao dao;

    public NewsLocalDataStore(NewsDao dao) {
        this.dao = dao;
    }

    public Single<List<NewsEntity>> getNewsList() {

        return dao.queryNews();
    }

    public Single<NewsEntity> getNewsItem(int id) {
        return dao.queryNewsItem(id);
    }

    public Completable deleteNewsItem(int id) {
        return dao.deleteNewsItem(id);
    }

    public Completable saveItem(NewsEntity news) {
        if(news.id == null) {
            return dao.insertToDo(news);
        } else {
            return dao.updateProfile(news.title, news.newsDescription, news.newsDate, news.image, news.priority, news.id);
        }
    }

    public Completable saveArticles(List<Article> articles) throws Exception {
        return dao.insertToDos(new NewsArticlesToEntity().apply(articles));
    }
}
