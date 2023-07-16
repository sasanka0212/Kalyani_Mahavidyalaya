package com.example.kalyanimahavidyalaya.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kalyanimahavidyalaya.R;
import com.example.kalyanimahavidyalaya.ui.notice.DownloadNoticeActivity;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter> {

    private Context context;
    private ArrayList<String> images;

    public GalleryAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false);
        return new GalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdapter holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(images.get(position)).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DownloadNoticeActivity.class);
                intent.putExtra("image", images.get(position));
                intent.putExtra("imageName", "");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class GalleryViewAdapter extends RecyclerView.ViewHolder {

        ImageView image;

        public GalleryViewAdapter(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }

}
