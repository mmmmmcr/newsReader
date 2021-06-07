package com.mirceabadoi.newsreader.models;

import android.app.Application;
import android.widget.Toast;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.data.repo.NewsRepository;
import com.mirceabadoi.newsreader.ClicksHandler;
import com.mirceabadoi.newsreader.mapper.ArticleToArticleViewModelMapper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {
    private Disposable disposable;
    public final ObservableList<ArticleItemViewModel> newsList;
    Application application;
    private ClicksHandler handler;
    private NewsRepository repo;

    public NewsListViewModel(Application application, NewsRepository repo) {
        this.application = application;
        this.repo = repo;
        newsList = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        disposable = repo.getNewsArticles().map(new ArticleToArticleViewModelMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesError(Throwable throwable) {
        Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show();
    }

    private void onNewsArticlesReceived(List<ArticleItemViewModel> articleItemViewModels) {
        newsList.addAll(articleItemViewModels);
    }

    public void openNewsApiProviderSite(){
        handler.onNewsApiReference();
    }

    public void setHandler(ClicksHandler handler) {
        this.handler = handler;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
