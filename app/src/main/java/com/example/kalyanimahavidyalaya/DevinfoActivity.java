package com.example.kalyanimahavidyalaya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class DevinfoActivity extends AppCompatActivity implements View.OnClickListener {

    CardView sasankaFb, sasankaGit, sasankaIn;
    ImageView devImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devinfo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        devImage = findViewById(R.id.devImage);
        sasankaFb = findViewById(R.id.sasankaFb);
        sasankaGit = findViewById(R.id.sasankaGit);
        sasankaIn = findViewById(R.id.sasankaIn);

        Glide.with(this).load(R.drawable.sasanka).into(devImage);

        sasankaFb.setOnClickListener(this);
        sasankaGit.setOnClickListener(this);
        sasankaIn.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.sasankaFb:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/sasanka.kundu.02/"));
                startActivity(intent);
                break;
            case R.id.sasankaGit:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/sasanka0212"));
                startActivity(intent);
                break;
            case R.id.sasankaIn:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/sasanka-kundu-03b159210/"));
                startActivity(intent);
                break;
        }
    }
}