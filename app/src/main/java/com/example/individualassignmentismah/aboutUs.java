package com.example.individualassignmentismah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class aboutUs extends AppCompatActivity {

    TextView youtube, github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        youtube = findViewById(R.id.youtubes);
        youtube.setMovementMethod(LinkMovementMethod.getInstance());

        github = findViewById(R.id.githubs);
        github.setMovementMethod(LinkMovementMethod.getInstance());
    }
}