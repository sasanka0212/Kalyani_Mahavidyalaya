package com.example.kalyanimahavidyalaya.ebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.util.LogPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.downloader.Constants;
import com.example.kalyanimahavidyalaya.R;

import java.util.List;

public class EbookAdapeter extends RecyclerView.Adapter<EbookAdapeter.EbookViewHolder> {

    private Context context;
    private List<EbookData> list;

    public EbookAdapeter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false);
        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, @SuppressLint("RecyclerView")int position) {

        EbookData currentItem = list.get(position);

        holder.ebookName.setText(currentItem.getPdfTitle());

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/

        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(currentItem.getPdfUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName;
        private ImageView ebookDownload;

        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookName = itemView.findViewById(R.id.ebookName);
            ebookDownload = itemView.findViewById(R.id.ebookDownload);
        }
    }

}
