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

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivityFragment extends Fragment {
    public final static String JOKES = "jokes";
    private Context mContext;
    @BindView(R.id.joke_telling_progress_bar) ProgressBar progressBar;
    @BindView(R.id.joke_telling_progress_text) TextView progressTextView;
    @BindView(R.id.tell_joke_button) Button tellJokeButton;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        AdsDisplay.displayAds(root, mContext);
//        progressBar = root.findViewById(R.id.joke_telling_progress_bar);
//        progressTextView = root.findViewById(R.id.joke_telling_progress_text);
       // Button tellJokeButton = root.findViewById(R.id.tell_joke_button);
        ButterKnife.bind(this, root);
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
