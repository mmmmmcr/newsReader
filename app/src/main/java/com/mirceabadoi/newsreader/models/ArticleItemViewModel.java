package com.mirceabadoi.newsreader.models;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel {
    @Nullable
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> dateAndTime;
    public final ObservableField<String> title;
    public final ObservableField<String> contentDescription;

    public ArticleItemViewModel(String date, String title, String content) {
        this.imageUrl = new ObservableField<>();
        this.imageUrl.set("https://homepages.cae.wisc.edu/~ece533/images/fruits.png");
        this.dateAndTime = new ObservableField<>();
        this.title = new ObservableField<>();
        this.contentDescription = new ObservableField<>();
        this.dateAndTime.set(date);
        this.title.set(title);
        this.contentDescription.set(content);
    }
}