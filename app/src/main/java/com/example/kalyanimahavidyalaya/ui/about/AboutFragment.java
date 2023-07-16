package com.example.kalyanimahavidyalaya.ui.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kalyanimahavidyalaya.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;
    private ImageView clg_img;

    private ImageView mapkly;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 1000;
    final long PERIOD_MS = 5000;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_cs, "Computer Science", "Computer Science is one of the highest paying course now-a-days. Currently we take 40 regular students and 5 minority students."));
        list.add(new CourseModel(R.drawable.ic_math, "Mathematics", "Mathematics is the mother of all science subjects. Currently we take 35 regular students and 7 minority students."));
        list.add(new CourseModel(R.drawable.ic_physics, "Physics", "Physics is the god of science subjects. Currently we take 45 regular students and 5 minority students."));
        list.add(new CourseModel(R.drawable.ic_statistics, "Statistics", "Statistics is the most required subject for Data Science. Currently we take 30 regular students only."));
        list.add(new CourseModel(R.drawable.ic_economics, "Economics", "Economics is one of the popular subject in recent times. Currently we take 35 regular students and 4 minority students."));
        list.add(new CourseModel(R.drawable.ic_geography, "Geography", "Geography is the Earth and we prefer this subject. Currently we take 50 regular students and 10 minority students."));

        adapter = new CourseAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);
        mapkly = view.findViewById(R.id.mapkly);

        mapkly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0, 0?q=Kalyani Mahavidyalaya, Kalyani");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        clg_img = view.findViewById(R.id.clg_img);
        Glide.with(getContext()).load(R.drawable.img2).into(clg_img);

        viewPager.setAdapter(adapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == list.size()-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };


        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        return view;
    }
}