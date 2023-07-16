package com.example.kalyanimahavidyalaya.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kalyanimahavidyalaya.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment, mathematicsDepartment, physicsDepartment, statisticsDepartment, economicsDepartment, geographyDepartment;
    private LinearLayout csNoData, mathematicsNoData, physicsNoData, statisticsNoData, economicsNoData, geographyNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6;

    private DatabaseReference databaseReference, dbRef;
    private TeacherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);
        csDepartment = view.findViewById(R.id.csDepartment);
        mathematicsDepartment = view.findViewById(R.id.mathematicsDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        statisticsDepartment = view.findViewById(R.id.statisticsDepartment);
        economicsDepartment = view.findViewById(R.id.economicsDepartment);
        geographyDepartment = view.findViewById(R.id.geographyDepartment);

        csNoData = view.findViewById(R.id.csNoData);
        mathematicsNoData = view.findViewById(R.id.mathematicsNoData);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        statisticsNoData = view.findViewById(R.id.statisticsNoData);
        economicsNoData = view.findViewById(R.id.economicsNoData);
        geographyNoData = view.findViewById(R.id.geographyNoData);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        mathematicsDepartment();
        physicsDepartment();
        statisticsDepartment();
        economicsDepartment();
        geographyDepartment();

        return view;
    }

    private void csDepartment() {
        dbRef = databaseReference.child("Computer Sc");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                } else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathematicsDepartment() {
        dbRef = databaseReference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    mathematicsNoData.setVisibility(View.VISIBLE);
                    mathematicsDepartment.setVisibility(View.GONE);
                } else {
                    mathematicsNoData.setVisibility(View.GONE);
                    mathematicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathematicsDepartment.setHasFixedSize(true);
                    mathematicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    mathematicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void physicsDepartment() {
        dbRef = databaseReference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                } else {
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void statisticsDepartment() {
        dbRef = databaseReference.child("Statistics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    statisticsNoData.setVisibility(View.VISIBLE);
                    statisticsDepartment.setVisibility(View.GONE);
                } else {
                    statisticsNoData.setVisibility(View.GONE);
                    statisticsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    statisticsDepartment.setHasFixedSize(true);
                    statisticsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    statisticsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void economicsDepartment() {
        dbRef = databaseReference.child("Economics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    economicsNoData.setVisibility(View.VISIBLE);
                    economicsDepartment.setVisibility(View.GONE);
                } else {
                    economicsNoData.setVisibility(View.GONE);
                    economicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    economicsDepartment.setHasFixedSize(true);
                    economicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    economicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void geographyDepartment() {
        dbRef = databaseReference.child("Geography");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    geographyNoData.setVisibility(View.VISIBLE);
                    geographyDepartment.setVisibility(View.GONE);
                } else {
                    geographyNoData.setVisibility(View.GONE);
                    geographyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    geographyDepartment.setHasFixedSize(true);
                    geographyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    geographyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}