package com.example.data.repo.local;

import com.example.data.mapper.NewsArticlesToEntity;
import com.example.data.mapper.NewsEntityToArticle;
import com.example.data.model.NewsArticle;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalDataStore {

    private final NewsDao dao;

    public NewsLocalDataStore(NewsDao dao) {
        this.dao = dao;
    }

    public Single<List<NewsArticle>> getNewsList() {
        return dao.queryNews().map(new NewsEntityToArticle());
    }

    public Single<NewsEntity> getNewsItem(int id) {
        return dao.queryNewsItem(id);
    }

    public Completable deleteNews() {
        return dao.deleteAllNews();
    }

    public void saveArticles(List<NewsArticle> articles) {
        deleteNews().andThen(Single.just(articles).map(new NewsArticlesToEntity())
                .flatMapCompletable((entityList) -> dao.insertArticles(entityList)))
                .subscribeOn(Schedulers.io())
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Error saving articles!"));
    }
}
