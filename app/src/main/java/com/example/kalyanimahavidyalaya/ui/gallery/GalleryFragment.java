package com.example.kalyanimahavidyalaya.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kalyanimahavidyalaya.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GalleryFragment extends Fragment {

    private RecyclerView annualdayRecycler, independenceRecycler, republicRecycler, othersRecycler;
    private GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        annualdayRecycler = view.findViewById(R.id.annualdayRecycler);
        independenceRecycler = view.findViewById(R.id.independenceRecycler);
        republicRecycler = view.findViewById(R.id.republicRecycler);
        othersRecycler = view.findViewById(R.id.othersRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getAnnualdayImage();
        getIndependenceImage();
        getRepublicImage();
        getOthersImage();

        return view;
    }

    private void getOthersImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            ArrayList<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    othersRecycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String data = (String) snapshot.getValue();
                        imageList.add(data);
                    }
                    Collections.reverse(imageList);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                othersRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                othersRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRepublicImage() {
        reference.child("Republic Day").addValueEventListener(new ValueEventListener() {
            ArrayList<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    republicRecycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String data = (String) snapshot.getValue();
                        imageList.add(data);
                    }
                    Collections.reverse(imageList);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                republicRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                republicRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIndependenceImage() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {
            ArrayList<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    independenceRecycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String data = (String) snapshot.getValue();
                        imageList.add(data);
                    }
                    Collections.reverse(imageList);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                independenceRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                independenceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAnnualdayImage() {
        reference.child("Annual Day").addValueEventListener(new ValueEventListener() {
            ArrayList<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    annualdayRecycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String data = (String) snapshot.getValue();
                        imageList.add(data);
                    }
                    Collections.reverse(imageList);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                annualdayRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                annualdayRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}