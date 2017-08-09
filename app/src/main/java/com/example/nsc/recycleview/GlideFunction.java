package com.example.nsc.recycleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by NSC on 8/7/2017.
 */

public class GlideFunction {
    public static void GlideImage(String url, ImageView imageView, Context context){
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .into(imageView);

    }
}
