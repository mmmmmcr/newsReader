package com.mirceabadoi.newsreader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirceabadoi.newsreader.databinding.NewsListItemBinding;
import com.mirceabadoi.newsreader.models.ArticleItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private List<ArticleItemViewModel> newsList;

    @NonNull
    @NotNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        NewsListItemBinding binder = NewsListItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new NewsHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsHolder holder, int position) {
        holder.binding.setViewModel(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setItems(List<ArticleItemViewModel> news) {
        this.newsList = news;
        notifyDataSetChanged();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        final NewsListItemBinding binding;

        public NewsHolder(NewsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
