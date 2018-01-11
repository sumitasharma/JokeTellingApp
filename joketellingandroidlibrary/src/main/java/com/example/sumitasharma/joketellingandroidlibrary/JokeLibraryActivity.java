package com.example.sumitasharma.joketellingandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class JokeLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_library);
        TextView jokeTellingTextView = (TextView) findViewById(R.id.joke_telling_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Bundle bundle = getIntent().getExtras();
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, bundle.getString("jokes"), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        jokeTellingTextView.setText(bundle.getString("jokes"));
    }

}
