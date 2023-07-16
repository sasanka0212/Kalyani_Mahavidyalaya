package com.example.kalyanimahavidyalaya.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kalyanimahavidyalaya.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.net.URI;


public class HomeFragment extends Fragment {

    private int[] images;
    private SliderAdapter adapter;
    private SliderView sliderView;
    private ImageView map;
    private TextView kalyaniMail, kalyaniFb, kalyaniWeb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.sliderView);
        kalyaniMail = view.findViewById(R.id.kalyaniMail);
        kalyaniFb = view.findViewById(R.id.kalyaniFb);
        kalyaniWeb = view.findViewById(R.id.kalyaniWeb);
        images = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

        adapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(adapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();

        kalyaniMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendMail = new Intent(Intent.ACTION_SENDTO);
                sendMail.setData(Uri.parse("mailto:"));
                sendMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"klymahavidyalaya@gmail.com"});
                startActivity(Intent.createChooser(sendMail, "Mail via"));
            }
        });

        kalyaniFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/people/Kalyani-Mahavidyalaya-College/100064836182508/"));
                startActivity(intent);
            }
        });

        kalyaniWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://kalyanimahavidyalaya.ac.in/website/"));
                startActivity(intent);
            }
        });

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Kalyani Mahavidyalaya, Kalyani");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}