package com.mirceabadoi.newsreader.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirceabadoi.newsreader.adapter.NewsAdapter;
import com.mirceabadoi.newsreader.models.ArticleItemViewModel;

import java.util.List;

public class NewsRecyclerBindings {
    @BindingAdapter({"news"})
    public static void addNews(RecyclerView recyclerView, final List<ArticleItemViewModel> newsList) {
        NewsAdapter newsAdapter = (NewsAdapter) recyclerView.getAdapter();

        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(newsAdapter);
        }

        newsAdapter.setItems(newsList);
    }
}
