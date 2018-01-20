package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivityFragment extends Fragment {
    public final static String JOKES = "jokes";
    String newJoke;
    private Context mContext;
    private ProgressBar progressBar;
    private TextView progressTextView;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        AdsDisplay.displayAds(root, mContext);
        progressBar = root.findViewById(R.id.joke_telling_progress_bar);
        progressTextView = root.findViewById(R.id.joke_telling_progress_text);
        Button tellJokeButton = root.findViewById(R.id.tell_joke_button);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MainActivityFragment", "Calling TellJokes");
                tellJoke(view);
            }
        });
        Log.i("MainActivityFragment", "MainActivityFragment of main called");
        return root;
    }

    private void tellJoke(View view) {

        progressBar.setVisibility(View.VISIBLE);
        progressTextView.setVisibility(View.VISIBLE);

        new EndpointsAsyncTask(progressBar, progressTextView).execute(new Pair<>(mContext, "Manfred"));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
