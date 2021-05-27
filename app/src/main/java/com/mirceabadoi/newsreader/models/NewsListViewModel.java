package com.mirceabadoi.newsreader.models;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {
    public final ObservableList<ArticleItemViewModel> newsList;

    public NewsListViewModel() {
        newsList = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii." +
                " Text lung ca sa testam ca nu se fac mai mult de 2 randuri si se face ellipsize"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
        newsList.add(new ArticleItemViewModel("1.10.2021", "Stire de test", "Aceasta stire este una de test. Aici ar trebui sa apara continutul stirii"));
    }
}
