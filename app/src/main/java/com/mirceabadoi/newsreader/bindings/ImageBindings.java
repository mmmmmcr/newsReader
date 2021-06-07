package com.mirceabadoi.newsreader.bindings;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.mirceabadoi.newsreader.R;

public class ImageBindings {
    @BindingAdapter({"imageUrl"})
    public static void setImage(ImageView image, @Nullable String url) {
        Glide.with(image.getContext())
                .load(url)
                .transform(new CenterCrop(), new RoundedCorners(20))
                .fallback(R.drawable.ic_launcher_background)
                .into(image);
    }
}
