package com.example.sumitasharma.joketellingandroidlibrary.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class JokeLibraryActivity extends AppCompatActivity {
    private static final String JOKES = "jokes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_library);
        TextView jokeTellingTextView = findViewById(R.id.joke_telling_text);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        jokeTellingTextView.setText(bundle.getString(JOKES));
    }

}
